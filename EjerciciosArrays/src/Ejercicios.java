import java.util.Scanner;
import java.util.Random;
public class Ejercicios {
    static Random random = new Random();
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {

        //ejemplo();
        //ejercicio1Base();
        //ejercicio2Base();
        //ejercicio3Base();
        //ejercicio4Base();
        //ejercicio5Base();
        //ejercicio6Base();
        //ejercicio7Base();
        ejercicioList1();
        //ejercicioList2();
        //ejercicioList3();
        //ejercicioList4();
        //ejercicioList5();
        //ejercicioList6();
        //ejercicioList7();
        //ejercicioList8();
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
        float media = suma / 30;

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
        for (int i = numeros.length -1; i >= 0; i--) {
            System.out.println(i);
        }
        for (int reverso : numeros) {
            System.out.println(reverso);
        }
    }
    public static void ejercicio4Base() {

        int[] numeros = new int[20];
        int[] cuadrado = new int[numeros.length];
        int[] cubo = new int[numeros.length];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] += random.nextInt(0,100);
            cuadrado[i] += numeros[i] * numeros[i];
            cubo[i] += numeros[i] * numeros[i] * numeros[i];
        }
        System.out.println("Numeros "+"Cuadrado "+"Cubo ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]+"     "+cuadrado[i]+"       "+cubo[i]);
        }


    }
    public static void ejercicio5Base() {
    int[] numeros = new int[8];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduce un numero entero: ");
            numeros[i] += lectorTeclado.nextInt();
        }
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.println(numeros[i]+"  Es par");
            } else {
                System.out.println(numeros[i]+"  Es impar");
            }
        }

    }
    public static void ejercicio6Base() {
        int[] numeros = new int[20];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] += random.nextInt(0,30);
        }
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
    public static void ejercicio7Base() {

        String[] palabras = new String[10];
        int numeroLetras = 0;
        String palabraMasGrande = "";

        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Introduce la palabra: ");
            palabras[i] = lectorTeclado.next();
            if (palabras[i].length() > palabraMasGrande.length()){
                palabraMasGrande = palabras[i];
            }

        }
        System.out.println("Elige la opcion...");
        System.out.println("1.Ver todas las palabras");
        System.out.println("2.Obtener una palabra al azar");
        System.out.println("3.Ver número de letras");
        System.out.println("4.Ver media de letras");
        System.out.println("5.Ver palabra con más letras");
        System.out.println("6.Ver palabra con menos letras");
        int opcion = lectorTeclado.nextInt();

        for (String letras : palabras) {
            numeroLetras += letras.length();
        }
        double numeroMedia = (double) numeroLetras / palabras.length;

        switch (opcion) {
            case 1:
                for (String palabra : palabras) {
                    System.out.println(palabra);
                }
                break;
            case 2:
                int palabraRandom = random.nextInt(palabras.length);
                System.out.println("La palabra es: " + palabras[palabraRandom]);
                break;
            case 3:
                System.out.println("Numero de letras: " + numeroLetras);
                break;
            case 4:
                System.out.println("La media de letras: " + numeroMedia);
                break;
            case 5:
                System.out.println("La palabra con mas letras: "+palabraMasGrande);
                break;
            case 6:
                String palabraMasCorta = palabras[0];
                for (String item : palabras) {
                    if (item.length() < palabraMasCorta.length()) {
                        palabraMasCorta = item;
                    }
                    System.out.println("La palabra con menos letras: "+palabraMasCorta);
                    break;
                }
        }
    }
    public static void ejercicioList1() {
        String[] palabras = {"Yo","Tu","El","Ella","Usted","Nosotros","Vosotros","Ellos","Ustedes","Lox"};
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }
    public static void ejercicioList2() {}
    public static void ejercicioList3() {}
    public static void ejercicioList4() {}
    public static void ejercicioList5() {}
    public static void ejercicioList6() {}
    public static void ejercicioList7() {}
    public static void ejercicioList8() {}

}
