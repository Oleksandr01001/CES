package controller;


import model.Profesor;
import model.ProfesorDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class CentroFormacion {

    private ArrayList<Profesor> listaProfesores;
    private ProfesorDTO profesorDTO = new ProfesorDTO();
    static Scanner scanner = new Scanner(System.in);



    public CentroFormacion() {
        listaProfesores = new ArrayList<>();
    }

    public void mostrarDatos() {
        System.out.println("Mostrando los datos de los profesores...");
        System.out.println();
        profesorDTO.mostrarDatos();
    }

    public void incorporarProfesorLocal() {
        System.out.print("Tipo de profesor (1=Interno, 2=Externo): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Salario anual base: ");
        int salario = sc.nextInt();

        Profesor prof = null;
        if (tipo == 1) {
            System.out.print("Complemento mensual: ");
            int comp = sc.nextInt();
            prof = new ProfesorInterno(nombre, dni, salario, comp);
        } else if (tipo == 2) {
            System.out.print("Horas al mes: ");
            int hrs = sc.nextInt();
            System.out.print("Precio por hora: ");
            double precio = sc.nextDouble();
            prof = new ProfesorExterno(nombre, dni, salario, hrs, precio);
        } else {
            System.out.println("Tipo no válido.");
            return;
        }
}