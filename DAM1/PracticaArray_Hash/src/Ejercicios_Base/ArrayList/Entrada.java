package Ejercicios_Base.ArrayList;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Entrada {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //ejercicio0();
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        ejercicio6();
        //ejercicio7();
        //ejercicio8();
        //ejercicio9();
    }
    public static void ejercicio0() {
        ArrayList<String> palabras = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce la palabra: ");
            palabras.add(scanner.next());
        }
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }
    public static void ejercicio1() {
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        int suma = 0;
        int media = 0;
        int maximo = 0;
        int minimo = 100;

        System.out.print("Cuantos numeros quiere guardar en el array: ");
        int capacidad = scanner.nextInt();

        for (int i = 0; i < capacidad; i++) {
            int numero = random.nextInt(0,100);
            numeros.add(numero);
            suma += numero;
            if (numero < minimo) {
                minimo = numero;
            }
            if (numero > maximo) {
                maximo = numero;
            }
        }
        media = suma / capacidad;
        System.out.println("La suma es: "+suma);
        System.out.println("La media es: "+media);
        System.out.println("El maximo es: "+maximo);
        System.out.println("El minimo es: "+minimo);

    }
    public static void ejercicio2() {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Cano");
        nombres.add("Ivan");
        nombres.add("Eugenio");
        nombres.add("Artur");
        nombres.add("Oleksandr");

        int aleatorio = random.nextInt(nombres.size());
        String nombre = nombres.get(aleatorio);

        System.out.println("El nombre aleatorio es: "+nombre);
    }
    public static void ejercicio3() {
        ArrayList<Integer> numeros1 = new ArrayList<>();
        ArrayList<Integer> numeros2 = new ArrayList<>();
        int numerosIguales = 0;

        for (int i = 0; i < 20; i++) {
            int aleatorio1 = random.nextInt(0,30);
            int aleatorio2 = random.nextInt(0,30);

            numeros1.add(aleatorio1);
            numeros2.add(aleatorio2);

            if (aleatorio1 == aleatorio2) {
                numerosIguales++;
            }
        }
        System.out.println(numeros1);
        System.out.println(numeros2);
        System.out.println("Numeros con la misma posicion y el mismo numero: "+numerosIguales);


    }
    public static void ejercicio4() {
        ArrayList<String> palabras = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce la palabra: ");
            palabras.add(scanner.next());
        }
        String palabraMas = palabras.get(0);
        String palabraMenos = palabras.get(0);
        int numeroLetras = 0;
        for (int i = 0; i < palabras.size(); i++) {
            if (palabraMas.length() < palabras.get(i).length()) {
                palabraMas = palabras.get(i);
            }
            if (palabraMenos.length() > palabras.get(i).length()) {
                palabraMenos = palabras.get(i);
            }
            numeroLetras += palabras.get(i).length();
        }
        System.out.println("La palabra con mas letras: "+palabraMas);
        System.out.println("La palabra con menos letras: "+palabraMenos);
        System.out.println("La cantidad total de letras: "+numeroLetras);

    }
    public static void ejercicio5() {
        ArrayList<Object[]> coches = new ArrayList<>();

        int numeroCoches = 0;
        System.out.print("Introduce el numero de coches que quiere meter a la lista: ");
        numeroCoches = scanner.nextInt();

        String marca;
        String modelo;
        int cv;

        for (int i = 0; i < numeroCoches; i++) {
            System.out.print("Introduce la marca del coche: ");
            marca = scanner.next();
            System.out.print("Introduce el modelo del coche: ");
            modelo = scanner.next();
            System.out.print("Introduce el numero de caballos: ");
            cv = scanner.nextInt();
            Object[] coche = new Object[] {marca,modelo,cv};
            coches.add(i,coche);
        }
        for (Object[] item : coches) {
            System.out.println(item[0] + " " + item[1] + " " + item[2]);
        }
    }
    public static void ejercicio6() {
        ArrayList<Object[]> coches = new ArrayList<>();

        int numeroCoches = 0;
        System.out.print("Introduce el numero de coches que quiere meter a la lista: ");
        numeroCoches = scanner.nextInt();

        String marca;
        String modelo;
        int cv;

        for (int i = 0; i < numeroCoches; i++) {
            System.out.print("Introduce la marca del coche: ");
            marca = scanner.next();
            System.out.print("Introduce el modelo del coche: ");
            modelo = scanner.next();
            System.out.print("Introduce el numero de caballos: ");
            cv = scanner.nextInt();
            Object[] coche = new Object[] {marca,modelo,cv};
            coches.add(i,coche);
        }
        for (Object[] item : coches) {
            System.out.println("Marca: "+item[0] + " " + "Modelo: "+item[1] + " " + "CV: "+item[2]);
        }
    }
    public static void ejercicio7() {}
    public static void ejercicio8() {}
    public static void ejercicio9() {}
}
