import controller.CentroFormacion;

import java.io.IOException;
import java.util.Scanner;

public class Entrada {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion = 0;
        CentroFormacion centroFormacion = new CentroFormacion();
        while (opcion!=7){
            System.out.println("Menu:");
            System.out.println("1.Mostrar profesores base datos:");
            System.out.println("2.Incorporar profesor temporal:");
            System.out.println("3.Dar de baja profesor temporal:");
            System.out.println("4.Exportar datos a base de datos:");
            System.out.println("5.Exportar datos a csv:");
            System.out.println("6.Exportar datos a fichero obj:");
            System.out.println("7.Salir");

            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    centroFormacion.mostrarProfesores();
                    break;
                case 2:
                    centroFormacion.incorporarProfesoresLocal();
                    break;
                case 3:
                    centroFormacion.eliminarProfesor();
                    break;
                case 4:
                    centroFormacion.insertarProfesor();
                    break;
                case 5:
                    centroFormacion.exportarCSV();
                    break;
                case 6:
                    try {
                        centroFormacion.exportarObj();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 7:
                    System.out.println("saliendo...");
                    break;
            }
        }


    }
}
