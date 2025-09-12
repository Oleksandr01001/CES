import java.util.Scanner;

public class Entrada {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Primer programa de repaso");


        //if_1();
        if_2();

    }

    public static void if_1() {
        System.out.println("Introduce primer numero: ");
        int num1 = scanner.nextInt();
        System.out.println("Introduce segundo numero: ");
        int num2 = scanner.nextInt();

        if (num1 > num2) {
            System.out.println("El primero es mayor que el segundo");
        } else if (num1 == num2) {
            System.out.println("Los numeros son iguales");
        } else {
            System.out.println("Segundo numero es mayor que el primero");
        }
    }
    public static void if_2() {
        System.out.println("Introduce un numero: ");
        int num = scanner.nextInt();
        boolean multiplo = num % 20 == 0;
        boolean rango = num >= -100 && num <= 100;

        if(multiplo && rango) {
            System.out.println("Es múltiplo de 20 y está entre -100 y 100");
        } else if (multiplo) {
            System.out.println("Es multiplo de 20, pero no esta en rango");
        } else if (rango) {
            System.out.println("Esta en rango, pero no es multiplo de 20");
        } else {
            System.out.println("No es multiplo de 20 y no esta en rango");
        }
    }
    public static void if_3() {
        System.out.println("Introduce un numero: ");
        int num = scanner.nextInt();
        boolean digitos = num > 999 && num <= 9999;
        int numInverso;

        

        if(digitos){
            System.out.println("Numero tiene 4 digitos");
        }



    }
}
