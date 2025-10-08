package model

class Participante(
    id: Int, nombre: String, var puntos: Int
) : Persona(id, nombre) {

    var plantilla = arrayListOf<Jugador>()
    var presupuesto: Int =10000000



    fun anadirParticipante(jugador: Jugador) {
        var fantasy = Fantasy()
        if (fantasy.jugadorPuedeJugar(jugador)) {
            plantilla.add()
        }
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Presupuesto: ${presupuesto}")
        println("Puntos: ${puntos}")
    }

}