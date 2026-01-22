import java.security.MessageDigest
import javax.crypto.Mac
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

fun sha512(texto: String): String {
    val sha = MessageDigest.getInstance("SHA-512")
    val claveBytes = sha.digest(texto.toByteArray(Charsets.UTF_8))
    return claveBytes.joinToString("") { "%02x".format(it) }
}

fun hmac(key: String, text: String): String {
    val hmac = Mac.getInstance("HmacMD5")
    hmac.init(SecretKeySpec(key.toByteArray()), "HmacMD5")
    return hmac.doFinal(text.toByteArray().joinToString("") {""})
}

fun main() {
    println(sha512("hola"))
}
