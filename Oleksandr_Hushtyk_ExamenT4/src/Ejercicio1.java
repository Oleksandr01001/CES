import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {
    static Scanner lectorTeclado = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
    int[] array1 = new int[15];

    // crear un array
        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(0,16);
        }

        // imprimir array
        System.out.print("El array no ordenado: ");
        for (int item : array1) {
            System.out.print(item+", ");
        }
        System.out.println();

        // imprimir array ordenado
        System.out.print("El array ordenado: ");
        Arrays.sort(array1);
        for (int item : array1) {
            System.out.print(item+", ");
        }
        System.out.println();

        // elementos que estan en pocicion pares
        System.out.print("Los elementos en la pocicion par: ");
        for (int i = 0; i < array1.length; i += 2) {
            System.out.print(array1[i]+", ");
        }
        System.out.println();

        // elementos que no son pares
        System.out.print("Los elementos que no son pares: ");
        for (int item : array1) {
            if (item % 2 != 0) {
                System.out.print(item+", ");
            }
        }
    }
}
