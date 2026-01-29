import java.io.DataInputStream
import java.io.DataOutputStream
import javax.net.ssl.SSLServerSocketFactory

fun main() {

    System.setProperty("javax.net.ssl.keyStore","Almacen")
    System.setProperty("javax.net.ssl.keyStorePassword","1234567")

    val serverfactory = SSLServerSocketFactory.getDefault() as SSLServerSocketFactory
    val server = serverfactory.createServerSocket(2001)
    val cliente = server.accept()

    val entrada = DataInputStream(cliente.getInputStream())
    val salida = DataOutputStream(cliente.getOutputStream())

    println(entrada.readUTF())

    entrada.close()
    salida.close()
    cliente.close()
    server.close()

}