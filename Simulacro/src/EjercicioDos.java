import java.util.Scanner;

public class EjercicioDos {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Introduce primer nomre:");
        String nombre = lectorTeclado.next();
        System.out.println("Introduce el numero de jugadores:");
        int jugadores = lectorTeclado.nextInt();
        System.out.println("El presupuesto:");
        int presupuesto = lectorTeclado.nextInt();

        System.out.println("Introduce segundo nombre:");
        String nombre2 = lectorTeclado.next();
        System.out.println("Introduce el numero de jugadores");
        int jugadores2 = lectorTeclado.nextInt();
        System.out.println("El presupuesto:");
        int presupuesto2 = lectorTeclado.nextInt();

        System.out.println("Introduce tercer nombre:");
        String nombre3 = lectorTeclado.next();
        System.out.println("Introduce el numero de jugadores");
        int jugadores3 = lectorTeclado.nextInt();
        System.out.println("El presupuesto:");
        int presupuesto3 = lectorTeclado.nextInt();

        boolean condicion1 = (jugadores >= 11) && (jugadores2 >= 11) && (jugadores3 >= 11);
        boolean condicion2 = (jugadores % 2 == 0) && (jugadores2 % 2 == 0) && (jugadores3 % 2 == 0);
        boolean condicion3 = (presupuesto > 0) && (presupuesto2 > 0) && (presupuesto3 > 0);
        boolean condicion4 = (condicion1 == true) && (condicion3 = true);

        System.out.printf("Los participantes tienen 11 jugadores: %b\n",condicion1);
        System.out.printf("Los participantes tienen jugadores pares: %b\n",condicion2);
        System.out.printf("Los participantes tienen presupuestos positivos: %b\n",condicion3);
        System.out.printf("La liga está preparada para empezar: %b",condicion4);
    }
}
