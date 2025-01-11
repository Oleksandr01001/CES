package Ejercicio2.controler;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<Object[]> listaMesas = new ArrayList<>();

    public void asignarMesas() {
        System.out.print("Escribe su nombre: ");
        String nombre = scanner.next();
        System.out.print("Escribe número de la mesa: ");
        int numeroMesa = scanner.nextInt();

        for (Object[] item : listaMesas) {
            if ((int) item[1] == numeroMesa) {
                System.out.println("La mesa " + numeroMesa + " ya está ocupada.");
                return;
            }
        }

        Object[] nuevaMesa = new Object[]{nombre, numeroMesa, new ArrayList<String>()};
        listaMesas.add(nuevaMesa);
        System.out.println("Mesa " + numeroMesa + " asignada a " + nombre);
    }

    public void liberarMesa() {
        System.out.print("Escribe número de mesa que quieres liberar: ");
        int numMesa = scanner.nextInt();

        for (int i = 0; i < listaMesas.size(); i++) {
            Object[] mesa = listaMesas.get(i);
            if ((int) mesa[1] == numMesa) {
                // Mostrar información de la mesa antes de liberarla
                ArrayList<String> consumiciones = (ArrayList<String>) mesa[2];
                System.out.println("Mesa liberada: " + mesa[1]);
                System.out.println("Cliente: " + mesa[0]);
                System.out.println("Consumiciones: " + consumiciones);
                listaMesas.remove(i);
                return;
            }
        }
        System.out.println("No se encontró la mesa " + numMesa);
    }

    public void realizarPedido() {
        System.out.println("Introduce número de mesa:");
        int numMesa = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        for (Object[] item : listaMesas) {
            if ((int) item[1] == numMesa) {
                ArrayList<String> consumiciones = (ArrayList<String>) item[2];
                System.out.println("Introduce las consumiciones una a una (escribe 'fin' para terminar):");
                while (true) {
                    String consumicion = scanner.nextLine();
                    if (consumicion.equalsIgnoreCase("fin")) {
                        break;
                    }
                    consumiciones.add(consumicion);
                }
                System.out.println("Pedido agregado a la mesa " + numMesa);
                System.out.println("Consumiciones actuales: " + consumiciones);
                return;
            }
        }
        System.out.println("No se encontró la mesa " + numMesa);
    }

    public void mostrarMesas() {
        if (listaMesas.isEmpty()) {
            System.out.println("No hay mesas ocupadas.");
        } else {
            for (Object[] item : listaMesas) {
                System.out.println("Mesa: " + item[1] + " Cliente: " + item[0] + " Consumiciones: " + item[2]);
            }
        }
    }
}
