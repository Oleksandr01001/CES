package controller;

import model.Productos;
import model.ProductosDTO;
import model.Trabajadores;
import model.TrabajadoresDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class Secretaria {
    private ArrayList<Trabajadores> listaTrabajadores;
    private ArrayList<Productos> listaProductos;
    private final Scanner scanner = new Scanner(System.in);
    private final TrabajadoresDTO trabajadoresDTO = new TrabajadoresDTO();
    private final ProductosDTO productosDTO = new ProductosDTO();


    public Secretaria(){
        listaTrabajadores = new ArrayList<>();
        listaProductos = new ArrayList<>();
    }

    public void crearUsuarios(Trabajadores trabajadores){
        for (int i = 0; i < 4; i++) {
            System.out.println("Introduce el nombre de usuario:");
            String nombre = scanner.nextLine();

            if (!trabajadoresDTO.getUsuario(nombre)) {
                System.out.println("Introduce el ID:");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Introduce el cargo:");
                String cargo = scanner.nextLine();

                System.out.println("Introduce el salario:");
                int salario = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Introduce el correo:");
                String correo = scanner.nextLine();

                System.out.println("Introduce la contraseña:");
                String password = scanner.nextLine();

                Trabajadores t = new Trabajadores(id, nombre, cargo, salario, correo, password);
                listaTrabajadores.add(t);
                trabajadoresDTO.insertarUsuarios(t);
                System.out.println("Usuario agregado.");
            } else {
                System.out.println("El usuario ya existe.");
            }
        }
    }
    public void simularLogin(String usuario, String password){

        if (trabajadoresDTO.getUsuario(usuario)){
            System.out.println("Login correcto");
        } else {
            System.out.println("usuario no encontrado");
        }
    }

    public void insertarProductos(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce el ID del producto:");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Introduce el nombre del producto:");
            String nombre = scanner.nextLine();

            System.out.println("Introduce el precio:");
            int precio = scanner.nextInt();

            System.out.println("Introduce la cantidad:");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            Productos p = new Productos(id, nombre, precio, cantidad);
            listaProductos.add(p);
            productosDTO.insertarProducto(p);
        }
    }
    public void actualizarProductos(Productos productos){
        System.out.println("Introduce el nombre del producto a actualizar:");
        String nombre = scanner.nextLine();

        if (productosDTO.getNombreProducto(nombre)) {
            System.out.println("Introduce el nuevo precio:");
            int nuevoPrecio = scanner.nextInt();
            scanner.nextLine();

            productosDTO.actualizarPrecio(nombre, nuevoPrecio);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    public void eliminarProductoPorID(){
        System.out.println("Intrroduce el id de producto");
        int id = scanner.nextInt();
        productosDTO.eliminarProducto(id);
    }
    public void mostrarProductos10(){
        int cantidad = 10;
        productosDTO.mostrarStock(10);
    }



}
