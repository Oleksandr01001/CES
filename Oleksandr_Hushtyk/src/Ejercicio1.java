import java.util.Scanner;
public class Ejercicio1 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce primer operando: ");
        int operando1 = lectorTeclado.nextInt();
        System.out.println("Introduce segundo operando: ");
        int operando2 = lectorTeclado.nextInt();

        int opcion = 0;

        if (operando1 >= 0 && operando2 >= 0){
            System.out.println("Elige la opcion: ");
            System.out.println("1.Suma");
            System.out.println("2.Resta");
            System.out.println("3.Multiplicacion");
            System.out.println("4.Division");
            opcion = lectorTeclado.nextInt();
            switch (opcion){
                case 1:
                    int suma = operando1 + operando2;
                    System.out.printf("La suma de %d y %d = %d",operando1,operando2,suma);
                    break;
                case 2:
                    int resta = operando1 - operando2;
                    System.out.printf("La resta de %d y %d = %d",operando1,operando2,resta);
                    break;
                case 3:
                    int multiplicacion = operando1 * operando2;
                    System.out.printf("La multiplicacion de %d y %d = %d",operando1,operando2,multiplicacion);
                    break;
                case 4:
                    int division = operando1 / operando2;
                    System.out.printf("La division de %d y %d = %d (no es float)",operando1,operando2,division);
                    break;
            }
        }else {
            System.out.println("No se pueden realizar operaciones sobre\n" +
                    "números negativos");
        }

    }
}
