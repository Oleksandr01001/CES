import java.util.Scanner;

public class Entrada {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Primer programa de repaso");


        //if_1();
        //if_2();
        //if_3();
        //if_4();
        //if_5();

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
        if (num < 1000 || num > 9999) {
            System.out.println("El número no tiene 4 dígitos");
            return;
        }
        int u = num % 10, d = (num / 10) % 10, c = (num / 100) % 10, m = num / 1000;
        if (u == m && d == c) {
            System.out.println("Es capicúa");
        } else {
            System.out.println("No es capicúa");
        }

    }
    public static void if_4() {
        System.out.println("Introduce un numero: ");
        int num = scanner.nextInt();
        System.out.println("Entrada: "+num);

        if(num % 2 == 0) {
            num = num + 1;
        } else {
            num = num - 1;
        }
        System.out.println("Salida: "+num);
    }
    public static void if_5() {
        int n = scanner.nextInt();
        int res = n;
        if (n % 2 == 0) res += 2;
        if (n % 3 == 0) res += 3;
        if (n % 5 == 0) res += 5;
        if (res == n) res += 1;
        System.out.println(res);
    }
}
