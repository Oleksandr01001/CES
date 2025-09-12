package Ejercicios_Clase.Arrays_Multidimensionales_Unidimesionales;

import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static void ejercicio1() {
        int[] numeros = new int[5];
        int[] numeros2 = new int[5];

        int suma = 0;
        int media = 0;


        System.out.println("\t---Introduce cinco numeros---");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Introduce el numero: ");
            int numero = scanner.nextInt();
            numeros[i] = numero;
            numeros2[i] = numero * 2;
            suma += numero;
        }
        media = suma / numeros.length;




    }
}
