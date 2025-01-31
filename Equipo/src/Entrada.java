import model.Equipo;
import model.Jugador;

public class Entrada {

    public static void main(String[] args) {

        Equipo equipo = new Equipo("Madrid", 90,80,82);
        Equipo equipo1 = new Equipo("Atletico Madrid");

        Jugador jugador = new Jugador("Olek", 90, "Delantero");

        equipo.ficharJugador(jugador);

        for (int i = 0; i < 3; i++) {
            equipo.atacar();
            equipo1.atacar();
        }

        jugador.mostrarDatos();

        equipo.mostrarDatos();
    }
}
