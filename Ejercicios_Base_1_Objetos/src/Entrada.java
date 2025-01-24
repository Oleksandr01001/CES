import model.Persona;

import java.util.Scanner;

public class Entrada {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Intoroduce nombre: ");
        String nombre = scanner.next();
        System.out.println("Introcue apellido: ");
        String apellido = scanner.next();
        System.out.println("Introduce dni: ");
        String dni = scanner.next();
        System.out.println("Introduce edad: ");
        int edad = scanner.nextInt();
        System.out.println("Introduce peso: ");
        double peso = scanner.nextDouble();
        System.out.println("Introduce altura: ");
        double altura = scanner.nextDouble();

        Persona persona = new Persona(nombre,apellido,dni,edad,peso,altura);

        Persona persona1 = new Persona("Olek","Hush","1234a", 17, 85.5,189.0);

        Persona persona2 = new Persona("Olek","Hush");

        Persona persona3 = new Persona();

        persona.mostrarDatos();
        persona1.mostrarDatos();
        persona2.mostrarDatos();
        persona3.mostrarDatos();



    }
}
