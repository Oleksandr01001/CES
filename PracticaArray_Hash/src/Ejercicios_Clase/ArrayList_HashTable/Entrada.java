package Ejercicios_Clase.ArrayList_HashTable;

import Ejercicios_Clase.ArrayList_HashTable.controler.Garaje;
import Ejercicios_Clase.ArrayList_HashTable.controler.Garaje1;

import java.util.Scanner;

public class Entrada {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Garaje1 garaje1 = new Garaje1();

        int opcion = 0;
        do {
            System.out.println("1.Añadir un coche");
            System.out.println("2.Listar coches");
            System.out.println("3.Buscar coches");
            System.out.println("4.Mostrar costes");
            System.out.println("5.Eliminar coche");
            System.out.println("6.Vaciar garaje");
            System.out.println("0.Salir de la aplicacion");
            System.out.print("Elige la opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    garaje1.anadirCoche();
                    break;
                case 2:
                    garaje1.listarCoches();
                    break;
                case 3:
                    garaje1.buscarCoche();
                    break;
                case 4:
                    garaje1.mostrarCostes();
                    break;
                case 5:
                    garaje1.eliminarCoche();
                    break;
                case 6:
                    garaje1.vaciarGaraje();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
                default:
                    System.out.println("Ha producido un error, no hay opcion "+opcion);
            }

        } while (opcion != 0);
    }
}
