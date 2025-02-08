import controller.Campeonato;
import model.Carrera;
import model.Circuito;
import model.Coche;
import model.Participante;

public class Entrada {


    public static void main(String[] args) {

        Campeonato campeonato = new Campeonato();


        Coche coche1 = new Coche("Ferrari");
        Coche coche2 = new Coche("Mercedes");
        Coche coche3 = new Coche("Red Bull");
        Coche coche4 = new Coche("McLaren");

        Participante p1 = new Participante(coche1);
        Participante p2 = new Participante(coche2);
        Participante p3 = new Participante(coche3);
        Participante p4 = new Participante(coche4);

        campeonato.agregarParticipante(p1);
        campeonato.agregarParticipante(p2);
        campeonato.agregarParticipante(p3);
        campeonato.agregarParticipante(p4);

        Circuito circuito1 = new Circuito("Monza", 53);
        Circuito circuito2 = new Circuito("Silverstone", 52);
        Circuito circuito3 = new Circuito("Lond", 56);
        Circuito circuito4 = new Circuito("Islasa", 55);
        Circuito circuito5 = new Circuito("Stalone", 59);

        Carrera carrera1 = new Carrera(circuito1);
        Carrera carrera2 = new Carrera(circuito2);
        Carrera carrera3 = new Carrera(circuito3);
        Carrera carrera4 = new Carrera(circuito4);
        Carrera carrera5 = new Carrera(circuito5);

        campeonato.agregarCarrera(carrera1);
        campeonato.agregarCarrera(carrera2);

        carrera1.registrarResultado(p1, 1);
        carrera1.registrarResultado(p2, 2);
        carrera1.registrarResultado(p3, 3);
        

        carrera1.obtenerGanadorCarrera();

        carrera2.registrarResultado(p2, 1);
        carrera2.registrarResultado(p3, 2);
        carrera2.registrarResultado(p4, 3);

        carrera2.obtenerGanadorCarrera();

        Participante ganadorCampeonato = campeonato.obtenerGanadorCampeonato();
        System.out.println("Ganador del campeonato: " + ganadorCampeonato.getCoche().getNombre());


        Coche cocheMasGanador = campeonato.obtenerCocheGanador();
        System.out.println("Coche con más victorias: " + cocheMasGanador.getNombre() + " con " + cocheMasGanador.getVictorias() + " victorias.");
    }
}
