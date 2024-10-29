import java.util.Scanner;
public class Ejercicio3 {
    static Scanner lectorTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        int pin = 1111;
        int pinIntroducido;
        double saldo = 0;
        double saldoIntroducido;
        do {
            System.out.println("1.Ingresar dinero.");
            System.out.println("2.Sacar dinero.");
            System.out.println("3.Ver estado de la cuenta.");
            System.out.println("4.Salir.");
            System.out.println("Elige la opcion: ");
            opcion = lectorTeclado.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Introduce el pin: ");
                    pinIntroducido = lectorTeclado.nextInt();
                    System.out.println("Introduce el saldo que quieres poner: ");
                    saldoIntroducido = lectorTeclado.nextInt();

                    if (pin == pinIntroducido){
                        System.out.println("saldo introducido con éxito");
                        saldo += saldoIntroducido;
                    }else {
                        System.out.println("Pin incorrecto...");
                    }
                    break;
                case 2:
                    System.out.println("Introduce el pin: ");
                    pinIntroducido = lectorTeclado.nextInt();
                    System.out.println("Introduce el saldo que quieres sacar: ");
                    saldoIntroducido = lectorTeclado.nextInt();
                    if (saldoIntroducido <= saldo && pinIntroducido == pin){
                        saldo -= saldoIntroducido;
                        System.out.println("Has sacado el dinero con exito");
                    }else if (saldoIntroducido > saldo || pinIntroducido != pin){
                        System.out.println("Imposible sacar dinero");
                        System.out.println("No tienes bastante dinero o el pin fue introducido incorrecto...");
                    }
                    break;
                case 3:
                    System.out.println("Introduce el pin: ");
                    pinIntroducido = lectorTeclado.nextInt();
                    if (pinIntroducido == pin){
                        System.out.println("En tu cuenta hay "+saldo);
                    }
                    break;
                case 4:
                    break;
            }
        }while (opcion != 4);


    }
}
