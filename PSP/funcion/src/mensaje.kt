// Guardar como Main.kt (en CADA PC)
import java.awt.MouseInfo
import java.awt.Robot
import java.awt.event.InputEvent
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

// Puerto del servidor (móvil)
const val PUERTO_MOVIL = 6004
// -----------------------------------------------------------------
// 👇 ¡IMPORTANTE!
//    Aquí debes poner la IP que tiene tu MÓVIL en el Wi-Fi de la clase
// -----------------------------------------------------------------
const val TELEFONO_IP = "192.168.2.206" // <--- ¡CADA PC DEBE PONER LA IP DEL MÓVIL AQUÍ!

// El robot para mover el ratón de ESTE PC
val robot = Robot()
fun main() {
    println("Cliente de Ratón iniciado...")
    println("Intentando conectar al servidor (móvil) en $TELEFONO_IP:$PUERTO_MOVIL")

    try {
        // 1. Conectarse al móvil
        val socket = Socket(TELEFONO_IP, PUERTO_MOVIL)
        println("¡Conectado al servidor (móvil)!")

        val reader = BufferedReader(InputStreamReader(socket.inputStream))

        // 2. Bucle infinito para escuchar comandos
        while (true) {
            val comando = reader.readLine() ?: break // Si es nulo, el móvil se desconectó

            // 3. Ejecutar el comando recibido
            manejarComando(comando)
        }

    } catch (e: Exception) {
        println("Error de conexión: ${e.message}")
        e.printStackTrace()
    } finally {
        println("Desconectado.")
    }
}

fun manejarComando(comando: String) {
    // println("Comando recibido: $comando") // (Descomenta para depurar)

    when {
        comando.startsWith("MOVE:") -> {
            try {
                val partes = comando.substring(5).split(",")
                val dx = partes[0].toInt()
                val dy = partes[1].toInt()

                // Mover el ratón de ESTE PC
                val posActual = MouseInfo.getPointerInfo().location
                val nuevoX = posActual.x + dx
                val nuevoY = posActual.y + dy
                robot.mouseMove(nuevoX, nuevoY)

            } catch (e: Exception) { /* Ignorar comando malformado */ }
        }
        comando == "CLICK" -> {
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK)
            Thread.sleep(50)
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
        }
    }
}