import java.security.MessageDigest

fun main() {
    // --- CAMBIA ESTO POR LA CONTRASEÑA QUE QUIERES CONVERTIR ---
    val textoParaHashear = "66ho"
    // -----------------------------------------------------------

    val bytes = MessageDigest.getInstance("SHA-256").digest(textoParaHashear.toByteArray())
    val hashHex = bytes.joinToString("") { "%02x".format(it) }

    println("--- RESULTADO ---")
    println("Texto original: $textoParaHashear")
    println("HASH SHA-256: $hashHex")
    println("-----------------")
    println("Copia el código largo de arriba (el hash) y úsalo en tu script de fuerza bruta.")
}