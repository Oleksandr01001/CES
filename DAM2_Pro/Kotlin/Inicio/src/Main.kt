fun main() {

    println("Por favor introduce tu nombre")
    var nombre = readln();
    println("Por favor introduce tu edad")
    var edad = readln().toInt()
    /*
    println("Hola $nombre tu edad es $edad")
    var nombre = "Olek" // Sting
    var edad = 18 // Int
    val DNI: String = "12341234A"
    var correo: String? = null
    lateinit var direccion: String


    println("Hola mi nombre es ${nombre} tengo ${edad} y mi DNI es ${DNI}")
    println("Mi nombre tiene ${nombre.length} letras")

    println("Mi correo es ${correo?.length ?: "No se ha asignado"} ")

    direccion = "Alcorcon"
    println("Mi direccion es $direccion")
    */


   // saludar(nombre, vecesParam = 1)
    sumaFlecha(1,2)
    //println("El resultado de la operacion es ${sumar()}")

}

fun saludar(nombreParam: String, vecesParam: Int=1) {
    println("Hola $nombreParam, acabas de realizar una funcion")
}

fun sumar(op1: Int=0, op2: Int=0): Int{
    return op1 + op2
}

val sumaFlecha = { p1: Int, p2: Int ->
    println("El resultado de la suma es ${p1 + p2}")
}
