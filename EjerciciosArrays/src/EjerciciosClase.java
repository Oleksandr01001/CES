import java.util.Scanner;
import java.util.Random;
public class EjerciciosClase {
    static Scanner lectorTeclado = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        //ejercicio7();
        //ejercicio8();
        //ejercicio9();
        ejemploMatrix();
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
        int longitud = lectorTeclado.nextInt();
        int[] array1 = new int[longitud];

        for (int i = 0; i < array1.length; i++) {
            System.out.println("Introduce valor "+(i + 1)+":");
            array1[i] = lectorTeclado.nextInt();
        }
        System.out.println(" ");
        for (int item : array1) {
            System.out.println(item);
        }
        System.out.println(" ");

        int ultimaPosicion = array1[array1.length-1];
        int[] array2 = new int[longitud];
        for (int i = array1.length - 1; i > 0; i--) {
            array2[i] = array1[i - 1];
        }
        array2[0] = ultimaPosicion;
        for (int item : array2) {
            System.out.println(item);
        }
        System.out.println(" ");

        int a1 = array1[0];
        int[] array3 = new int[longitud];
        for (int i = 0; i < array1.length - 1; i++) {
            array3[i] = array1[i + 1];
        }
        array3[array1.length - 1] = a1;
        for (int item : array3) {
            System.out.println(item);
        }

        
    }
    public static void ejercicio5() {

        // apartado 0
        int[] array1 = new int[10];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i;
        }
        for (int item : array1) {
            System.out.print(item+", ");
        }
        System.out.println();

        // apartado 1
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] % 2 == 0) {
                array1[i] = i + 1;
            } else {
                array1[i] = i - 1;
            }
        }
        for (int item : array1) {
            System.out.print(item+", ");
        }
        System.out.println();

        // apartado 2
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] <= 5) {
                array1[i] *= 2;
            }
        }
        for (int item : array1) {
            System.out.print(item+", ");
        }
        System.out.println();

        // apartado 3
        for (int i = 0; i < array1.length; i++) {
            array1[i] += random.nextInt(11) -5;
        }
        for (int item : array1) {
            System.out.print(item+", ");
        }
        System.out.println();

        // apartado 4
        int ultimaPosicion = array1[array1.length-1];
        for (int i = 0; i < array1.length-1; i++) {
            array1[i] = array1[i + 1];
        }
        array1[0] = ultimaPosicion;
        for (int item : array1) {
            System.out.print(item+", ");
        }
        System.out.println();

    }
    public static void ejercicio6() {

        int numeroMaximo;

        System.out.println("Introduce la longitud de array: ");
        int longitud = lectorTeclado.nextInt();
        int[] array1 = new int[longitud];

        do {
            System.out.println("Introduce el numero maximo: ");
            numeroMaximo = lectorTeclado.nextInt();
        }while (numeroMaximo >= longitud);

        for (int i = 0; i < longitud; i++) {
            array1[i] = i +1;
        }
        for (int item : array1) {
            System.out.println(item);
        }
    }
    public static void ejercicio7() {
        char[] letras = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
        System.out.println("Cuantas palabras quieres guardar ?");
        int longitud = lectorTeclado.nextInt();
        String[] array1 = new String[longitud];

        for (int i = 0; i < longitud; i++) {
            System.out.println("Cual es la longitud de la palabra"+(i+1));
            int longitudPalabra = lectorTeclado.nextInt();
            //array1[i] = letras[random.nextInt(0,longitudPalabra)];

        }
    }
    public static void ejercicio8() {}
    public static void ejercicio9() {}


    public static void ejemploMatrix() {
        int[][] numeros = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        // cuantas filas tengo
        int numeroFilas = numeros.length; // 4
        // las columnas de la fila
        int columnasFila1 = numeros[0].length;
        int columnasFila2 = numeros[1].length;
        int columnasFila3 = numeros[2].length;
        int columnasFila4 = numeros[3].length;
        // sacar el ultimo elemento
        // numero[3][4]
        int ultimoNumero = numeros[numeros.length-1][numeros[numeros.length-1].length - 1];
        int primerValor = numeros[0][0];
        // modificar valor de una posicion
        numeros[0][0] = 0;
        // acceder a todos los elementos
        // recorrer filas
        /*
        for (int i = 0; i < numeros.length; i++) {
            // recorro las columnas de cada fila
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.print(numeros[i][j]+"\t");
            }
            System.out.println();
            */
            for (int[] item : numeros) {
                for (int element : item) {
                    System.out.print(element+"\t");
            }
                System.out.println();
        }
    }
}
