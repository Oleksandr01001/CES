import controller.Agenda;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner sc = new Scanner(System.in);
        int opcion;

        agenda.importarDatos();

        do {
            System.out.println("\n---- AGENDA ----");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Buscar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Exportar datos y salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> agenda.agregarUsuario(sc);
                case 2 -> agenda.listarUsuarios();
                case 3 -> agenda.buscarUsuario(sc);
                case 4 -> agenda.eliminarUsuario(sc);
                case 5 -> {
                    agenda.exportarDatos();
                    System.out.println("¡Hasta luego!");
                }
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
