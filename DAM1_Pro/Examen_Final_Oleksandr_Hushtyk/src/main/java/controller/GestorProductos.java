package controller;

import model.Producto;
import model.ProductoDTO;

import java.util.Scanner;

public class GestorProductos {
    static Scanner scanner = new Scanner(System.in);
    ProductoDTO productoDTO = new ProductoDTO();

    private int opcion = 0;

    public void menu() {



        do {
            System.out.println("Elige la opcion: ");
            System.out.println("1.Crear un nuevo producto e insértalo en la tabla");
            System.out.println("2.Leer información de un producto dado su ID");
            System.out.println("3.Actualizar la información de un producto dado su ID.");
            System.out.println("4.Eliminar un producto dado su ID.");
            System.out.println("5.Muestra todos los productos de la tabla");
            System.out.println("0.Salir de la aplicacion");

            opcion = scanner.nextInt();


            switch (opcion) {

                case 1:
                    System.out.println("Introduce id de producto: ");
                    int id = scanner.nextInt();
                    System.out.println("Introduce nombre: ");
                    String nombre = scanner.next();
                    System.out.println("Introduce precio: ");
                    double precio = scanner.nextDouble();
                    System.out.println("Introduce cantidad: ");
                    int cantidad = scanner.nextInt();

                    productoDTO.crear(new Producto(id,nombre,precio,cantidad));

                case 2:
                    System.out.println("Introduce el id de producto: ");
                    int id1 = scanner.nextInt();
                    productoDTO.leer(id1);

                case 3:
                    System.out.println("Introduce id de producto: ");
                    int id2 = scanner.nextInt();
                    System.out.println("Introduce nombre: ");
                    String nombre2 = scanner.next();
                    System.out.println("Introduce precio: ");
                    double precio2 = scanner.nextDouble();
                    System.out.println("Introduce cantidad: ");
                    int cantidad2 = scanner.nextInt();

                    productoDTO.actualizar(new Producto(id2,nombre2,precio2,cantidad2));


                case 4:
                    System.out.println("Introduce el id de producto: ");
                    int id3 = scanner.nextInt();
                    productoDTO.eliminar(id3);

                case 5:

                case 0:
                    System.out.println("Saliendo de la aplicacion");

            }

        } while (opcion != 0);


    }
}
