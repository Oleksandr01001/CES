package Ejercicio3;

import Ejercicio3.controler.Campeonato;

import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato();

        int opcion = 0;

        do {
            System.out.println("1.Agregar pilotos");
            System.out.println("2.Actualizar puntos");
            System.out.println("3.Mostrar información de un piloto");
            System.out.println("4.Mostrar clasificación:");
            System.out.println("0.Salir de la aplicacion");

            System.out.print("Elige la opcion: ");
            opcion = scanner.nextInt();


            switch (opcion) {
                case 1:
                    campeonato.agregarPilotos();
                    break;
                case 2:
                    campeonato.actualizarPuntos();
                    break;
                case 3:
                    campeonato.mostrarInfoPiloto();
                    break;
                case 4:
                    campeonato.mostrarClasificacion();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
                default:
                    System.out.println("No existe opcion con el codigo "+opcion+"\nPor favor intenta de nuevo...");
                    break;

            }


        }while (opcion != 0);



    }

}
