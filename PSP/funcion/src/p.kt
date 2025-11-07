import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URI

fun main() {
    val url = URI("http://192.168.2.216/a/GetPost/examplepost.php").toURL()
    val parametro = "nombre=juan&edad=33"

    val conexion = url.openConnection() as HttpURLConnection
    conexion.requestMethod = "POST"
    conexion.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
    conexion.doOutput = true

    val out = conexion.outputStream
    out.write(parametro.toByteArray(Charsets.UTF_8))
    out.flush()
    out.close()

    val input = conexion.inputStream
    val leer = BufferedReader(InputStreamReader(input))
    var linea: String?
    while (leer.readLine().also { linea = it } != null) {
        println(linea)
    }

    leer.close()
    input.close()
    conexion.disconnect()
}