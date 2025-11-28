import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {
    try {
        println("Arrancando servidor LOGIN...")
        val server = ServerSocket(6000)
        println("Servidor escuchando en puerto 6000...")

        val cliente = server.accept()
        println(">> Cliente conectado: ${cliente.inetAddress.hostAddress}")

        val entrada = BufferedReader(InputStreamReader(cliente.getInputStream()))
        val salida = PrintWriter(cliente.getOutputStream(), true)

        val linea = entrada.readLine()
        println(">> Mensaje recibido: $linea")

        // Esperamos "usuario;contrasena"
        val partes = linea.split(";")
        val usuario = partes.getOrNull(0)?.trim() ?: ""
        val pass = partes.getOrNull(1)?.trim() ?: ""

        println(">> Usuario='$usuario', pass='$pass'")

        val loginCorrecto = (usuario == "admin" && pass == "1234")
        val respuesta = if (loginCorrecto) "OK" else "ERROR"

        println(">> Enviando respuesta: $respuesta")
        salida.println(respuesta)

        entrada.close()
        salida.close()
        cliente.close()
        server.close()
        println("Servidor LOGIN cerrado.")

    } catch (e: Exception) {
        e.printStackTrace()
    }
}
