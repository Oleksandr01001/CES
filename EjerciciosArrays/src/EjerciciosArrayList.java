import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EjerciciosArrayList {

    static Scanner lectorLeclado = new Scanner(System.in);
    static Random random = new Random();
    private static ArrayList<String> listaPalabras = new ArrayList<>();
    private static ArrayList<Integer> listaNumeros = new ArrayList<>();

    public static void main(String[] args) {
        ejercicio1A("Artur");
        ejercicio1A("Artur");
        ejercicio1A("Artur");
        ejercicio1A("Artur");
        ejercicio1A("Artur");
        ejercicio1A("Artur");
        ejercicio1A("Artur");
        ejercicio1A("Artur");
        ejercicio1A("Artur");
        ejercicio1A("Artur");
        hablar();

        ejercicio1B(random.nextInt(0,100));

    }

    public static void ejercicio1A(String s) {
        listaPalabras.add(s);
        System.out.println("La palabra añadido correctamente");
    }
    public static void hablar() {
        for (String ss : listaPalabras) {
            System.out.println(ss);
        }
    }

    public static void ejercicio1B(int numero) {
        listaNumeros.add(numero);
    }
    public static void returned(int suma, double media, int minimo, int maximo) {

    }

}