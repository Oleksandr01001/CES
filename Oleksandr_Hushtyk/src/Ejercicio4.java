import java.util.Scanner;
public class Ejercicio4 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        boolean finalizarBase = false;
        do {

            System.out.println("Itroduce un numero: ");
            int numero = lectorTeclado.nextInt();
            String resultado = "";


            if (numero <=0){
                System.out.println("No se puede hacer la operacion.");
            } else {
                System.out.println("1.Base 2");
                System.out.println("2.Base 8");
                System.out.println("3.base 16");
                System.out.println("4.Salir");
                int opcion = lectorTeclado.nextInt();

                boolean finalizacion = false;

                switch (opcion){
                    case 1:
                        do {
                            if (numero % 2 == 0){
                                resultado = "0" + resultado;
                                numero = numero / 2;
                            } else {
                                resultado = "1" + resultado;
                                numero = numero / 2;
                            }
                            if (numero <= 1){
                                resultado = "1" + resultado;
                                finalizacion = true;
                            }
                        } while (finalizacion != true);
                        System.out.println(resultado);
                        break;
                    case 2:
                        do {
                            if (numero % 8 == 0){
                                resultado = "0" + resultado;
                                numero = numero / 8;
                            } else {
                                resultado = "1" + resultado;
                                numero = numero / 8;
                            }
                            if (numero <= 8){
                                resultado ="1" + resultado;
                                finalizacion = true;
                            }
                        } while (finalizacion != true);
                        System.out.println(resultado);
                        break;
                    case 3:
                        do {
                            if (numero % 16 == 0){
                                resultado = "0" + resultado;
                                numero = numero / 16;
                            } else {
                                resultado = "1" +resultado;
                                numero = numero / 16;
                            }
                            if (numero <= 16){
                                resultado ="1" +resultado;
                                finalizacion = true;
                            }
                        } while (finalizacion != true);
                        System.out.println(resultado);
                        break;
                    case 4:
                        System.out.println("Saliendo de la programa...");
                        finalizarBase = true;
                        break;
                }
            }
        } while(finalizarBase != true);
    }
}