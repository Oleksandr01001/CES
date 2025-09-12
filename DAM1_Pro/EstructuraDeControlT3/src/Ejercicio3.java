import java.util.Scanner;
public class Ejercicio3 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce un numero entero");
        int a = lectorTeclado.nextInt();

        if (a<10){
            if (a < 0){
                System.out.println("negativo");
            } else {
                System.out.println("un digito");
            }
        } else if (a<100){
            System.out.println("dos digitos");
        } else if(a<1000) {
            System.out.println("tres digitos");
        }
    }
}