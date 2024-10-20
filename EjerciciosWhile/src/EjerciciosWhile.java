import java.util.Scanner;
import java.util.Random;
public class EjerciciosWhile {
    static Scanner lectorTeclado = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        //ejercicio1();
        ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        //ejercicio7();
        //ejercicio8();
        //ejercicio9();
        //extara1();
    }
    public static void ejercicio1(){
        int numero = 0;
        int sumaPositivos = 0;
        int sumaNegativos = 0;

        do {
            System.out.println("Introduce numero: ");
            numero = lectorTeclado.nextInt();
            if (numero > 0) {
                sumaPositivos += numero;
            } else if (numero < 0) {
                sumaNegativos += numero;
            }
        } while (numero != 0);
        System.out.println("Suma de los numeros positivos: "+sumaPositivos);
        System.out.println("Suma de los numeros negativos: "+sumaNegativos);

    }
    public static void ejercicio2(){
        System.out.println("Introduce el valor: ");
        int valor1 = lectorTeclado.nextInt();
        System.out.println("Introduce segundo valor: ");
        int valor2 = lectorTeclado.nextInt();
        int multiplo1;
        int multiplo2;

    }
    public static void ejercicio3(){
       int random1;
        do {
            random1 = random.nextInt(0,100);
            System.out.println(random1);
        } while (random1 != 0);
    }
    public static void ejercicio4(){}
    public static void ejercicio5(){}
    public static void ejercicio6(){}
    public static void ejercicio7(){}
    public static void ejercicio8(){}
    public static void ejercicio9(){}
    public static void extara1(){
       int opcion;
        do {
            System.out.printf("1.Opcion añadir\n2.Opcion borrar\n3.Opcion listar\n4.Opcion buscar\n5.Opcion salir\n");
            System.out.println("Introduce opcion elegida: ");
            opcion = lectorTeclado.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ejecutando opcion 1...");
                break;
                case 2:
                    System.out.println("Ejecutando opcion 2...");
                    break;
                case 3:
                    System.out.println("Ejecutando opcion 3...");
                    break;
                case 4:
                    System.out.println("Ejecutando opcion 4...");
                    break;
                case 5:
                    System.out.println("Ejecutando opcion 5...");
                    break;
                default:
                    System.out.println("Error...");
            }

        } while (opcion != 5);



    }

}
