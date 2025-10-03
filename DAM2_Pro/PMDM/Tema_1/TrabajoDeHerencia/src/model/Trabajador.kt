package model

abstract class Trabajador(nombre: String, apellido: String, dni: String, var salario: Double) :
    Persona(nombre, apellido, dni) {



    constructor(nombre : String, apellido: String, dni: String,
                salario: Double, telefono: Int, correo: String
    ): this(nombre,apellido,dni,salario) {
        this.telefono = telefono
        this.correo = correo
        }

    abstract fun calcularSalarioNeto() : Double;

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario es: $salario")
    }
}