package Ejercicio1.controler;

import java.util.ArrayList;
import java.util.Scanner;

public class Eje1 {

    static Scanner scanner = new Scanner(System.in);
    ArrayList<Object[]> lista = new ArrayList<>();
    String nombre;
    double precio;

    public void anadirProduceto() {
        System.out.print("Introduce el nombre del producto: ");
        nombre = scanner.next();
        System.out.print("Introduce el precio: ");
        precio = scanner.nextDouble();

        Object[] list = new Object[] {nombre,precio};

        lista.add(list);
    }
    public void listarProductos() {
        for (Object[] item : lista) {
            System.out.print("Nombre: "+item[0]+", Precio: "+item[1]);
            System.out.println();
        }
    }
    public void precioMinimo() {

    }
    public void menorMayar() {

    }
}
