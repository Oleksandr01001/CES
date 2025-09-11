import model.Terreno;
import utils.Orientacion;
import utils.ConstruccionException;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Terreno terreno = null;

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear Terreno");
            System.out.println("2. Construir Casa");
            System.out.println("3. Construir Habitación");
            System.out.println("4. Construir Piscina");
            System.out.println("5. Construir Anexo");
            System.out.println("6. Mostrar Terreno");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Metros del terreno: ");
                        int metros = scanner.nextInt();
                        System.out.print("Orientación (NORTE, SUR, ESTE, OESTE): ");
                        Orientacion orientacion = Orientacion.valueOf(scanner.next().toUpperCase());
                        System.out.print("Valoración inicial: ");
                        double valor = scanner.nextDouble();
                        terreno = new Terreno(metros, orientacion, valor);
                        break;
                    case 2:
                        System.out.print("Metros de la casa: ");
                        terreno.construirCasa(scanner.nextInt());
                        break;
                    case 3:
                        System.out.print("Metros de la habitación: ");
                        terreno.getCasa().construirHabitacion(scanner.nextInt());
                        break;
                    case 4:
                        terreno.getCasa().construirPiscina();
                        break;
                    case 5:
                        System.out.print("Metros del anexo: ");
                        terreno.getCasa().construirAnexo(scanner.nextInt());
                        break;
                    case 6:
                        System.out.println("Terreno: " + terreno.getMetrosCuadrados() + " m2, Valor: " + terreno.getValoracion());
                        break;
                    case 7:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}