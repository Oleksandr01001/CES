import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;

public class EntradaArrayList {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    private static ArrayList<Integer> listaNumeros = new ArrayList<>();
    private static ArrayList<String> listaPalabras = new ArrayList<>();
    private static ArrayList<String> listaPalabras2 = new ArrayList<>();
    private static ArrayList<String>  listaNombres = new ArrayList<>();
    private static ArrayList<Integer> listaNumeros1 = new ArrayList<>();
    private static ArrayList<Integer> listaNumeros2 = new ArrayList<>();
    private static ArrayList<Object> listaCoches = new ArrayList<>();


    public static void main(String[] args) {
        //ejercicio0();
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        ejercicio5();


    }

    public static void ejercicio0() {
        for (int i = 0; i < 10; i++) {
            listaPalabras.add("Palabra "+(i+1));
        }
        for (String i : listaPalabras) {
            System.out.println(i);
        }
    }
    public static void ejercicio1() {

        int suma = 0;
        double media = 0;
        int maximo = 0;
        int minimo = 100;

        for (int i = 0; i < 10; i++) {
            int numero = random.nextInt(100);
            listaNumeros.add(numero);
            suma += numero;
            if (numero > maximo) {
                maximo = numero;
            }
            if (numero < minimo) {
                minimo = numero;
            }
            System.out.println("Numero "+(i+1)+" es: "+numero);
        }
        media = suma / 10.0;

        System.out.println();
        System.out.println("La suma: "+suma);
        System.out.println("La media: "+media);
        System.out.println("El maximo: "+maximo);
        System.out.println("El minimo: "+minimo);
    }
    public static void ejercicio2() {

        for (int i = 0; i < 30; i++) {
            listaNombres.add("Nombre "+(i+1));
            System.out.println(listaNombres.get(i));
        }
        int aleatorio = random.nextInt(0,30);
        System.out.println("El nombre es: "+listaNombres.get(aleatorio));

    }
    public static void ejercicio3() {

        int numerosIguales = 0;
        int numerosIgualesMasPosicion = 0;

        System.out.println("Lista 1"+"    "+"Lista 2");
        for (int i = 0; i < 20; i++) {
            int numero1 = random.nextInt(0,100);
            int numero2 = random.nextInt(0,100);

            listaNumeros1.add(numero1);
            listaNumeros2.add(numero2);

            if(numero1 == numero2) {
                numerosIgualesMasPosicion++;
            }

            System.out.println(numero1+"          "+numero2);
        }

        HashSet<Integer> conjuntoLista1 = new HashSet<>(listaNumeros1);
        HashSet<Integer> conjuntoLista2 = new HashSet<>(listaNumeros2);

        conjuntoLista1.retainAll(conjuntoLista2);
        numerosIguales = conjuntoLista1.size();

        System.out.println();
        System.out.println("Numeros iguales: "+numerosIguales);
        System.out.println("Hay numeros iguales en la misma posicion: "+numerosIgualesMasPosicion);



    }
    public static void ejercicio4() {

        int masLetras = 0;
        String palabraMas = "";
        int menosLetras = 100;
        String palabraMenos = "";
        int totalLetras = 0;

        for (int i = 0; i < 10; i++) {

            System.out.println("Introduce la palabra: "+(i+1));
            String palabra = scanner.next();

            listaPalabras2.add(palabra);

            totalLetras += palabra.length();
            if (masLetras < palabra.length()) {
                masLetras = palabra.length();
                palabraMas = palabra;
            }
            if (menosLetras > palabra.length()) {
                menosLetras = palabra.length();
                palabraMenos = palabra;
            }
        }
        System.out.println("Numero de letras total: "+totalLetras);
        System.out.println("La palabra con mas letras: "+palabraMas);
        System.out.println("La palabra con menos  letras: "+palabraMenos);
    }
    public static void ejercicio5() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Introduce ");

        }
    }


}
