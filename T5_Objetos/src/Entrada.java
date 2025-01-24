import controller.Carrera2;
import controller.Coche2;
import model.Coche;

public class Entrada {
    public static void main(String[] args) {
        Carrera2 carrera2 = new Carrera2(4,"Olek");

        carrera2.inscribirParticipante(new Coche2("Ford","Focus","123a",200));
        carrera2.inscribirParticipante(new Coche2("Ford","Focus","123c",200));
        carrera2.inscribirParticipante(new Coche2("Bmw","m5","123b",200));

        carrera2.imprimirCoches();
        carrera2.inicializarCarrera(4);
        carrera2.mostrarClasificacion();
        carrera2.mostrarGanador();

    }
}
