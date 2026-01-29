import java.io.DataInputStream
import java.io.DataOutputStream
import javax.net.ssl.SSLSocketFactory

fun main() {
    // 1. IMPORTANTE: Configurar el TrustStore (Almacén de Confianza)
    // Como tu certificado es autofirmado, el cliente necesita confiar explícitamente en él.
    // Usamos el mismo fichero "Almacen" porque contiene la clave pública del servidor.
    System.setProperty("javax.net.ssl.trustStore", "Almacen")
    System.setProperty("javax.net.ssl.trustStorePassword", "1234567")

    try {
        println("⏳ Intentando conectar al servidor seguro...")

        // 2. Crear la factoría de Sockets para el Cliente
        val clientFactory = SSLSocketFactory.getDefault() as SSLSocketFactory

        // 3. Conectar a localhost (tu propia máquina) en el puerto 2000
        // Tu compañero debe escribir TU dirección IP aquí:
        val socket = clientFactory.createSocket("192.168.2.198", 2000)

        // 4. Canales de comunicación
        val salida = DataOutputStream(socket.getOutputStream())
        val entrada = DataInputStream(socket.getInputStream())

        // 5. Enviar mensaje secreto al servidor
        println("📤 Enviando mensaje seguro...")
        salida.writeUTF("¡Hola! Esto es un mensaje cifrado desde Kotlin.")

        // (Opcional) Leer respuesta del servidor
        val respuesta = entrada.readUTF()
        println("📥 Respuesta del Servidor: $respuesta")

        // 6. Cerrar
        salida.close()
        entrada.close()
        socket.close()
        println("✅ Cliente finalizado.")

    } catch (e: Exception) {
        println("❌ Error en el cliente: ${e.message}")
        // Si ves un error de 'PKIX', es que no encuentra el archivo Almacen o la contraseña está mal
        e.printStackTrace()
    }
}