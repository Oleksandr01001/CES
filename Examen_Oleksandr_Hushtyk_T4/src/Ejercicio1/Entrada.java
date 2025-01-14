package Ejercicio1;

import Ejercicio1.controler.Eje1;

import java.util.Scanner;

public class Entrada {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Eje1 eje1 = new Eje1();
        int opcion;

        do {
            System.out.println("---Elige la opcion---");
            System.out.println("1.Agregar producto");
            System.out.println("2.Listar productos");
            System.out.println("3.Ver precio minimo");
            System.out.println("4.Lista de precios menor mayor");
            System.out.println("0.");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    eje1.anadirProduceto();
                    break;
                case 2:
                    eje1.listarProductos();
                    break;
                case 3:
                    eje1.precioMinimo();
                    break;
                case 4:
                    eje1.menorMayar();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
                default:
                    System.out.println("No hay opcion "+opcion);
            }

        } while (opcion!=0);
    }
}
