import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array1 = new int[20];
        int opcion = 0;

        do {
            System.out.println("1. Registrar posiciones");
            System.out.println("2. Obtener elementos de una posición");
            System.out.println("3. Mostrar el array completo");
            System.out.println("4. Mostrar el array ordenado");
            System.out.println("5. Rotar el array mueve todas las posiciones del array");
            System.out.println("6. Salir");

            System.out.print("Elige la opcion:");
            opcion = lectorTeclado.nextInt();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < array1.length; i++) {
                        System.out.println("Rellena la pocicion "+(i+1));
                        array1[i] = lectorTeclado.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("Introduce la pocicion donde quieres ver el elemento:");
                    int elemento = lectorTeclado.nextInt();
                    System.out.println("En la pocicion "+elemento+" esta el numero: "+array1[elemento]);

                    break;
                case 3:
                    for (int item : array1) {
                        System.out.print(item+", ");
                    }
                    System.out.println();

                    break;
                case 4:
                    Arrays.sort(array1);


                    for (int item : array1) {
                        System.out.print(item+", ");
                    }
                    System.out.println();

                    break;
                case 5:
                    int[] array3 = new int[array1.length];
                    int ultimaPocicion = array1[array1.length - 1];
                    for (int i = 0; i < array1.length - 1; i++) {
                        array3[i+1] = array1[i];
                    }
                    array3[0] = ultimaPocicion;

                    for (int item : array3) {
                        System.out.print(item+", ");
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
            }

        } while (opcion != 6);

    }
}