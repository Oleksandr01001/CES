import java.util.Random;
import java.util.Scanner;

public class ejercicio {

    static Scanner lectorTeclado = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        int opcion = 0;
        String nombre;
        int telefono;
        int cantidadIngredientes;
        double pizzasCobradas = 0;
        Object[][] listaPedidos = {};

        do {
            System.out.println("1. Realizar pedido");
            System.out.println("2. Servir pedido");
            System.out.println("3. Mostrar pedidos pendientes");
            System.out.println("4. Mostrar caja");
            System.out.println("5. Salir");

            System.out.println("Introduce la opcion que quiere elegir: ");
            opcion = lectorTeclado.nextInt();

            switch (opcion) {
                case 1:

                    System.out.println("Introduce tu nombre: ");
                    nombre = lectorTeclado.next();

                    System.out.println("Introduce tu telefono:");
                    telefono = lectorTeclado.nextInt();

                    System.out.println("Introduce la cantidad de ingredientes:");
                    cantidadIngredientes = lectorTeclado.nextInt();
                    System.out.println("1.Pepinos(0,20$)\n2.Tomate(0,20$)\n3.Ketchup(0,15$)\n4.Mayonesa(0,15$)\n" +
                            "5.Terminar");



                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("El total de pizzas cobradas "+pizzasCobradas);
                    break;
                case 5:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
            }

        } while (opcion != 5);

    }

}
