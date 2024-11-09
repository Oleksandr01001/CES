import java.util.Scanner;
import java.util.Random;
public class EjerciciosClase {
    static Scanner lectorTeclado = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        ejercicio4();
        //ejercicio5();
        //ejercicio6();
        //ejercicio7();
        //ejercicio8();
        //ejercicio9();
    }
    public static void ejercicio1() {

        int[] numeros = new int[5];
        int suma = 0;


        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduce un numero: ");
            int numero = lectorTeclado.nextInt();
            numeros[i] += numero * 2;
            suma += numero * 2;
        }
        double media = suma/ numeros.length;
        System.out.println("La suma de todos los numero: "+suma);
        System.out.println("La media de los numeros: "+media);
    }
    public static void ejercicio2() {

        System.out.println("Introduce la longitud del array: ");
        int[] numeros = new int[lectorTeclado.nextInt()];

        for (int i=0; i<numeros.length; i++){
            System.out.println("Introduce valor:");
            numeros[i] = lectorTeclado.nextInt();

        }

        int numeroMenor = numeros[0];
        int numeroMayor = numeros[0];

        for (int i=0; i<numeros.length; i++){
            if (numeros[i]>numeroMayor){
                numeroMayor = numeros[i];
            }
            if (numeros[i]<numeroMenor){
                numeroMenor = numeros[i];
            }
        }

        System.out.println("El numero mas pequeño es: "+numeroMenor);
        System.out.println("El numero mas grande es: "+numeroMayor);
    }
    public static void ejercicio3() {

        System.out.println("Introduce la longitud del arrays: ");
        int longitud = lectorTeclado.nextInt();
        int[] array1 = new int[longitud];
        int[] array2 = new int[longitud];
        int[] array3 = new int[longitud];

        for (int i = 0; i < array1.length; i++) {
            array1[i] += random.nextInt(0,100);
            array2[i] += random.nextInt(0,100);
        }

        for (int i = 0; i < array3.length; i++) {
            array3[i] = array1[i] + array2[i];
        }

        for (int item : array3) {
            System.out.println(item);
        }

    }
    public static void ejercicio4() {
        System.out.println("Introduce la longitud del array: ");
        int[] array1 = new int[lectorTeclado.nextInt()];

        for (int i = 0; i < array1.length; i++) {
            System.out.println("Introduce valor: ");
            array1[i] += lectorTeclado.nextInt();
        }
        int ultimaPosicion = array1.length-1;
        
    }
    public static void ejercicio5() {}
    public static void ejercicio6() {}
    public static void ejercicio7() {}
    public static void ejercicio8() {}
    public static void ejercicio9() {}
}
