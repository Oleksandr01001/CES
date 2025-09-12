import java.io.IOException;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        /*
        String[] cosas = {"Dato1","Dato2","Dato3"};
        int numero1 = 2;
        int numero2 = 0;
        String nombre;

        System.out.println("A que posicion quieres acceder?");
        int posicion = scanner.nextInt();

        try {
            System.out.println(cosas[posicion]);
            int resultado = numero1 / numero2;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("El size es mas pequeño que la posicion indicada");
        } catch (ArithmeticException e) {
            System.out.println("Error en la divicion entre 0");
        } finally {
            System.out.println("Terminando proceso");
        }

        System.out.println("Terminando el programa");

        // System.out.println("El numero de letras de tu nombre es: "+nombre.length());

         */


        Operaciones operaciones = new Operaciones();
       // operaciones.divicionEntre0(8);
        operaciones.crearFichero("/cosa/raiz/dato/ejmplo.txt");

    }
}
