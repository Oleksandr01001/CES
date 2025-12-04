import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

fun main() {
    val datagrama = DatagramSocket(1234)
    val direccion = InetAddress.getByName("localhost")
    val paquete = DatagramPacket("Hola".toByteArray(),"Hola".toByteArray().size, direccion,1234)
    datagrama.send(paquete)
    val buffer = ByteArray(1024)
    val paqueterespuesta = DatagramPacket(buffer,buffer.size)
    datagrama.receive(paqueterespuesta)
    val cadenafinal = String(paqueterespuesta.data,0,paqueterespuesta.length)
   // println(datagrama.receive(paquete))
    println(cadenafinal)



}