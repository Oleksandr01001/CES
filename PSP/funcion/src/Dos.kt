import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args:Array<String>) {
    var linea = BufferedReader(InputStreamReader(ProcessBuilder("java","-cp","C:\\Users\\oleks\\Documents\\GitHub\\CES\\PSP\\funcion\\out\\production\\funcion","LlamarKt").start().inputStream)).readLine()
    println(linea)
}

