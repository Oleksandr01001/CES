import java.util.Scanner;
public class Ejercicio1 {
    static Scanner lectorTeclado = new Scanner(System.in);
    public static void main(String[] args) {
       int numero;
       int sumaPares = 0;
       int sumaImpares = 0;
       double mediaParesConDecimales = 0;
       double mediaImparesConDecimales = 0;
       int cantidadNumeros = 0;
       int ceros = 0;
       int pares = 0;
       int impares = 0;

        do {
            System.out.println("Introduce el numero: ");
            numero = lectorTeclado.nextInt();
            if (numero % 2 == 0){
                sumaPares += numero;
                pares++;
                cantidadNumeros++;
            } else if (numero == 0) {
                ceros++;
                cantidadNumeros++;
            } else if (numero % 2 != 0) {
                impares++;
                cantidadNumeros++;
            }

        }while (numero >= 0);
        mediaParesConDecimales = sumaPares / pares;
        mediaImparesConDecimales = sumaImpares / impares;
        System.out.println("1-Suma de los números pares introducidos.");
        System.out.println("2-Media de los números pares introducidos con dos decimales.");
        System.out.println("3-Media de los números impares introducidos con dos decimales.");
        System.out.println("4-Cuántos números hemos introducido.");
        System.out.println("5-Cuantos números de los introducidos han sido ceros, cuántos han sido pares\n" +
                "y cuantos impares.");
        System.out.println("6.-Salir.");
        System.out.println("Introduce la opcion: ");
        int opcion = lectorTeclado.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Suma de los números pares introducidos: "+sumaPares);
                break;
            case 2:
                System.out.println("Media de los números pares introducidos con dos decimales: "+mediaParesConDecimales);
                break;
            case 3:
                System.out.println("Media de los números impares introducidos con dos decimales: "+mediaImparesConDecimales);
                break;
            case 4:
                System.out.println("Cuántos números hemos introducido: "+cantidadNumeros);
                break;
            case 5:
                System.out.printf("Cuantos números de los introducidos han sido ceros, cuántos han sido pares\n" +
                        "y cuantos impares:\n Ceros: %d\nPares %d\nImpares: %d ",ceros,pares,impares);
                break;
            case 6:
                break;
        }


    }
}
