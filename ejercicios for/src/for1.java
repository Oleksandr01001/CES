import java.util.Locale;
import java.util.Scanner;
import java.util.Random;
public class for1 {
    static Random random = new Random();
    static Scanner lectorTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        //ejercicio0();
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        //ejercicio7();
        //ejercicio8();
        //ejercicio9();
        //ejercicio10();
        //ejercicio11();
        //ejercicio12();
        //ejercicio13();
        //ejercicio14();
        //ejercicio15();
        ejercicio16();
    }
    public static void ejercicio0(){
        System.out.println("Introduce un numero:");
        int numero = lectorTeclado.nextInt();
        for (int i=0; i<11; i++){
            System.out.printf("%d * %d = %d\n", numero,i,numero*i);
        }
    }
    public static void ejercicio1(){
        System.out.println("Cuantas temperaturas quieres introducir?");
        int numero = lectorTeclado.nextInt();
        int temperatura =0;
        int sumatorio = 0;

        if(numero <= 0){
            numero = 10;
        }
        for (int i =0; i < numero; i++){
            System.out.println("Introduce temperatura:");
            temperatura = lectorTeclado.nextInt();
            sumatorio = sumatorio + temperatura;

        }
        System.out.println("La suma de todas las temperaturas es "+sumatorio);
        System.out.println("La media de todas las temperaturas es "+(float)sumatorio/numero);
    }
    public static void ejercicio2(){
        System.out.println("Introduce un numero:");
        int numero = lectorTeclado.nextInt();
        for (int i=0; i<11; i++){
            System.out.printf("%d * %d = %d\n", numero,i,numero*i);
        }
    }
    public static void ejercicio3(){
        int multiplicacion = 0;

        for(int i = 1; i <= 10; i++){
            for (int n = 1; n<= 10; n++){
                multiplicacion = i * n;
                System.out.printf("%d * %d = %d\n",i ,n ,multiplicacion);
            }

        }
    }
    public static void ejercicio4(){
        System.out.println("Introduce primer numero:");
        int n1 = lectorTeclado.nextInt();

        System.out.println("Introduce segundo numero:");
        int n2 = lectorTeclado.nextInt();

        int multiplicacin = 0;
        for(int i = n1; i <= n2; i++) {
            for (int n = 1; n <= 10; n++) {
                int multiplicacion = i * n;
                System.out.printf("%d * %d = %d\n", i, n, multiplicacion);
            }
        }
        
    }
    public static void ejercicio5() {
        System.out.println("Introduca la base: ");
        int base = lectorTeclado.nextInt();
        System.out.println("Introduce exponente: ");
        int exponente = lectorTeclado.nextInt();
        int resultado = 1;

        if (base == 0 && exponente == 0) {
            System.out.println("Error");
        } else if (exponente == 0) {
            System.out.println(1);
        } else {
            for (int i = 1; i <= exponente; i++) {
                resultado *= base;
            }
            System.out.println(resultado);
        }
    }
    public static void ejercicio6(){
        System.out.println("Introduce primer dado: ");
        int dado1 = lectorTeclado.nextInt();
        System.out.println("Introduce segundo dado: ");
        int dado2 = lectorTeclado.nextInt();

        if (dado2 > dado1) {
            for (int i = dado1; i <= dado2; i++) {
                if (i % 2 == 0) {
                    System.out.println("Numero par: " + i);
                }
            }
        } else {
            for (int i = dado2; i <= dado1; i++) {
                if (i % 2 == 0) {
                    System.out.println("Numero par: " + i);
                }
            }
        }

    }
    public static void ejercicio7(){
        System.out.println("Cuantas veces quiere tirar dado? ");
        int veces = lectorTeclado.nextInt();

        if (veces < 0){
            veces = 100;
        }
        for (int i = 1; i <= veces; i++){
            int lanzamiento = random.nextInt(1,6);

            System.out.printf("Dado "+ i +" "+"es: %d\n",lanzamiento);
        }
    }
    public static void ejercicio8(){
        double positivos = 0;
        int cantidadPositivos=0;
        int cantidadCeros = 0;
        double negativos = 0;
        int cantidadNegativos=0;
        for (int i=0;i<10;i++){
            System.out.println("Escribe un numero:");
            int numero = lectorTeclado.nextInt();
            if (numero>0){
                positivos+=numero;
                cantidadPositivos++;
            } else if (numero==0) {
                cantidadCeros++;
            } else {
                negativos+=numero;
                cantidadNegativos++;
            }

        }
        System.out.println("Cantidad de ceros:"+cantidadCeros);
        double mediaPositivos = positivos/cantidadPositivos;
        System.out.printf("Media de positivos:%.2f\n",mediaPositivos);
        double mediaNegativos = negativos/cantidadNegativos;
        System.out.printf("Media de negativos:%.2f",mediaNegativos);
    }
    public static void ejercicio9(){
        int cantidadSueldos = 0;
        int suma = 0;
        float media = 0;
        int masmil = 0;
        for (int i = 0; i < 10; i++){
            System.out.println("Introduce el sueldo: ");
            int sueldos = lectorTeclado.nextInt();
            cantidadSueldos++;
            suma += sueldos;
            media = suma / cantidadSueldos;
            if (sueldos > 1000){
                masmil ++;
            }
        }
        System.out.println("Suma total de los sueldos: "+suma);
        System.out.println("Mas de 1000: "+masmil);
        System.out.println("La media de los sueldos: "+media);

    }
    public static void ejercicio10(){
        int aprobados = 0;
        int condicionados = 0;
        int suspensos = 0;

        for (int i = 0; i < 6; i++){
            System.out.println("Introduce la nota: ");
            int nota = lectorTeclado.nextInt();

            if (nota == 4){
                condicionados++;
            } else if (nota > 4) {
                aprobados++;
            } else {
                suspensos++;
            }
        }
        System.out.println("Aprobados: "+aprobados);
        System.out.println("Condicionados: "+condicionados);
        System.out.println("Suspensos: "+suspensos);
    }
    public static void ejercicio11(){
        System.out.println("Introduce lado: ");
        int lado = lectorTeclado.nextInt();
        for (int i = 0; i < lado; i++){
            for (int j = 0; j < lado; j++){
                System.out.print("+ ");
            }
            System.out.println();
        }
    }
    public static void ejercicio12(){
        System.out.print("Ingrese el tamaño del lado del cuadrado: ");
        int lado = lectorTeclado.nextInt();

        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {

                if (i == 0 || i == lado - 1 || j == 0 || j == lado - 1) {
                    System.out.print("- ");
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
    }
    public static void ejercicio13(){
        System.out.println("Introduce una palabra: ");
        String palabra = lectorTeclado.next().toLowerCase(Locale.ROOT);
        String letra = "";

        for (int i = palabra.length() -1; i >= 0; i--) {
            letra += palabra.charAt(i);
        }
        System.out.println("Palabra inversa es: "+letra);
        boolean palabraIgual = palabra.equals(letra);
        System.out.println("Palabra igual: "+palabraIgual);

    }
    public static void ejercicio14(){

    }
    public static void ejercicio15(){
        int numero = random.nextInt(1,30);
        int intentos = 0;
        boolean ganador = false;

        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce el numero: ");
            int adivinacion = lectorTeclado.nextInt();
            intentos++;

            if (adivinacion == numero){
                System.out.printf("Has adivinado el número en %d intentos",intentos);
               ganador=true;
                break;
            }
        }
        if (!ganador){
            System.out.println("Lo siento, has agotado todos los intentos");
        }

    }
    public static void ejercicio16(){
        System.out.println("Introduce un numero entre 1 y 20: ");
        int numero = lectorTeclado.nextInt();
        int resto = 0;

        for (int i = numero; i < 1; i--) {
            for (int j = numero; j < 1; j--) {
                numero = numero * i;
            }


        }
        System.out.println(numero);
    }
}
