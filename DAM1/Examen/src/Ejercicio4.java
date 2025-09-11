import java.util.Scanner;
public class Ejercicio4 {
    static Scanner lectorTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce su nombre:");
        String nombre = lectorTeclado.next();

        System.out.println("Introduce su apellido:");
        String apellido = lectorTeclado.next();

        System.out.println("Introduce el sueldo que espera recibir:");
        int sueldo = lectorTeclado.nextInt();

        System.out.println("Introduce su edad:");
        int edad = lectorTeclado.nextInt();

        System.out.println("Introduce el dia de su cumpleaños:");
        int cumple = lectorTeclado.nextInt();

        System.out.println("Inroduce si tiene carne de conducir:");
        boolean carnet = lectorTeclado.nextBoolean();

        boolean par = cumple % 2 == 0;

        String nomreCompleto = nombre +" "+ apellido;

        boolean condicion1 = (edad < 50) && (sueldo < 40000) && (carnet == true);
        boolean condicion2 = (edad > 45) && (sueldo < 20000) && (par);

        System.out.printf("Con los datos introducidos, el candidato cuyo nombre es %s\n" +
                "tiene como resolución:%b\n",nomreCompleto,condicion1);

        System.out.printf("Con los datos introducidos, el candidato cuyo nombre es %s\n" +
                "tiene como resolución:%b",nomreCompleto,condicion2);


    }
}
