import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

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
        System.out.println("Escribe primero numero");
        int numero1 = lectorTeclado.nextInt();
        System.out.println("Escribe segundo numero");
        int numero2 = lectorTeclado.nextInt();
        int menor;
        if (numero2>numero1){
            menor = numero1;
        }else {
            menor=numero2;
        }
        boolean finalizacion = false;
        int mayorComun=1;
        do {
            for (int i=1;i<=menor;i++){
                if (numero2 % i == 0 && numero1 % i == 0){
                    mayorComun=i;
                }

                if (i==menor-1){
                    finalizacion=true;
                }
            }
        }while(!finalizacion);
        System.out.println(mayorComun);
    }
    public static void ejercicio3(){
       int random1;
       int mayarNumero = 0;
        do {
            random1 = random.nextInt(0,100);
            System.out.println(random1);
            if (random1 > mayarNumero){
                mayarNumero = random1;
            }
        } while (random1 != 0);
        System.out.println("Mayor numero: "+mayarNumero);
    }
    public static void ejercicio4() {
        System.out.println("Introduce un numero no negativo: ");
        int numero = lectorTeclado.nextInt();

        String binario = null;
        String octal = null;
        String hexadecimal = null;

        if (numero < 0) {
            System.out.println("Error...");
        } else {
            binario = Integer.toBinaryString(numero);
            octal = Integer.toOctalString(numero);
            hexadecimal = Integer.toHexString(numero).toUpperCase();

            System.out.printf("El numero %d en binario: %s\n", numero, binario);
            System.out.println("El numero "+numero+" en octal: "+octal);
            System.out.println("El numero "+numero+" en hexadecimal: "+hexadecimal);
        }


    }
    public static void ejercicio5(){
        int numero = random.nextInt(0,20);
        int adivina = 0;
        int adivinacion;

        System.out.println("Adivina el numero: ");
        do {
            System.out.println("Lo siento, intentalo de nuevo: ");
            adivina++;
            adivinacion = lectorTeclado.nextInt();
        }
        while (adivinacion != numero);

        System.out.printf("Enhorabuena, has acertado el número en %d intentos\n",adivina);
    }
    public static void ejercicio6(){
        boolean ejecucion = true;
        int record = Integer.MAX_VALUE;

        do {
            int intentos = 0;
            int adivinacion;
            int numero = random.nextInt(1,20);
            System.out.println("Adivina el numero: ");
            do {
                adivinacion = lectorTeclado.nextInt();
                if (adivinacion != numero) {
                    System.out.println("Lo siento, intentalo de nuevo: ");
                }
                intentos++;
            }
            while (adivinacion != numero);

            System.out.printf("Enhorabuena, has acertado el número en %d intentos\n", intentos);
            if (intentos<record){
                record = intentos;
                System.out.println("Has superado el record de intentos!");
            }
            System.out.println("Quieres volver a jugar (S/N)");
            char respuesta = lectorTeclado.next().toLowerCase().charAt(0);
            if (respuesta == 's') {
                ejecucion = true;
            }else if(respuesta == 'n') {
                System.out.println("Saliendo de programa...");
                break;
            }else {
                System.out.println("Error");
                System.out.println("Saliendo de programa...");
                break;
            }
        }while (ejecucion);


    }
    public static void ejercicio7(){
    }
    public static void ejercicio8(){
        int opcion;
        int numero1 = 0;
        int numero2 = 0;
        System.out.println("Bienvenido a la aplicación de calculos");
        do {
            System.out.println("Elige la opcion: ");
            System.out.printf("1.Sumar\n2.Restar\n3.Multiplicar\n4.Dividir\n5.Modulo\n6.Salir\n-----------------------\n");
            System.out.print("--> ");opcion = lectorTeclado.nextInt();


            if (opcion < 6) {
                System.out.println("Introduce primer numero: ");
                numero1 = lectorTeclado.nextInt();
                System.out.println("Introduce segundo numero: ");
                numero2 = lectorTeclado.nextInt();
            } else if (opcion > 6) {
                System.out.println("Error...");
            }

            switch (opcion){
                case 1:
                    int suma = numero1 + numero2;
                    System.out.printf("El resultado de la operación es: %d + %d = %d\n",numero1,numero2,suma);
                    break;
                case 2:
                    int resta = numero1 - numero2;
                    System.out.printf("El resultado de la operación es: %d - %d = %d\n",numero1,numero2,resta);
                    break;
                case 3:
                    int multiplicacion = numero1 * numero2;
                    System.out.printf("El resultado de la operación es: %d * %d = %d\n",numero1,numero2,multiplicacion);
                    break;
                case 4:
                    int divicion = numero1 / numero2;
                    System.out.printf("El resultado de la operación es: %d / %d = %d\n",numero1,numero2,divicion);
                    break;
                case 5:
                    int modulo = numero1 % numero2;
                    System.out.printf("El resultado de la operación es: %d % %d = %d\n",numero1,numero2,modulo);
                    break;
                case 6:
                    System.out.println("Saliendo de programa...");
                    break;
            }

        } while (opcion != 6);



    }
    public static void ejercicio9(){
        int opcion;
        int numero = 0;
        System.out.println("Bienvenido a la aplicación de cambios de base");
        do {
            System.out.println("Elige la opcion: ");
            System.out.printf("1.Pasar a base 2\n2.Pasar a base 8\n3.Pasar a base 16\n4.Salir\n-----------------------------\n");
            opcion = lectorTeclado.nextInt();

            if (opcion < 4) {
                System.out.print("Introduce el numero: ");
                numero = lectorTeclado.nextInt();
            } else if (opcion > 4) {
                System.out.println("Error...");
            }

            if (numero < 0){
                System.out.println("No válido, introduce otro");
            }

            switch (opcion){
                case 1:
                    String base2 = Integer.toBinaryString(numero);
                    System.out.printf("El numero %d en base 2 = %s\n",numero,base2);
                    break;
                case 2:
                    String base8 = Integer.toOctalString(numero);
                    System.out.printf("El numero %d en base 8 = %s\n",numero,base8);
                    break;
                case 3:
                    String base16 = Integer.toHexString(numero);
                    System.out.printf("El numero %d en base 16 = %s\n",numero,base16);
                    break;
                case 4:
                    System.out.println("Saliendo de programa...");
                    break;
            }
        }while (opcion != 4);
    }
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
