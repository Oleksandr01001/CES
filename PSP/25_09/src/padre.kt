import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    println("Elige: 1 = Piedra, 2 = Papel, 3 = Tijeras")
    val Padre = readln().trim().toInt()

    val proceso = ProcessBuilder(
        "C:\\Users\\oleks\\.jdks\\openjdk-23.0.2\\bin\\java.exe",
        "-cp",
        "C:\\Users\\oleks\\Documents\\GitHub\\CES\\PSP\\25_09\\out\\production\\25_09;" +
                "C:\\Users\\oleks\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib\\2.2.10\\kotlin-stdlib-2.2.10.jar;" +
                "C:\\Users\\oleks\\.m2\\repository\\org\\jetbrains\\annotations\\13.0\\annotations-13.0.jar",
        "HijoKt"
    ).apply {
        redirectErrorStream(true)
    }

    val procesoArrancado = proceso.start()

    val out = OutputStreamWriter(procesoArrancado.outputStream)
    out.write(Padre.toString() + "\n")
    out.flush()

    val input = BufferedReader(InputStreamReader(procesoArrancado.inputStream))
    val Hijo = input.readLine().trim().toInt()

    val textoPadre = if (Padre == 1) "Piedra" else if (Padre == 2) "Papel" else "Tijeras"
    val textoHijo  = if (Hijo == 1) "Piedra" else if (Hijo == 2) "Papel" else "Tijeras"

    println("Padre: $textoPadre")
    println("Hijo: $textoHijo")

    if (Padre == Hijo) {
        println("Resultado: Empate")
    } else if (Padre == 1 && Hijo == 3) {
        println("Resultado: Gana el padre")
    } else if (Padre == 2 && Hijo == 1) {
        println("Resultado: Gana el padre")
    } else if (Padre == 3 && Hijo == 2) {
        println("Resultado: Gana el padre")
    } else {
        println("Resultado: Gana el hijo")
    }
}
