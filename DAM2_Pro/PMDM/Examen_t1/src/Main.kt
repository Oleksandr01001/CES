import model.Fantasy
import model.Jugador

fun main() {

    var fantasy = Fantasy()

    fantasy.listaJugadores.add(Jugador(1,"Marc-André ter Stegen", "Portero",3000000))
    fantasy.listaJugadores.add(Jugador(2,"Ronald Araújo", "Defensa",4000000))
    fantasy.listaJugadores.add(Jugador(3,"Eric García", "Defensa",1000000))
    fantasy.listaJugadores.add(Jugador(4,"Pedri", "Mediocentro",5000000))
    fantasy.listaJugadores.add(Jugador(5,"Robert Lewandowski", "Delantero",8000000))
    fantasy.listaJugadores.add(Jugador(6,"Courtois", "Portero",3000000))
    fantasy.listaJugadores.add(Jugador(7,"David Alaba", "Defensa",4000000))
    fantasy.listaJugadores.add(Jugador(8,"Jesús Vallejo", "Defensa",500000))
    fantasy.listaJugadores.add(Jugador(9,"Luka Modric", "Mediocentro",5000000))
    fantasy.listaJugadores.add(Jugador(10,"Karim Benzema", "Delantero",8000000))
    fantasy.listaJugadores.add(Jugador(11,"Ledesma", "Portero",500000))
    fantasy.listaJugadores.add(Jugador(12,"Juan Cala", "Defensa",300000))
    fantasy.listaJugadores.add(Jugador(13,"Zaldua", "Defensa",400000))
    fantasy.listaJugadores.add(Jugador(14,"Alez Fernández", "Mediocentro",700000))
    fantasy.listaJugadores.add(Jugador(15, "Choco Lozano", "Delantero", 800000))
    fantasy.listaJugadores.add(Jugador(16,"Rajković", "Portero",300000))
    fantasy.listaJugadores.add(Jugador(17,"Raíllo", "Defensa",200000))
    fantasy.agregarJugador(Jugador(30,"Marc-André ter Stegen", "Portero",3000000))
}