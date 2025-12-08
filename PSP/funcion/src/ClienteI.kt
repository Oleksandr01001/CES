import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.OutputStream
import java.net.Socket

fun main() {
    val cliente = Socket("127.0.0.1",12345)
    val fichero = File("4.jpg")
    val output: OutputStream = cliente.getOutputStream()

    val ficherostream = FileInputStream(fichero)
    val bufferinput = BufferedInputStream(ficherostream)

    val temporal = ByteArray(4096)
    var bytes: Int

    while (bufferinput.read(temporal).also { bytes = it  } != -1) {
        output.write(temporal,0,bytes)
    }
    output.flush()
    output.close()
    bufferinput.close()
    cliente.close()

}