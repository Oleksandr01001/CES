import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {
    static Scanner lectorTeclado = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Introduce la cantidad de detos que quires guardar:");
        int longuitud = lectorTeclado.nextInt();

        int[] array1 = new int[longuitud];

        // rellenar automaticamente
        for (int i = 0; i < longuitud; i++) {
            array1[i] = random.nextInt(0,20);
        }

        // mostrar el array
        for (int item : array1) {
            System.out.print(item+ ", ");
        }
        System.out.println();

        // mostrar el numero mas grande y mas pequeño
        int numeroMasGrande = array1[0];
        int numeroMasPequeño = array1[0];
        for (int item : array1) {
            if (numeroMasGrande < item) {
                numeroMasGrande = item;
            }
            if (numeroMasPequeño > item) {
                numeroMasPequeño = item;
            }
        }
        System.out.println("El numero mas grande es: "+numeroMasGrande);
        System.out.println("El numero mas pequeño es: "+numeroMasPequeño);

        // Mostrar cuantos elementos son pares y cuantos impares
        int pares = 0;
        int impares = 0;
        for (int item : array1) {
            if (item % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }
        System.out.println("Hay numeros pares: "+pares);
        System.out.println("Hay numeros impares: "+impares);

        // Pedirá un número por teclado y mostrará el número de veces que aparece en la lista
        System.out.println("Introduce el numero que quieres buscar: ");
        int numeroBuscar = lectorTeclado.nextInt();
        int aparce = 0;
        for (int item : array1) {
            if (item == numeroBuscar) {
                aparce++;
            }
        }
        System.out.println("El numero "+numeroBuscar+" aparece "+aparce+" veces");
    }
}
