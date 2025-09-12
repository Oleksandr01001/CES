package controlador;

import controlador.controler.Agenda;

import java.util.Scanner;

public class Entrada {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        System.out.println("Introduce nombre");
        String nombre = scanner.next();
        System.out.println("Introduce apellido");
        String apellido = scanner.next();
        System.out.println("Introduce telefono");
        int telefono = scanner.nextInt();
        System.out.println("Introduce dni");
        String dni = scanner.next();

        agenda.agregarPersona(nombre,apellido,telefono,dni);
        agenda.mostrarPersonas();




         /*agenda.agregarPersona("Oleksandr","Hushtyk",611530967,"Y9500178L");
         agenda.agregarPersona("Oleksandr","Hushtyk",611530967,"Y9500178L");
         agenda.agregarPersona("Eugenio","Pendiur",611879809,"123456789A");
         ;*/


    }


}
