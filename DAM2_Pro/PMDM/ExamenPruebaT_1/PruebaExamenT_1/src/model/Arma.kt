package model

abstract class Arma(var id: Int, var nombre: String, var nivelPotencia: Int, var nivelDano: Int) {


    open fun mostrarDatos() {
        println("Id: ${id}")
        println("Nombre: ${nombre}")
        println("Nivel de potencia: ${nivelPotencia}")
        println("Nivel de daño: ${nivelDano}")
    }
}