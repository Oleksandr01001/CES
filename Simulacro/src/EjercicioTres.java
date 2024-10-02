import java.util.Scanner;
public class EjercicioTres {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduce el precio de coche:");
        int precio = lectorTeclado.nextInt();

        System.out.println("En cuantos plazos lo va a pagar ?");
        int plazos = lectorTeclado.nextInt();

        int almes = precio / plazos;

        System.out.printf("Vas a pagar el coche de %d en %d meses, con un total de %d cada plazo (sin\n" +
                "tener en cuenta los intereses)",precio,plazos,almes);
    }
}
