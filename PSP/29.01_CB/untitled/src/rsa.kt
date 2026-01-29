import java.nio.file.Files
import java.nio.file.Paths
import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import java.util.Base64

fun main() {
    val pubFile = "publica.der"
    val privFile = "privada.der"

    // Якщо файлів ще нема — генеруємо RSA KeyPair і зберігаємо у .der
    if (!Files.exists(Paths.get(pubFile)) || !Files.exists(Paths.get(privFile))) {
        val gen = KeyPairGenerator.getInstance("RSA")
        gen.initialize(2048)
        val key = gen.generateKeyPair()

        guardar(file = pubFile, bytes = key.public.encoded)
        guardar(file = privFile, bytes = key.private.encoded)
    }

    // Завантаження ключів з файлів
    val publica = cargarpublica(file = pubFile)
    val privada = cargarprivada(file = privFile)

    // Вивід у Base64
    println(Base64.getEncoder().encodeToString(publica.encoded))
    println(Base64.getEncoder().encodeToString(privada.encoded))
}

fun guardar(file: String, bytes: ByteArray) =
    Files.write(Paths.get(file), bytes)

fun cargarpublica(file: String): PublicKey {
    val contenido = Files.readAllBytes(Paths.get(file))
    return KeyFactory.getInstance("RSA")
        .generatePublic(X509EncodedKeySpec(contenido))
}

fun cargarprivada(file: String): PrivateKey {
    val contenido = Files.readAllBytes(Paths.get(file))
    return KeyFactory.getInstance("RSA")
        .generatePrivate(PKCS8EncodedKeySpec(contenido))
}
