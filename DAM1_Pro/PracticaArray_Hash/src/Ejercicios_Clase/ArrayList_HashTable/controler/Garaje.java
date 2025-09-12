package Ejercicios_Clase.ArrayList_HashTable.controler;

import java.util.ArrayList;
import java.util.Scanner;

public class Garaje {

    static Scanner scanner = new Scanner(System.in);

    ArrayList<Object[]> coches = new ArrayList<>();
    String marca;
    String modelo;
    int coste;
    String matricula;
    int sumaCostes;


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
        sumaCostes += coste;

        for (Object[] item : coches) {
            if (item[3].equals(matricula)) {
                System.out.println("Ya existe un coche con esta matricula...");
                return;
            }
        }
        coches.add(coche);
        System.out.println("Coche ha añadido con exito");
    }
    public void listarCoches() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches en el garaje...");
            return;
        }
        for (Object[] coche : coches) {
            System.out.println("Marca: "+coche[0]+", Modelo: "+modelo+", Coste: "+coste+", Matricula: "+matricula);
        }
    }
    public void buscarCoche() {
        System.out.print("Introduce la matricula del coche: ");
        String buscarMatricula = scanner.next();
        for (Object[] coche : coches) {
            if (coche[3].equals(buscarMatricula)) {
                System.out.println("Coche encontrado");
                System.out.println("Marca: "+coche[0]+", Modelo: "+modelo+", Coste: "+coste+", Matricula: "+matricula);
            } else {
                System.out.println("No hay coche con esta matricula...");
            }
        }
    }
    public void mostrarCostes() {
        System.out.println("La suma de todos los coches es: "+sumaCostes);
    }
    public void eliminarCoche() {
        System.out.print("Introduce la matricula del coche que quiere eliminar: ");
        String eliminar = scanner.next();
        for (Object[] coche : coches) {
            if (coche[3].equals(eliminar)) {
                coches.remove(coche);
                System.out.println("El coche elimidado con exito");
            } else {
                System.out.println("No hay coche con esta matricula...");
            }
        }
    }
    public void vaciarGaraje() {
        if (coches.isEmpty()) {
            System.out.println("El garaje ya está vacío...");
            return;
        }
        coches.clear();
        sumaCostes = 0;
        System.out.println("Todos los coches eliminados con éxito");
    }
}
