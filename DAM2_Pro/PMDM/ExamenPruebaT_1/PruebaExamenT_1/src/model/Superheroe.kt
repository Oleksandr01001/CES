package model

abstract class Superheroe(var id: Int, var nombre: String, var nivel: Int) {

    abstract fun calcularPoder():Int

    open fun mostrarDatos() {
        println("Id: ${id}")
        println("Nombre: ${nombre}")
        println("Nivel: ${nivel}")
    }
}