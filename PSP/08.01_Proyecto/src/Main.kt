import java.security.MessageDigest
import java.security.SecureRandom
import java.util.Base64

data class User(
    val username: String,
    val saltBase64: String,
    val hashHex: String
)

object AuthApp {
    private val users = mutableMapOf<String, User>()

    fun register(username: String, password: String): String {
        if (username.isBlank() || password.isBlank())
            return "❌ Usuario o contraseña vacíos"

        if (users.containsKey(username))
            return "❌ El usuario ya existe"

        val salt = ByteArray(16).also { SecureRandom().nextBytes(it) }
        val hash = sha256Hex(salt + password.toByteArray())

        users[username] = User(
            username,
            Base64.getEncoder().encodeToString(salt),
            hash
        )

        // 🔐 PRINT DEL HASHEO
        println("\n--- DATOS DE SEGURIDAD ---")
        println("Usuario: $username")
        println("Salt (Base64): ${users[username]!!.saltBase64}")
        println("Hash (SHA-256): ${users[username]!!.hashHex}")
        println("-------------------------\n")

        return "✅ Usuario registrado correctamente"
    }

    fun login(username: String, password: String): String {
        val user = users[username] ?: return "❌ Usuario no existe"

        val salt = Base64.getDecoder().decode(user.saltBase64)
        val attemptHash = sha256Hex(salt + password.toByteArray())

        return if (constantTimeEquals(user.hashHex, attemptHash))
            "✅ Login correcto"
        else
            "❌ Contraseña incorrecta"
    }

    private fun sha256Hex(data: ByteArray): String {
        val md = MessageDigest.getInstance("SHA-256")
        return md.digest(data).joinToString("") { "%02x".format(it) }
    }

    private fun constantTimeEquals(a: String, b: String): Boolean {
        if (a.length != b.length) return false
        var result = 0
        for (i in a.indices) result = result or (a[i].code xor b[i].code)
        return result == 0
    }
}

fun main() {
    while (true) {
        println("1) Registrarse")
        println("2) Login")
        println("3) Salir")
        print("Opción: ")

        when (readLine()?.trim()) {
            "1" -> {
                print("Usuario: ")
                val u = readLine()?.trim().orEmpty()
                print("Contraseña: ")
                val p = readLine()?.trim().orEmpty()
                println(AuthApp.register(u, p))
            }
            "2" -> {
                print("Usuario: ")
                val u = readLine()?.trim().orEmpty()
                print("Contraseña: ")
                val p = readLine()?.trim().orEmpty()
                println(AuthApp.login(u, p))
            }
            "3" -> return
            else -> println("❌ Opción inválida")
        }
    }
}
