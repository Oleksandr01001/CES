import java.util.Scanner;
public class Entrada {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        System.out.println("Bienvenido a la app de gestion de coches");
        /*garaje.anadirCoche("Mercedes","c220",200,"1234A");
        garaje.anadirCoche("Ford","fiesta",150,"1234b");
        garaje.anadirCoche("Ford","fiesta",150,"1234b");
        garaje.anadirCoche("Ford","fiesta",150,"1234c");
        garaje.anadirCoche("Ford","fiesta",150,"1234d");
        garaje.anadirCoche("Ford","fiesta",150,"1234e");
        garaje.anadirCoche("Ford","fiesta",150,"1234f");*/


        int opcion = 0;


        do {

            System.out.println("1.Añadir coche");
            System.out.println("2.Listar coches");
            System.out.println("3.Buscar coche");
            System.out.println("4.Mostrar coste");
            System.out.println("5.Eliminar coche");
            System.out.println("6.Vaciar garaje");
            System.out.println("7.Salir de la aplicacion");

            System.out.print("Elige la opcion:");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce la marca:");
                    String marca = scanner.next();
                    System.out.print("Introduce modelo:");
                    String modelo = scanner.next();
                    System.out.print("Introduce coste:");
                    int coste = scanner.nextInt();
                    System.out.print("Introduce la matricula:");
                    String matricula = scanner.next();
                    garaje.anadirCoche(marca,modelo,coste,matricula);
                    break;
                case 2:
                    garaje.mostrarCoches();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;

            }

        } while (opcion != 7);


    }



}
