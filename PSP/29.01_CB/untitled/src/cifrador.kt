import java.nio.file.Files
import java.nio.file.Paths
import java.security.KeyFactory
import java.security.PublicKey
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher
import java.util.Base64

fun main() {
    // EL COMPAÑERO DEBE PONER AQUÍ EL NOMBRE DEL ARCHIVO QUE TÚ LE PASASTE
    val rutaClavePublicaDeNazar = "publicaN.der"

    try {
        // 1. Cargar la clave pública de Nazar
        val clavePublica = cargarPublica(rutaClavePublicaDeNazar)

        // 2. Escribir el secreto
        val mensajeSecreto = "Hola Artur Lox"

        // 3. Cifrarlo
        val cipher = Cipher.getInstance("RSA")
        cipher.init(Cipher.ENCRYPT_MODE, clavePublica)
        val bytesCifrados = cipher.doFinal(mensajeSecreto.toByteArray())

        // 4. Convertir a Base64 para poder enviarlo por chat
        val textoParaEnviar = Base64.getEncoder().encodeToString(bytesCifrados)

        println("--- COPIA ESTE CÓDIGO Y MÁNDASELO A NAZAR ---")
        println(textoParaEnviar)
        println("-----------------------------------------------")

    } catch (e: Exception) {
        println("❌ Error: No encuentro el archivo 'publica.der' o está dañado.")
    }
}

fun cargarPublica(file: String): PublicKey {
    val bytes = Files.readAllBytes(Paths.get(file))
    val spec = X509EncodedKeySpec(bytes)
    return KeyFactory.getInstance("RSA").generatePublic(spec)
}