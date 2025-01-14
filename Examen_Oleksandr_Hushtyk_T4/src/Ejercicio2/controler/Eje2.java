package Ejercicio2.controler;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Eje2 {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    ArrayList<Object[]> alumnos = new ArrayList<>();

    public void anadirAlumnos() {
        String nombre;
        int nota;
        System.out.print("Introduce el numero de alumnos: ");
        int numeroAlumnos = scanner.nextInt();

        for (int i = 0; i < numeroAlumnos; i++) {
            System.out.print("Introduce el nombre de alumno: ");
            nombre = scanner.next();
            nota = random.nextInt(1,10);
            Object[] alumno = new Object[] {nombre,nota,};
            alumnos.add(alumno);
        }
    }

    public void verSuspensos() {
        for (Object[] alumno : alumnos) {
            if (alumno[1].equals(5)) {
                System.out.println("Suspenso: "+alumno[0]+", Nota: "+alumno[1]);
            }
        }
    }
    public void verNotas() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos en la lista");
        } else {
            for (Object[] alumno : alumnos) {
                System.out.println("Nombre: "+alumno[0]+", Nota: "+alumno[1]);
            }
        }
    }
}
