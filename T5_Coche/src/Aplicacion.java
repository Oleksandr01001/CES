import model.Coche;
import model.Garaje;
import model.Motor;

import java.util.Random;

public class Aplicacion {

    public static void main(String[] args) {

        Garaje garaje = new Garaje();
        Coche coche1 = new Coche("Toyota", "Corolla", "1234ABC", new Motor(120));
        Coche coche2 = new Coche("Ford", "Focus", "5678DEF", new Motor(150));

        String[] averias = {"aceite", "motor", "frenos", "transmision"};
        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            while (!garaje.aceptarCoche(coche1, averias[random.nextInt(averias.length)])) {
                System.out.println("Garaje ocupado, esperando...");
            }
            garaje.devolverCoche();

            while (!garaje.aceptarCoche(coche2, averias[random.nextInt(averias.length)])) {
                System.out.println("Garaje ocupado, esperando...");
            }
            garaje.devolverCoche();
        }

        System.out.println("Información de los coches tras las averías:");
        System.out.println("Coche 1: " + coche1.getMarca() + " " + coche1.getModelo() + " - Matricula: " + coche1.getMatricula() + " - Averías: " + coche1.getAverias() + "€ - Litros de aceite: " + coche1.getMotor().getAceite());
        System.out.println("Coche 2: " + coche2.getMarca() + " " + coche2.getModelo() + " - Matricula: " + coche2.getMatricula() + " - Averías: " + coche2.getAverias() + "€ - Litros de aceite: " + coche2.getMotor().getAceite());

    }
}
