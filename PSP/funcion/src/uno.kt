import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    var nombre = "arp -a"
    //val proceso = ProcessBuilder("cmd.exe","/c","arp -a")
    //val proceso = ProcessBuilder("notepad")
   // val proceso = ProcessBuilder("cmd.exe","/c","arp -a > fichero.txt")
    //val procesoTemporal = proceso.start()
    //print("Hola mundo $nombre\n")
   // print(procesoTemporal.inputStream.bufferedReader().readText())
    //proceso.redirectOutput(ProcessBuilder.Redirect.INHERIT)

    //print(procesoTemporal.isAlive)
    //procesoTemporal.waitFor()

    var linea = BufferedReader(InputStreamReader(ProcessBuilder("C:\\Program Files\\Java\\jdk-17\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.2.1\\lib\\idea_rt.jar=54618:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.2.1\\bin\" -Dfile.encoding=UTF-8 -classpath C:\\Users\\PROFESOR\\eclipse-workspace\\funcion\\out\\production\\funcion;C:\\Users\\PROFESOR\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib-jdk8\\1.7.10\\kotlin-stdlib-jdk8-1.7.10.jar;C:\\Users\\PROFESOR\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib\\1.7.10\\kotlin-stdlib-1.7.10.jar;C:\\Users\\PROFESOR\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib-common\\1.7.10\\kotlin-stdlib-common-1.7.10.jar;C:\\Users\\PROFESOR\\.m2\\repository\\org\\jetbrains\\annotations\\13.0\\annotations-13.0.jar;C:\\Users\\PROFESOR\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib-jdk7\\1.7.10\\kotlin-stdlib-jdk7-1.7.10.jar LlamarKt").start().inputStream)).readLine()
    println(linea)

}