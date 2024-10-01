import java.util.Scanner;
public class EjercicioUno {
    static Scanner lectorTeclado= new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Entroduce su nombre:");
        String nombre = lectorTeclado.next();
        System.out.println("Introduce su apellido:");
        String apellido = lectorTeclado.next();
        System.out.println("Introduce su edad:");
        int edad = lectorTeclado.nextInt();
        System.out.println("Introduce su altura:");
        float altura = lectorTeclado.nextFloat();
        System.out.println("Introduce su peso:");
        float peso = lectorTeclado.nextInt();
        System.out.println("Introduce su sexo:");
        //char sexo = lectorTeclado.next().charAt(0);
        String sexo = lectorTeclado.next();
        float IMC = calculoIMC(peso,altura);
        System.out.printf("Hola %s ti IMC "+
                "teniendo en cuenta tu altura de %.2fm y "+
                "tu peso de %.2fkg, tiene un valor de %.2f\n",nombre,altura,peso,IMC);
    }
    public static float calculoIMC(float peso,float altura) {
        // return (float) (peso / Math.pow(altura,2));
        return peso / altura*altura;



    }
}
