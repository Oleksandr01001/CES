import java.util.Random;
import java.util.Scanner;

public class ejerciciosMultidemencionales {
    static Scanner lectorTeclado = new Scanner(System.in);

    static Random random = new Random();
    public static void main(String[] args) {

        // definir un array con 5 filas y columnas aleatorias entre 2  - 6
        // rellenar el array (entero) con aleatorios

        int[][] matrix = new int[5][random.nextInt(2,6)];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(0,50);
            }
        }
        imprimirArray(matrix);

        System.out.println();
        for (int w = 0; w < 8; w++) {
            System.out.println("Introduce el numero que quieres incrementar: ");
            int incrementar = lectorTeclado.nextInt();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] -= incrementar;
                }
            }
            imprimirArray(matrix);
        }



    }
    public static void imprimirArray(int[][] matrix) {
        for (int[] item : matrix) {
            for (int element : item) {
                System.out.print(element+"\t");
            }
            System.out.println();
        }
    }
}
