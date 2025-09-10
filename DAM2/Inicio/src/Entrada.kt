fun main() {


    println("Este es mi primer programa kotlin")

    println()

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

}