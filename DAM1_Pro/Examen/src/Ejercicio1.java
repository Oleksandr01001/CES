import java.util.Scanner;

public class Ejercicio1{

    public static void main(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.println("Introduce su nombre:");
        String nombre = lectorTeclado.next();

        System.out.println("Introduce su apedido:");
        String apedido = lectorTeclado.next();

        System.out.println("Introduce cuanto dinero tienes disponible:");
        int dineroDisponible = lectorTeclado.nextInt();

        System.out.println("Introduce precio play 5(sin iva):");
        float play = lectorTeclado.nextInt();

        System.out.println("Introduce precio IPhone 15(sin iva):");
        float iphone15 = lectorTeclado.nextInt();

        System.out.println("Introduce la IVA");
        float iva = lectorTeclado.nextFloat();
        play = play*(iva/100);
        iphone15 = iphone15*(iva/100);

        boolean compra_play = (dineroDisponible>play);
        boolean compra_iphone15 = (dineroDisponible>iphone15);
        boolean compra_los_dos = (dineroDisponible>(play+iphone15));

        System.out.printf("Te puedes comprar la play: %b\n",compra_play);
        System.out.printf("Te puedes comprar el iphone: %b\n",compra_iphone15);
        System.out.printf("Te puedes comprar las dos cosas: %b\n",compra_los_dos);


    }

}

