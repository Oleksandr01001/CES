package controller;

import model.Profesor;
import model.ProfesorDTO;
import model.ProfesorExterno;
import model.ProfesorInterno;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CentroFormacion {
    private ArrayList<Profesor> listaProfesores;
    private static ProfesorDTO profesorDTO;
    private static Profesor profesor;
    private static final Scanner scanner = new Scanner(System.in);

    public CentroFormacion(){
        listaProfesores = new ArrayList<>();
    }

    public void insertarProfesor(){
        Profesor profesor1 = new Profesor(profesor.getNombre(), profesor.getDni(), profesor.getSalarioAnual()) {
            @Override
            public double calcularSalarioTotal() {
                return 0;
            }
        };

        profesorDTO.insertarProfesor(profesor1);

    }
    public void mostrarProfesores(){
        System.out.println("Datos de profesores en la base de datos: ");
        profesorDTO.mostrarDatos();
    }

    public void incorporarProfesoresLocal() {
        System.out.println("Tipo de profesor (1 = Interno, 2 = Externo): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Salario base anual: ");
        int salario = scanner.nextInt();

        Profesor profesor = null;

        if (tipo == 1) {
            System.out.print("Complemento mensual: ");
            int complemento = scanner.nextInt();
            profesor = new ProfesorInterno(nombre, dni, salario, complemento);
        } else if (tipo == 2) {
            System.out.print("Horas: ");
            int horas = scanner.nextInt();
            System.out.print("Precio por hora: ");
            double precio = scanner.nextDouble();
            profesor = new ProfesorExterno(nombre, dni, salario, horas, precio);
        }

        if (profesor != null) {
            listaProfesores.add(profesor);
            System.out.println("Profesor agregado.");
        } else {
            System.out.println("Tipo no válido.");
        }
    }

    public void eliminarProfesor() {
        System.out.println("Introduce el DNI del profesor que quieres dar de baja:");
        String dni = scanner.next();
        boolean encontrado = false;

        for (int i = 0; i < listaProfesores.size(); i++) {
            if (listaProfesores.get(i).getDni().equalsIgnoreCase(dni)) {
                listaProfesores.remove(i);
                encontrado = true;
                System.out.println("Profesor eliminado.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un profesor con ese DNI.");
        }
    }



    public void exportarCSV() {
        try (PrintWriter writer = new PrintWriter("profesores.csv")) {

            for (Profesor p : listaProfesores) {
                writer.println(p.getDni() + "," + p.getNombre() + "," + p.calcularSalarioTotal());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void exportarObj() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("profesores.obj"))) {
            oos.writeObject(listaProfesores);
        }
    }







    public ArrayList<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(ArrayList<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }
}
