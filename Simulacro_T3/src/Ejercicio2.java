import java.util.Scanner;
public class Ejercicio2 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        int numero;
        int suspenso = 0;
        int sumaNostas = 0;
        double media = 0;
        for (int i = 0; i < 20; i++) {
            System.out.println("Introduce la nota: ");
            numero = lectorTeclado.nextInt();
            if (numero < 5) {
                suspenso++;
                sumaNostas += numero;
            } else {
                sumaNostas += numero;
            }
        }
        media = sumaNostas / 20;
        if (suspenso > 0){
            System.out.println("Suspensos :"+suspenso);
            System.out.println("La nota media: "+media);
        }else {
            System.out.println("La nota media: "+media);
        }
    }
}
