package Ejercicios_Clase.ArrayList_HashTable.controler;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Scanner;

public class Garaje1 {

    static Scanner scanner = new Scanner(System.in);

    Hashtable<String, Object[]> coches = new Hashtable<>();
    String marca;
    String modelo;
    int coste;
    String matricula;
    int sumaTotal;

    public void anadirCoche() {
        System.out.print("Introduce la marca: ");
        marca = scanner.next();
        System.out.print("Introduce el modelo: ");
        modelo = scanner.next();
        System.out.print("Introduce el coste: ");
        coste = scanner.nextInt();
        System.out.print("Introduce la matricula: ");
        matricula = scanner.next();

        Object[] coche = new Object[] {marca,modelo,coste,matricula};

        if (coches.containsKey(matricula)) {
            System.out.println("Ya existe coche con esta matricula...");
        } else {
            coches.put(matricula,coche);
            System.out.println("El coche añadido corectamente");
            sumaTotal += coste;
        }

    }
    public void listarCoches() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches en el garaje...");
        } else {
            Enumeration<Object[]> elementos = coches.elements();
            while (elementos.hasMoreElements()) {
                Object[] coche = elementos.nextElement();
                System.out.println("Marca: " + coche[0] +
                        ", Modelo: " + coche[1] +
                        ", Coste: " + coche[2] +
                        ", Matrícula: " + coche[3]);
            }
        }
    }
    public void buscarCoche() {
        System.out.print("Introduce la matricula del coche: ");
        String encontrarCoche = scanner.next();

        if (coches.containsKey(encontrarCoche)) {
            System.out.println("El coche encontrado");
            Object[] coche = coches.get(encontrarCoche);
            for (Object item : coche) {
                System.out.print("Marca: "+coche[0]+", Modelo: "+coche[1]+", Coste: "+coche[2]+", Matricula: "+coche[3]);
                System.out.println();
                return;
            }
        } else {
            System.out.println("Coche no encontrado...");
        }
    }
    public void mostrarCostes() {
        System.out.println("La suma total es: "+sumaTotal);
    }
    public void eliminarCoche() {
        System.out.print("Introduce la matricula del coche que quiere eliminar: ");
        String m = scanner.next();

        if (coches.containsKey(m)) {
            coches.remove(m);
            System.out.println("Coche eliminado corectamente...");
        } else {
            System.out.println("No hay coche con esta matricula...");
        }
    }
    public void vaciarGaraje() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches en garaje...");
        } else {
            coches.clear();
            sumaTotal = 0;
            System.out.println("Los coches eliminados correctamente");
        }
    }
}
