package Ejercicios_Base.Array;

import java.util.Random;
import java.util.Scanner;

public class Entrada {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        ejercicio7();
    }

    public static void ejercicio1() {

        int[] numeros = new int[10];

        System.out.println("\t---Introduce 10 numeros---");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Introduce un numero para posicion "+ (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        System.out.println("\t---Los numeros almacenados con exito---");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("En la posicion " + (i+1) + " esta el numero: " + numeros[i]);
        }
    }
    public static void ejercicio2() {

        int[] numeros = new int[30];
        int totalPuntos = 0;
        double media = 0;


        System.out.println("\t---Los numeros estan generando---");
        for (int i = 0; i < numeros.length; i++) {
            int numero = random.nextInt(10);
            numeros[i] = numero;
            totalPuntos += numero;
        }
        media = totalPuntos / numeros.length;
        System.out.println("\t---Mostrando los resultados---");
        System.out.println("---Numero de puntos obtenidos: "+totalPuntos+"---");
        System.out.println("---Media de puntos obtenidos: "+media+"---");

    }
    public static void ejercicio3() {

        int[] numeros = new int[10];

        System.out.println("\t---Introduce 10 numeros enteros---");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("---Introduce el numero: ");
            numeros[i] = scanner.nextInt();
        }

        for (int i = numeros.length -1; i >= 0 ; i--) {
            System.out.println("--- "+numeros[i]);
        }
        System.out.println();
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("--- "+numeros[i]);
        }
    }
    public static void ejercicio4() {

        int[] numero = new int[20];
        int[] cuadrado = new int[numero.length];
        int[] cubo = new int[numero.length];

        for (int i = 0; i < numero.length; i++) {
            int aleatorio = random.nextInt(0,100);
            numero[i] = aleatorio;
            cuadrado[i] = aleatorio * aleatorio;
            cubo[i] = aleatorio * aleatorio * aleatorio;
        }
        System.out.println("\t---Numero---\t---Cuadrado---\t---Cubo---");
        for (int i = 0; i < numero.length; i++) {
            System.out.println("\t---  "+numero[i]+"  ---\t---  "+cuadrado[i]+"  ---\t---  "+cubo[i]+"---");
        }
    }
    public static void ejercicio5() {

        int[] numeros = new int[8];

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Introduce un nuemro: ");
            numeros[i] = scanner.nextInt();
        }
        System.out.println();
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.println(numeros[i] + " es par");
            } else {
                System.out.println(numeros[i] + " es impar");
            }

        }
    }
    public static void ejercicio6() {

        int[] numeros = new int[20];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(0,30);
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        System.out.println();
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == 6) {
                numeros[i] = 8;
            } else if (numeros[i] == 7) {
                numeros[i] = 15;
            } else if (numeros[i] == 20) {
                numeros[i] = 10;
            }
            System.out.println(numeros[i]);
        }
    }
    public static void ejercicio7() {

        String[] palabras = new String[10];
        int opcion = 0;
        int numeroLetras = 0;



        for (int i = 0; i < palabras.length; i++) {
            System.out.print("Introduce la palabra: ");
            palabras[i] = scanner.next();
        }

        do {
            System.out.println("\t---Elige la opcion---");
            System.out.println("1.Ver todas las palabras");
            System.out.println("2.Obtener una palabra al azar");
            System.out.println("3.Ver número de letras");
            System.out.println("4.Ver media de letras");
            System.out.println("5.Ver palabra con más letras");
            System.out.println("6.Ver palabra con menos letras");
            System.out.println("0.Salir de la aplicacion");
            System.out.print("---Opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < palabras.length; i++) {
                        System.out.println(palabras[i]);
                    }
                    break;
                case 2:
                    int aleatorio = random.nextInt(palabras.length);
                    String palabra = palabras[aleatorio];
                    System.out.println("La palabra aleatoria es: "+palabra);
                    break;
                case 3:
                    for (int i = 0; i < palabras.length; i++) {
                        numeroLetras += palabras[i].length();
                    }
                    System.out.println("Numero de letras: "+numeroLetras);
                    break;
                case 4:
                    double media = numeroLetras / palabras.length;
                    System.out.println("La media es: "+media);
                    break;
                case 5:
                    String palabraGrande = palabras[0];
                    for (int i = 0; i < palabras.length; i++) {
                        if (palabras[i].length() > palabraGrande.length()) {
                            palabraGrande = palabras[i];
                        }
                    }
                    System.out.println("La palabra con mas letras es: "+palabraGrande);
                    break;
                case 6:
                    String palabraPequena = palabras[0];
                    for (int i = 0; i < palabras.length; i++) {
                        if (palabras[i].length() < palabraPequena.length()) {
                            palabraPequena = palabras[i];
                        }
                    }
                    System.out.println("La palabra con menos letras es: "+palabraPequena);
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
            }

        } while (opcion != 0);



    }
}
