package app

import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.common.BitMatrix
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.origin
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import org.slf4j.event.Level
import java.io.File
import java.net.NetworkInterface
import java.security.KeyStore
import java.security.SecureRandom
import java.util.*
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

// --------- CONFIG RÁPIDA ----------
private const val HTTPS_PORT = 8443
private const val HTTP_PORT = 8080

// Cambia usuario/clave aquí (demo)
private const val USERNAME = "olek"
private const val PASSWORD = "1234"

// Ruta donde se guardan uploads
private val UPLOAD_DIR = File("./data/uploads")

// Keystore TLS (généralo con keytool)
private const val KEYSTORE_PATH = "./keystore/serverkeystore.jks"
private const val KEYSTORE_PASS = "changeit"
private const val KEY_ALIAS = "server"
// ----------------------------------

data class UserSession(val username: String, val sessionToken: String)

fun main() {
    UPLOAD_DIR.mkdirs()

    val roomToken = UUID.randomUUID().toString().substring(0, 8)

    // Usuario en memoria con PBKDF2 (hash + salt)
    val userDb = createInMemoryUserDb(USERNAME, PASSWORD)

    val env = applicationEngineEnvironment {
        module {
            appModule(roomToken, userDb)
        }

        // HTTP: redirige a HTTPS (útil para entrar fácil)
        connector {
            host = "0.0.0.0"
            port = HTTP_PORT
        }

        // HTTPS real (lo que pide el profe)
        sslConnector(
            keyStore = loadKeyStore(File(KEYSTORE_PATH), KEYSTORE_PASS),
            keyAlias = KEY_ALIAS,
            keyStorePassword = { KEYSTORE_PASS.toCharArray() },
            privateKeyPassword = { KEYSTORE_PASS.toCharArray() }
        ) {
            host = "0.0.0.0"
            port = HTTPS_PORT
        }
    }

    val server = embeddedServer(Netty, env)

    val lanIp = bestLanIp()
    val url = "https://$lanIp:$HTTPS_PORT/s/$roomToken"

    println("=== QR Secure Upload (LAN) ===")
    println("URL: $url")
    println(qrAscii(url))
    println("Login: $USERNAME / $PASSWORD")
    println("Uploads: ${UPLOAD_DIR.absolutePath}")
    println("--------------------------------")

    server.start(wait = true)
}

fun Application.appModule(roomToken: String, userDb: Map<String, UserRecord>) {
    install(CallLogging) { level = Level.INFO }

    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.application.environment.log.error("ERROR", cause)
            call.respond(HttpStatusCode.InternalServerError, "Error interno")
        }
    }

    install(Sessions) {
        cookie<UserSession>("SESSION") {
            cookie.path = "/"
            cookie.httpOnly = true
            cookie.secure = true
            cookie.extensions["SameSite"] = "Strict"
        }
    }

    routing {
        // Entras por http://IP:8080 y te manda al https://IP:8443/s/<token>
        get("/") {
            val lanIp = bestLanIp()
            call.respondRedirect("https://$lanIp:$HTTPS_PORT/s/$roomToken", permanent = false)
        }

        get("/s/{token}") {
            val t = call.parameters["token"].orEmpty()
            if (t != roomToken) {
                call.respond(HttpStatusCode.NotFound, "Sala no válida")
                return@get
            }

            val sess = call.sessions.get<UserSession>()
            if (sess == null) call.respondText(loginHtml(), ContentType.Text.Html)
            else call.respondText(uploadHtml(sess.username), ContentType.Text.Html)
        }

        post("/login") {
            val form = call.receiveParameters()
            val token = form["token"].orEmpty()
            val username = form["username"].orEmpty()
            val password = form["password"].orEmpty()

            if (token != roomToken) {
                call.respond(HttpStatusCode.Forbidden, "Sala no válida")
                return@post
            }

            val record = userDb[username]
            if (record == null || !verifyPassword(password.toCharArray(), record)) {
                call.respond(HttpStatusCode.Unauthorized, "Login incorrecto")
                return@post
            }

            call.sessions.set(UserSession(username, UUID.randomUUID().toString()))
            call.respondRedirect("/s/$roomToken", permanent = false)
        }

        post("/logout") {
            call.sessions.clear<UserSession>()
            call.respondRedirect("/s/$roomToken", permanent = false)
        }

        post("/upload") {
            val sess = call.sessions.get<UserSession>()
            if (sess == null) {
                call.respond(HttpStatusCode.Unauthorized, "No autenticado")
                return@post
            }

            val maxBytes = 5 * 1024 * 1024
            var saved: File? = null

            val multipart = call.receiveMultipart()
            multipart.forEachPart { part ->
                when (part) {
                    is PartData.FileItem -> {
                        val name = part.originalFileName ?: "image.jpg"
                        val bytes = part.streamProvider().readBytes()
                        if (bytes.size > maxBytes) {
                            part.dispose()
                            call.respond(HttpStatusCode.PayloadTooLarge, "Máx 5MB")
                            return@forEachPart
                        }

                        saved = saveUpload(sess.username, name, bytes)
                    }
                    else -> {}
                }
                part.dispose()
            }

            if (saved == null) {
                call.respond(HttpStatusCode.BadRequest, "No se recibió archivo")
                return@post
            }

            call.application.environment.log.info("UPLOAD user=${sess.username} file=${saved.name} ip=${call.request.origin.remoteAddress}")
            call.respondText(text = "OK: ${saved.name}")
        }
    }
}

// ------------------ HTML ------------------

private fun loginHtml(): String = """
<!doctype html>
<html lang="es"><head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Login</title>
<style>
body{font-family:system-ui,sans-serif;margin:24px;max-width:520px}
input,button{width:100%;padding:12px;margin:8px 0;font-size:16px}
.card{padding:16px;border:1px solid #ddd;border-radius:12px}
small{color:#666}
</style></head><body>
<h2>Acceso</h2>
<div class="card">
<form method="post" action="/login">
  <input type="hidden" name="token" id="tokenField"/>
  <input name="username" placeholder="Usuario" autocomplete="username" required>
  <input name="password" placeholder="Contraseña" type="password" autocomplete="current-password" required>
  <button type="submit">Entrar</button>
  <small>Red local. Tráfico cifrado con TLS.</small>
</form></div>
<script>
const parts = location.pathname.split("/");
document.getElementById("tokenField").value = parts[2] || "";
</script>
</body></html>
""".trimIndent()

private fun uploadHtml(user: String): String = """
<!doctype html>
<html lang="es"><head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Upload</title>
<style>
body{font-family:system-ui,sans-serif;margin:24px;max-width:520px}
input,button{width:100%;padding:12px;margin:8px 0;font-size:16px}
.card{padding:16px;border:1px solid #ddd;border-radius:12px}
.ok{color:#0a7}.err{color:#c22}
</style></head><body>
<h2>Subir foto</h2>
<p>Usuario: <b>$user</b></p>
<div class="card">
  <input id="file" type="file" accept="image/*" capture="environment">
  <button id="send">Enviar</button>
  <div id="msg"></div>
  <form method="post" action="/logout"><button type="submit">Salir</button></form>
</div>
<script>
const msg = document.getElementById("msg");
document.getElementById("send").addEventListener("click", async () => {
  const f = document.getElementById("file").files[0];
  if(!f){ msg.innerHTML="<p class='err'>Selecciona una foto</p>"; return; }
  const fd = new FormData(); fd.append("file", f, f.name);
  msg.textContent="Enviando...";
  const res = await fetch("/upload",{method:"POST",body:fd});
  const text = await res.text();
  msg.innerHTML = res.ok ? "<p class='ok'>"+text+"</p>" : "<p class='err'>"+text+"</p>";
});
</script>
</body></html>
""".trimIndent()

// ------------------ STORAGE ------------------

private fun saveUpload(username: String, originalName: String, bytes: ByteArray): File {
    val safe = originalName.replace(Regex("[^a-zA-Z0-9._-]"), "_").take(80)
    val ts = java.time.Instant.now().toString().replace(":", "-")
    val out = File(UPLOAD_DIR, "${ts}_${username}_$safe")
    out.writeBytes(bytes)
    return out
}

// ------------------ AUTH (PBKDF2) ------------------

data class UserRecord(val username: String, val salt: ByteArray, val hash: ByteArray)

private fun createInMemoryUserDb(username: String, password: String): Map<String, UserRecord> {
    val salt = ByteArray(16).also { SecureRandom().nextBytes(it) }
    val hash = pbkdf2(password.toCharArray(), salt)
    return mapOf(username to UserRecord(username, salt, hash))
}

private fun verifyPassword(password: CharArray, record: UserRecord): Boolean {
    val got = pbkdf2(password, record.salt)
    return constantTimeEquals(got, record.hash)
}

private fun pbkdf2(password: CharArray, salt: ByteArray): ByteArray {
    val spec = PBEKeySpec(password, salt, 120_000, 256)
    val skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
    return skf.generateSecret(spec).encoded
}

private fun constantTimeEquals(a: ByteArray, b: ByteArray): Boolean {
    if (a.size != b.size) return false
    var r = 0
    for (i in a.indices) r = r or (a[i].toInt() xor b[i].toInt())
    return r == 0
}

// ------------------ TLS KEYSTORE ------------------

private fun loadKeyStore(file: File, password: String): KeyStore {
    require(file.exists()) { "No existe keystore: ${file.absolutePath}" }
    val ks = KeyStore.getInstance("JKS")
    file.inputStream().use { ks.load(it, password.toCharArray()) }
    return ks
}

// ------------------ LAN IP + QR ASCII ------------------

private fun bestLanIp(): String {
    return try {
        val ifaces = NetworkInterface.getNetworkInterfaces().toList()
        val ips = ifaces
            .filter { it.isUp && !it.isLoopback && !it.isVirtual }
            .flatMap { it.inetAddresses.toList() }
            .filterIsInstance<java.net.Inet4Address>()
            .map { it.hostAddress }
            .filter { it.startsWith("192.") || it.startsWith("10.") || it.startsWith("172.") }
        ips.firstOrNull() ?: "127.0.0.1"
    } catch (_: Exception) {
        "127.0.0.1"
    }
}

private fun qrAscii(text: String, size: Int = 35): String {
    val writer = QRCodeWriter()
    val matrix = writer.encode(text, BarcodeFormat.QR_CODE, size, size)
    return buildAscii(matrix)
}

private fun buildAscii(m: BitMatrix): String {
    val sb = StringBuilder()
    val quiet = 2
    for (y in -quiet until m.height + quiet) {
        for (x in -quiet until m.width + quiet) {
            val on = (x in 0 until m.width && y in 0 until m.height && m[x, y])
            sb.append(if (on) "██" else "  ")
        }
        sb.append('\n')
    }
    return sb.toString()
}
