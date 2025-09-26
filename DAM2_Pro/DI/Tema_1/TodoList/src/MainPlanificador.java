import java.util.Scanner;

public class MainPlanificador {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("Elige la opcion: ");
            System.out.println("1.Registrar una tarea");
            System.out.println("2.Modificar tarea");
            System.out.println("3.Listar tareas");
            System.out.println("4.Completar tarea");
            System.out.println("5.Listar completas");
            System.out.println("6.Liistar incompletas");
            System.out.println("0.Salir de la aplicacion...");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 0:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
            }
        } while (opcion != 0);
    }
}
