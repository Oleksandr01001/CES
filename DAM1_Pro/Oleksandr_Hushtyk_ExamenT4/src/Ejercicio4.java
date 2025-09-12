import java.util.Scanner;

public class Ejercicio4 {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        int persona = 0;
        Object[][] array1 = new Object[10][];
        do {
            System.out.println("1. Agregar persona");
            System.out.println("2. Buscar persona");
            System.out.println("3. Listar personas");
            System.out.println("4. Salir");

            System.out.print("Elige la opcion:");
            opcion = lectorTeclado.nextInt();

            switch (opcion) {
                case 1:

                    for (int i = 0; i <= persona; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (array1[i][j] == array1[0][0]) {
                                System.out.println("Intoroduce nombre:");
                                array1[i][j] = lectorTeclado.next();
                            }
                            if (array1[i][j] == array1[0][1]) {
                                System.out.println("Intoroduce apellido:");
                                array1[i][j] = lectorTeclado.next();
                            }
                            if (array1[i][j] == array1[0][3]) {
                                System.out.println("Intoroduce telefono:");
                                array1[i][j] = lectorTeclado.nextInt();
                            }
                            if (array1[i][j] == array1[0][4]) {
                                System.out.println("Intoroduce dni:");
                                array1[i][j] = lectorTeclado.next();
                            }


                        }

                    }


                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Saliendo de la aplicacion...");
                    break;


            }


        } while (opcion != 4);

    }
}
