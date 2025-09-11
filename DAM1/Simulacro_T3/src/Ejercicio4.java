import java.util.Locale;
import java.util.Scanner;
public class Ejercicio4 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce la palabra: ");
        String palabra = lectorTeclado.next();
        
        if (palabra.length() < 4){
            palabra = palabra.toUpperCase();
            System.out.println(palabra);
        } else if (palabra.length() >4 && palabra.length() <8 ) {
            palabra = palabra.toLowerCase();
            System.out.println(palabra);
        } else if (palabra.length() > 8 && palabra.length() <11) {
            palabra = palabra.replace("a","á")
                    .replace("o","ó")
                    .replace("u","ú")
                    .replace("e","é")
                    .replace("i","í");
            System.out.println(palabra);
        }else {
            String palindromo = "";
            for (int i = palabra.length() -1; i >= 0 ; i--) {
                palindromo += palabra.charAt(i);
            }
            System.out.println(palindromo);
        }

    }
}
