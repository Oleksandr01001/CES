import java.util.Scanner;
public class Ejercicio2 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        int random = (int)(Math.random() * 9000) + 1000;
        System.out.println("Introduce un número entre 1000 y 9999:");
        int numeroUsuario = lectorTeclado.nextInt();

        int unidades = random % 10;
        int decenas = (random / 10) % 10;
        int centenas = (random / 100) % 10;
        int millares = random / 1000;

        int unidadesUsuario = numeroUsuario % 10;
        int decenasUsuario = (numeroUsuario / 10) % 10;
        int centenasUsuario = (numeroUsuario / 100) % 10;
        int millaresUsuario = numeroUsuario / 1000;

        boolean Unidades1 = unidades == unidadesUsuario;
        boolean Decenas1 = decenas == decenasUsuario;
        boolean Centenas1 = centenas == centenasUsuario;
        boolean Millares1 = millares == millaresUsuario;
        boolean Todos1 = Unidades1 && Decenas1 && Centenas1 && Millares1;

        System.out.println("Número de la lotería: " + random);
        System.out.println("Has acertado las unidades: " + Unidades1);
        System.out.println("Has acertado las decenas: " + Decenas1);
        System.out.println("Has acertado las centenas: " + Centenas1);
        System.out.println("Has acertado los millares: " + Millares1);
        System.out.println("Has acertado todos: " + Todos1);

    }
}