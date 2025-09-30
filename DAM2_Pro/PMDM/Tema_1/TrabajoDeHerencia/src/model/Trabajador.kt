package model

class Trabajador(nombre: String, apellido: String, dni: String, var salario: Int, var nPagas: Int) :
    Persona(nombre, apellido, dni) {

    var seguro: Boolean = false

    constructor(nombre : String, apellido: String, dni: String,
                salario: Int, nPagas: Int, telefono: Int, correo: String, seguro: Boolean
    ): this(nombre,apellido,dni,salario,nPagas) {
            this.seguro = seguro;
        this.telefono = telefono
        this.correo = correo
        }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario es: $salario")
        println("Numero pagas es: $nPagas")
        println("Seguro es: $seguro")
    }
}