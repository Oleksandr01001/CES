package Ejercicio3.controler;

import java.util.ArrayList;
import java.util.Scanner;

public class Eje3 {

    static Scanner scanner = new Scanner(System.in);

    ArrayList<Object[]> personas = new ArrayList<>();
    String nombre;
    String apellido;
    int telefono;
    String dni;
    boolean disponibilidad;

    public void agregarPersona() {
        scanner = new Scanner(System.in);

        System.out.print("Introduce nombre: ");
        nombre = scanner.next();

        scanner = new Scanner(System.in);

        System.out.print("Introduce apellido: ");
        apellido = scanner.next();

        System.out.print("Introduce telefono: ");
        telefono = scanner.nextInt();

        System.out.print("Introduce dni: ");
        dni = scanner.next();

        System.out.print("Introduce disponibilidad: ");
        disponibilidad = scanner.hasNext();

        Object[] persona = new Object[] {nombre,apellido,telefono,dni,disponibilidad};

            for (Object[] item : personas) {
                if (persona[3].equals(item[3])) {
                    System.out.println("Ya existe persona con este dni...");
                    return;
                }
            }
        personas.add(persona);
        System.out.println("Persona añadida con exito");
        return;

    }
    public void buscarPersona() {
        scanner = new Scanner(System.in);

        System.out.print("Introduce dni: ");
        String pedirDni = scanner.next();

        for (Object[] persona : personas) {
            if (persona[3].equals(pedirDni)) {
                System.out.print("Nombre: "+persona[0]+", Apellido: "+persona[1]+", Telefono: "+persona[2]);
                System.out.println();
                return;
            } else {
                System.out.println("No hay persona con este dni...");
            }
        }

    }
    public void borrarPersona() {
        scanner = new Scanner(System.in);
        System.out.print("Introduce dni para borrar la persona: ");
        String borrarDni = scanner.next();

        for (Object[] persona : personas) {
            if (persona[3].equals(borrarDni)) {
                personas.remove(persona);
                System.out.println("La persona se ha borrado con exito");
                return;
            } else {
                System.out.println("No hay persona con este dni...");
            }
        }
        return;
    }
    public void borrarDisponibilidad() {
        System.out.println("Borrando todas las persona sin disponibilidad...");
        boolean b = false;
        for (Object[] persona : personas) {
            if (persona[4].equals(b)) {
                personas.remove(persona);
                System.out.println("Todas personas con la disponibilidad (false) han borrado de la lista");
            }
        }

    }
    public void listarPersonas() {

        if (personas.isEmpty()) {
            System.out.println("No hay personas en la lista...");
        } else {
            for (Object[] persona : personas) {
                System.out.print("Nombre: "+persona[0]+", Apellido: "+persona[1]+", Telefono: "+persona[2]);
                System.out.println();
            }
        }



    }
}
