package model

class Fantasy {
    var listaJugadores = arrayListOf<Jugador>()
    var puntuaciones = arrayListOf<Jugador>()

    fun plantillaCompleta() : Boolean{
        if (listaJugadores.size == 6) {
            return true
        } else {
            return false
        }
    }

    fun agregarJugador(jugador: Jugador) {
        if (listaJugadores.size<6) {
            listaJugadores.add(jugador)
            println("Jugador agregado")
        } else {
            println("Tienes plantilla completa")
        }
    }

    fun jugadorPuedeJugar(jugador: Jugador) {
        if (plantillaCompleta()) {
            puntuaciones.add(jugador)
        }
    }

    fun listarJugadores() {
        listaJugadores.forEach {
            it.mostrarDatos()
        }
    }

    fun listarJugadoresSuperiores() {
        listaJugadores.forEach {
            if (it.valor >= 3000000) {
                it.mostrarDatos()
            }
        }
    }

    fun iniciarJuedo(administrador: Administrador) {
        var autorizado: Boolean = administrador.autorizacion(administrador.clave)
        if (autorizado) {
            println("Inicializacion del juego")

        } else {
            println("No se puede inicializar el juego")
        }
    }

    fun contarPuntos(participante: Participante) {

    }




}