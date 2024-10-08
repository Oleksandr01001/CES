import java.util.Scanner;
public class Switch {
    static Scanner lectorTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        ejercicio5();

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
}
