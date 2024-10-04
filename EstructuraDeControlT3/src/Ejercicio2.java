import java.util.Scanner;
public class Ejercicio2 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce un numero entero");
        int a = lectorTeclado.nextInt();
         if (a % 2 == 0){
             a ++;
         } else if (a<10) {
             a--;
         } else if (a<100) {
             a*=2;
             a++;
         } else {
             a = 0;
         }

    }
}
