fun cifrar(palabra: String,desplazamiento:Int): String {
    return palabra.map { (it + desplazamiento).toChar() }.joinToString("")
}

fun decifrar(palabra: String,desplazamiento:Int): String {
    return palabra.map { (it - desplazamiento).toChar() }.joinToString("")
}

fun main() {


    println(cifrar("hola",2))
    println(decifrar(cifrar("hola",2),2))
}