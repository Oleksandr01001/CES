import java.util.Scanner;
import java.util.Random;
public class Ejercicio2 {

    static Random random = new Random();
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduce un numero:");
        int numero = lectorTeclado.nextInt();

        int numeroMasGrande = 0;
        int numeroMasPequeno = 100;
        int suma = 0;

        for (int i=0; i<10; i++){

            int numeroRandom = random.nextInt(0,100);
            suma+= numeroRandom;

            if (numeroRandom > numeroMasGrande){
                numeroMasGrande = numeroRandom;
            }
            if (numeroRandom<numeroMasPequeno){
                numeroMasPequeno=numeroRandom;
            }
            if (numeroRandom==numero){
                System.out.println("Usuario ha adivinado el numero");
            }

        }
        float medioGenerado = suma/10;

        System.out.println("Suma de los numero generados:"+suma);
        System.out.println("Numero mas grande:"+numeroMasGrande);
        System.out.println("Numero mas pequeño:"+numeroMasPequeno);
        System.out.printf("Numero medio generado:%.2f\n",medioGenerado);



    }

}
