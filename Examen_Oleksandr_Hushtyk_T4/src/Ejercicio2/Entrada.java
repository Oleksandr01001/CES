package Ejercicio2;

import Ejercicio2.controler.Eje2;

import java.util.Random;
import java.util.Scanner;

public class Entrada {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        Eje2 eje2 = new Eje2();
        eje2.anadirAlumnos();
        int opcion = 0;

        do {
            System.out.println("\t---Elige la ocion---");
            System.out.println("1.Ver suspensos");
            System.out.println("2.Ver calificaciones");
            System.out.println("0.Salir de la aplicacion");
            System.out.print("Opcion :");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    eje2.verSuspensos();
                    break;
                case 2:
                    eje2.verNotas();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
                default:
                    System.out.println("No hay opcion: "+opcion);
            }
        } while (opcion != 0);



    }
}
