import java.util.Scanner;
import java.lang.Math;
public class EjercicioCinco {
    static Scanner lectorTeclado= new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduce la altura:");
        int altura = lectorTeclado.nextInt();

        System.out.println("Introduce la base");
        int base = lectorTeclado.nextInt();

        System.out.println("Introduce lado 1:");
        int lado1 = lectorTeclado.nextInt();

        System.out.println("Introduce lado 2:");
        int lado2 = lectorTeclado.nextInt();

        System.out.println("Introduce lado 3:");
        int lado3 = lectorTeclado.nextInt();


        float area = calculoArea(altura,base);
        System.out.printf("El area del triangulo con base %d y altura %d es: %.2f\n",base,altura,area);

        boolean isosceles = lado1 == lado2 && lado2 != lado3 || lado3 == lado1 && lado1 != lado2 || lado2 == lado3 && lado3 != lado1;
        System.out.printf("El triángulo es isósceles: %b\n",isosceles);

        boolean equilatero = lado1 == lado2 && lado1 == lado3;
        System.out.printf("El triángulo es equilátero: %b\n",equilatero);

        System.out.println("Introduce el radio del circulo:");
        int radio = lectorTeclado.nextInt();

        double areaCirculo = calculoAreaCirculo(radio);
        System.out.printf("El area del circulo es: %.2f",areaCirculo);

    }
    public static float calculoArea(float altura, float base) {
    return (altura * base) / 2;
    }
    public static double calculoAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }
}