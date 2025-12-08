import java.net.DatagramPacket
import java.net.InetAddress
import java.net.MulticastSocket

fun main() {
    try {
        val socketmulticast = MulticastSocket(5000)
        val direction = InetAddress.getByName("224.0.0.2")

        socketmulticast.joinGroup(direction)

        val mensaje = "Artur lox".toByteArray()
        val paquete = DatagramPacket(mensaje, mensaje.size,direction, 5000)
        socketmulticast.send(paquete)

        while (true)
        {
            val bytes = ByteArray(1024)
            val paqueterecibido = DatagramPacket(bytes, bytes.size)
            socketmulticast.receive(paqueterecibido)
            println(String(paqueterecibido.data, paqueterecibido.offset,paqueterecibido.length))

        }

    } catch (e: Exception)
    {
        e.printStackTrace()
    }
}