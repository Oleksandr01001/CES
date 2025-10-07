package model

abstract class Superheroe(var id: Int, var nombre: String, var nivel: Int) {


    open fun mostrarDatos() {
        println("Id: ${id}")
        println("Nombre: ${nombre}")
        println("Id: ${nivel}")
    }
}