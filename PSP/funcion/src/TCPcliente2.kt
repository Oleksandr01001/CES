import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class TSPcliente2 {
    fun startcliente() {
        try {
            val cliente = Socket("127.0.0.1",6000)
            val leer = BufferedReader(InputStreamReader(cliente.getInputStream()))
            val escribir = PrintWriter(cliente.getOutputStream(), true)
            var mensaje: String?
            do {
                println("")
                print("Escribe un mensaje: ")
                mensaje = readLine()
                escribir.println(mensaje)
                print(leer.readLine())
            }while (mensaje != null && mensaje != "fin")
            // si esto no se hace BIND
            leer.close()
            escribir.close()
            cliente.close()

        } catch(e: Exception) {
            e.printStackTrace()
        }
    }
}

fun main() {
    val client = TSPcliente().startcliente()
}