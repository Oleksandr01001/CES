import java.util.Scanner;
public class Ejercicio3 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        int clave = 1111;
        boolean finalizacion = false;
        int intentoClave = 0;
        int intento = 0;
        int intentos = 3;

        do {
            System.out.println("Introduce clave: ");
            intentoClave = lectorTeclado.nextInt();

            if (intento >= intentos){
                System.out.println("Lo siento, caja bloqueada");
                finalizacion = true;
            }
            if (intentoClave == clave){
                System.out.println("Perfecto, la caja ha sido abierta");
                finalizacion = true;
            }if (intentoClave != clave && intento != intentos) {
                System.out.println("Intento fallido, prueba de nuevo");
                intento++;
            }

        }while (finalizacion != true);
    }
}
