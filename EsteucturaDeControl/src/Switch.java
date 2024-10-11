import java.util.Scanner;
public class Switch {
    static Scanner lectorTeclado = new Scanner(System.in);
    public static void main(String[] args) {
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



    }
    public static void ejercicio1(){

        System.out.println("Por favor introduce el numero:");
        int numero = lectorTeclado.nextInt();

        switch (numero) {
            case 1:
                System.out.println("Es lunes");
                break;
            case 2:
                System.out.println("Es martes");
                break;
            case 3:
                System.out.println("Es miercoles");
                break;
            case 4:
                System.out.println("Es jueves");
                break;
            case 5:
                System.out.println("Es viernes");
                break;
            case 6:
                System.out.println("Es sabado");
                break;
            case 7:
                System.out.println("Es domingo");
                break;

        }
    }
    public static void ejercicio2(){
        System.out.println("Introduce una letra:");
        char letra = lectorTeclado.next().charAt(0);

        switch (letra){
            case 'a':
                System.out.println("Es vocal");
                break;
            case 'o':
                System.out.println("Es vocal");
                break;
            case 'u':
                System.out.println("Es vocal");
                break;
            case 'e':
                System.out.println("Es vocal");
                break;
            case 'i':
                System.out.println("Es vocal");
                break;
            default:
                System.out.println("Es consonante");
                break;
        }
    }
    public static void ejercicio3(){
        System.out.println("Introduce un numero entero:");
        int numero = lectorTeclado.nextInt();
        int resto = numero%2;
        switch (resto){
            case 0:
                System.out.println("Es par");
                break;
            default:
                System.out.println("Es impar");
        }

    }
    public static void ejercicio4(){
        System.out.println("Introduce el mes como numero de 1 a 12:");
        int mes = lectorTeclado.nextInt();

        switch (mes){
            case 1:
                System.out.println("Tiene 31 dias");
                break;
            case 2:
                System.out.println("Tiene 28 o 29 dias");
                break;
            case 3:
                System.out.println("Tiene 31 dias");
                break;
            case 4:
                System.out.println("Tiene 30 dias");
                break;
            case 5:
                System.out.println("Tiene 31 dias");
                break;
            case 6:
                System.out.println("Tiene 30 dias");
                break;
            case 7:
                System.out.println("Tiene 31 dias");
                break;
            case 8:
                System.out.println("Tiene 31 dias");
                break;
            case 9:
                System.out.println("Tiene 30 dias");
                break;
            case 10:
                System.out.println("Tiene 31 dias");
                break;
            case 11:
                System.out.println("Tiene 30 dias");
                break;
            case 12:
                System.out.println("Tiene 31 dias");
                break;
        }
    }
    public static void ejercicio5(){
        System.out.println("Introduce un numero de 1 al 12");
        int numero = lectorTeclado.nextInt();

        switch (numero){
            case 1:
                System.out.println("Es enero");
                break;
            case 2:
                System.out.println("Es febrero");
                break;
            case 3:
                System.out.println("Es marzo");
                break;
            case 4:
                System.out.println("Es abril");
                break;
            case 5:
                System.out.println("Es mayo");
                break;
            case 6:
                System.out.println("Es junio");
                break;
            case 7:
                System.out.println("Es julio");
                break;
            case 8:
                System.out.println("Es agosto");
                break;
            case 9:
                System.out.println("Es septiembre");
                break;
            case 10:
                System.out.println("Es octubre");
                break;
            case 11:
                System.out.println("Es novimbre");
                break;
            case 12:
                System.out.println("Es diciembre");
                break;
        }
    }
    public static void ejercicio6(){
        System.out.println("Introduce un numero de 1 al 4");
        int numero = lectorTeclado.nextInt();

        switch (numero){
            case 1:
                System.out.println("Opcion 1 seleccionada:");
                break;
            case 2:
                System.out.println("Opcion 2 seleccionada:");
                break;
            case 3:
                System.out.println("Opcion 3 seleccionada:");
                break;
            case 4:
                System.out.println("Opcion 4 seleccionada:");
                break;
        }
    }
    public static void ejercicio7(){
        System.out.println("Introduce una nota del 1 al 5:");
        int nota = lectorTeclado.nextInt();

        switch (nota){
            case 1:
                System.out.println("Suspenso");
                break;
            case 2:
                System.out.println("Aprobado");
                break;
            case 3:
                System.out.println("Notable");
                break;
            case 4:
                System.out.println("Sobresaliente");
                break;
            case 5:
                System.out.println("Genial");
                break;
        }
    }
    public static void ejercicio8(){
        System.out.println("Introduce un simbolo de operacion:");
        char simbolo = lectorTeclado.next().charAt(0);
        System.out.println("Introduce primer numero:");
        int numero1 = lectorTeclado.nextInt();
        System.out.println("Introduce segundo numero:");
        int numero2 = lectorTeclado.nextInt();
        float variable;

        switch (simbolo){
            case '+':
                variable = numero1 + numero2;
                System.out.println(variable);
                break;
            case '-':
                variable = numero1 - numero2;
                System.out.println(variable);
                break;
            case '*':
                variable = numero1 * numero2;
                System.out.println(variable);
                break;
            case '/':
                variable = numero1 / numero2;
                System.out.println(variable);
                break;
        }

    }
    public static void ejercicio9(){
        System.out.println("Introduce un numero de 1 al 12");
        int numero = lectorTeclado.nextInt();

        switch (numero){
            case 1:
            case 2:
            case 3:
                System.out.println("Es invirno");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("Es primavera");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("Es verano");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("Es otoño");
                break;
        }
    }
    public static void ejercicio10(){
        System.out.println("Introduce el codigo:");
        int codigo = lectorTeclado.nextInt();

        switch (codigo){
            case 1:
                System.out.println("El precio de Iphone 14 pro es 1000 euros");
                break;
            case 2:
                System.out.println("El precio de Poco m4 pro es 450 euros");
                break;
            case 3:
                System.out.println("El precio de Iphone 15 pro es 1500 euros");
                break;
            case 4:
                System.out.println("El precio de Iphone 16 pro es 1600 euros");
                break;
            case 5:
                System.out.println("El precio de Iphone 11 pro es 800 euros");
                break;
        }
    }
}
