import java.util.Scanner;
public class EjercicioUn02 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Introduce nombre: ");
        String nombre = scanner.next();

        System.out.println("Introduce apellido:");
        String apellido = scanner.next();

        System.out.println("Introduce edad:");
        int edad = scanner.nextInt();

        System.out.println("Introduce altura:");
        float altura = scanner.nextFloat();

        System.out.println("Introduce peso:");
        int peso = scanner.nextInt();

        System.out.println("Introduce sexo:");
        String sexo = scanner.next();

        float imc = calculoIMC(peso,altura);

        System.out.printf("Hola %s tu IMC teniendo en cuenta tu altura de %.0fcm y tu peso de %dkg, tiene un valor " +
                "de %.2f",nombre,altura,peso,imc);

    }

    public static float calculoIMC(float peso, float altura) {
        return peso / altura * altura;

    }
}
