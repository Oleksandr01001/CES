package Ejercicio2;

import Ejercicio2.controler.Restaurante;

import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        int opcion;
        do {
            System.out.println("1.Registrar mesa");
            System.out.println("2.Cancelar mesa");
            System.out.println("3.Mostrar reservas actuales");
            System.out.println("4.Realizar pedido");
            System.out.println("5.Salir del programa");
            System.out.print("Elige la opcion: ");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    restaurante.asignarMesas();
                    break;
                case 2:
                    restaurante.liberarMesa();
                    break;
                case 3:
                    restaurante.mostrarMesas();
                    break;
                case 4:
                    restaurante.realizarPedido();
                    break;
                case 5:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
            }

        } while (opcion!=5);

    }
}
