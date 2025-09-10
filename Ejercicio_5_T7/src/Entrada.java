import controller.Centro;
import model.*;

import java.util.Date;

public class Entrada {

    public static void main(String[] args) {
        Centro centro = new Centro();

        // Crear doctores
        Doctor doctor1 = new General("Carlos", "Pérez", "12345", "Familiar");
        Doctor doctor2 = new Digestivo("Ana", "López", "67890", 10);
        Doctor doctor3 = new Traumatologia("Luis", "Gómez", "54321");

        // Contratar doctores
        centro.contratarDoctor(doctor1);
        centro.contratarDoctor(doctor2);
        centro.contratarDoctor(doctor3);

        // Crear pacientes
        Paciente paciente1 = new Paciente("Laura", "Martínez", "A123", "Dolor de estómago");
        Paciente paciente2 = new Paciente("Pedro", "Fernández", "B456", "Fractura de brazo");

        // Admitir pacientes
        centro.admitirPaciente(paciente1);
        centro.admitirPaciente(paciente2);

        // Pedir cita
        centro.pedirCita("A123", "Digestivo", new Date());
        centro.pedirCita("B456", "Traumatologia", new Date());

        // Ver citas
        centro.verCitas();
    }
}
