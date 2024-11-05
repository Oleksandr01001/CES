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

            if (intentoClave == clave) {
                System.out.println("Perfecto, la caja ha sido abierta");
                finalizacion = true;
            }else if (intentoClave != clave && intento < intentos) {
                System.out.println("Intento fallido, prueba de nuevo...");
                intento++;
            }else if (intento == intentos) {
                System.out.println("Lo siento, caja bloqueada...");
                finalizacion = true;
            }



        }while (finalizacion != true);
    }
}
