package model

class Jugador(
    id: Int, nombre: String, var valor: Int
) : Persona(id, nombre) {
    var posicion: String?= null

    constructor(id: Int, nombre: String, posicion: String, valor: Int) : this(id, nombre,valor) {
        this.valor = valor
        this.posicion = posicion
    }


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Valor: ${valor}")
        println("Posicion: ${posicion}")
    }


}