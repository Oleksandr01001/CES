import java.util.Scanner;
import java.util.Random;
public class Ejercicios {
    static Random random = new Random();
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {

        //ejemplo();
        //ejercicio1Base();
        //ejercicio2Base();
        ejercicio3Base();
        //ejercicio4Base();
        //ejercicio5Base();
        //ejercicio6Base();
        //ejercicio7Base();
    }

    public static void ejemplo() {
        int[] numeros = new int[10];
        // 0 0 0 0

        //numeros[3] = 7;
        // 0 0 0 7

       // System.out.println(numeros[3]);
       // System.out.println("La longitud es "+numeros[numeros.length -1]);

        String[] palabras = {"Hola","Que","tal","Estas"};
        //System.out.println("La palabra en ultima posicion es "+palabras[palabras.length -1]);

        /*for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabras[i]);
        }*/

        // rellenar el array de numeros con aleatorios entre 0 y 100
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random()*101);
        }
        for (int i = 0; i < numeros.length; i++) {

            /*if (i % 2 == 0) {
                System.out.println(numeros[i]);
            }*/

            // los numeros que son pares
            if (numeros[i] % 2 == 0) {
                //System.out.println(numeros[i]);
            }
        }

        for (int item : numeros) {
            if (item % 2 == 0) {
                System.out.println(item);
            }
        }
    }
    public static void ejercicio1Base() {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduce un numero: ");
            int numero = lectorTeclado.nextInt();
            numeros[i] += numero;
        }
        for (int item : numeros)
        System.out.println(item);
    }
    public static void ejercicio2Base() {

        int[] numeros = new int[30];
        int suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            int generado = random.nextInt(0, 10);
            numeros[i] += generado;
            suma += generado;
        }
        int media = suma / 30;

        for (int item : numeros) {
            System.out.println(item);
        }
        System.out.println("La media : "+media);
    }
    public static void ejercicio3Base() {

        int[] numeros = new int[10];

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduce un numero: ");
            int numero = lectorTeclado.nextInt();
            numeros[i] += numero;
        }

        int[] reverso = new int[10];
        for (int i = numeros.length -1; i > reverso.length; i--) {
            reverso[i] += numeros[i];
        }
        for (int reversos : reverso) {
            System.out.println(reversos);
        }


    }
    public static void ejercicio4Base() {

    }
    public static void ejercicio5Base() {

    }
    public static void ejercicio6Base() {

    }
    public static void ejercicio7Base() {

    }

}
