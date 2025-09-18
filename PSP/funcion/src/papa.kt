import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val proceso = ProcessBuilder(
        "C:\\Users\\oleks\\.jdks\\openjdk-23.0.2\\bin\\java.exe",
        "-Dfile.encoding=UTF-8",
        "-Dsun.stdout.encoding=UTF-8",
        "-Dsun.stderr.encoding=UTF-8",
        "-cp",
        "C:\\Users\\oleks\\Documents\\GitHub\\CES\\PSP\\funcion\\out\\production\\funcion;" +
                "C:\\Users\\oleks\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib\\2.0.10\\kotlin-stdlib-2.0.10.jar;" +
                "C:\\Users\\oleks\\.m2\\repository\\org\\jetbrains\\annotations\\13.0\\annotations-13.0.jar",
        "HijoKt"
    ).apply {
        redirectErrorStream(true)
    }

    val procesoEjecutado = proceso.start()


    val output = OutputStreamWriter(procesoEjecutado.outputStream)
    output.write("Hola hijo\n")
    output.flush()

    val input = BufferedReader(InputStreamReader(procesoEjecutado.inputStream)).readLine()
    println(input)
}