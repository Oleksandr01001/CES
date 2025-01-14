package Ejercicio3;

import Ejercicio3.controler.Eje3;

import java.util.Scanner;

public class Entrada {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Eje3 eje3 = new Eje3();

        int opcion = 0;

        do {

            System.out.println("\t---Elige la opcion---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Buscar persona");
            System.out.println("3. Borrar persona");
            System.out.println("4. Borrar sin disponibilidad");
            System.out.println("5. Listar personas");
            System.out.println("0. Salir de la aplicacion");
            System.out.print("La opcion: ");
            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    eje3.agregarPersona();
                    break;
                case 2:
                    eje3.buscarPersona();
                    break;
                case 3:
                    eje3.borrarPersona();
                    break;
                case 4:
                    eje3.borrarDisponibilidad();
                    break;
                case 5:
                    eje3.listarPersonas();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
                default:
                    System.out.println("No hay opcion "+opcion);
            }

        } while (opcion != 0);
    }

}
