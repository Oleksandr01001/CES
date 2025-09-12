package Ejercicio1;

import Ejercicio1.controler.Hotel;

import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        int opcion;
        do {

            System.out.println("1.Registrar reservas");
            System.out.println("2.Cancelar reservas");
            System.out.println("3.Mostrar reservas actuales");
            System.out.println("4.Mostrar reservas ordeandas");
            System.out.println("0.Salir del programa");
            System.out.println("Elige la opcion:");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    hotel.reservar();
                    break;
                case 2:
                    hotel.cancelarRecerva();
                    break;
                case 3:
                    hotel.mostrarReservas();
                    break;
                case 4:
                    hotel.mostrarReservasOrdenadas();
                    break;
                case 0:
                    System.out.println("Saliendo de la programa...");
                    break;
            }

        }while (opcion!=0);
    }
}
