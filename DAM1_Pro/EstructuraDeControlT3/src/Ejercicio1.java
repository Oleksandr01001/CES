import java.util.Scanner;
public class Ejercicio1 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce un entero");
        int a = lectorTeclado.nextInt();
        String s = null;
        if (a % 2 == 0) {
            s = "Es par";
        }
        System.out.println(s);
    }
}
