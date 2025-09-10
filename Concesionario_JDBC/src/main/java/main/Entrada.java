package main;

import controller.Concesionario;
import model.Coche;
import model.Pasajero;
import model.PasajeroDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    private static final String FICHERO_DAT = "coches.dat";

    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario();
        PasajeroDTO pasajeroDTO = new PasajeroDTO();

        // Cargar coches desde fichero
        File file = new File(FICHERO_DAT);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                ArrayList<Coche> coches = (ArrayList<Coche>) ois.readObject();
                concesionario.setCoches(coches);
                System.out.println("Coches cargados desde coches.dat");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al leer el fichero de coches: " + e.getMessage());
            }
        } else {
            System.out.println("No existe el fichero coches.dat, iniciando lista vacía.");
        }

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir nuevo coche");
            System.out.println("2. Borrar coche por ID");
            System.out.println("3. Consultar coche por ID");
            System.out.println("4. Listado de coches");
            System.out.println("5. Exportar coches a CSV");
            System.out.println("6. Añadir nuevo pasajero");
            System.out.println("7. Borrar pasajero por ID");
            System.out.println("8. Consultar pasajero por ID");
            System.out.println("9. Listar todos los pasajeros");
            System.out.println("10. Asignar pasajero a coche");
            System.out.println("11. Eliminar pasajero de un coche");
            System.out.println("12. Listar pasajeros de un coche");
            System.out.println("13. Terminar programa");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    System.out.print("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Color: ");
                    String color = scanner.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Precio: ");
                    int precio = Integer.parseInt(scanner.nextLine());
                    Coche nuevoCoche = new Coche(id, marca, color, modelo, matricula, precio, 0);
                    concesionario.agregarCoche(nuevoCoche);
                    break;

                case "2":
                    System.out.print("ID del coche a borrar: ");
                    int idCocheBorrar = Integer.parseInt(scanner.nextLine());
                    concesionario.borrarCoche(idCocheBorrar);
                    break;

                case "3":
                    System.out.print("ID del coche a consultar: ");
                    int idCocheConsulta = Integer.parseInt(scanner.nextLine());
                    concesionario.consultarCoche(idCocheConsulta);
                    break;

                case "4":
                    concesionario.listaCoches();
                    break;

                case "5":
                    concesionario.exportarCochesCSV();
                    break;

                case "6":
                    System.out.print("Nombre del pasajero: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = Integer.parseInt(scanner.nextLine());
                    System.out.print("Peso: ");
                    int peso = Integer.parseInt(scanner.nextLine());
                    pasajeroDTO.insertarPasajero(new Pasajero(0, nombre, edad, peso, 0));
                    break;

                case "7":
                    System.out.print("ID del pasajero a borrar: ");
                    int idPasajeroBorrar = Integer.parseInt(scanner.nextLine());
                    pasajeroDTO.eliminarPasajero(idPasajeroBorrar);
                    break;

                case "8":
                    System.out.print("ID del pasajero a consultar: ");
                    int idPasajeroConsulta = Integer.parseInt(scanner.nextLine());
                    pasajeroDTO.consultarPasajero(idPasajeroConsulta);
                    break;

                case "9":
                    pasajeroDTO.listarPasajeros();
                    break;

                case "10":
                    System.out.print("ID del pasajero: ");
                    int idPasajeroAsignar = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID del coche: ");
                    int idCocheAsignar = Integer.parseInt(scanner.nextLine());
                    pasajeroDTO.asignarPasajeroACoche(idPasajeroAsignar, idCocheAsignar);
                    break;

                case "11":
                    System.out.print("ID del pasajero a eliminar de un coche: ");
                    int idPasajeroEliminar = Integer.parseInt(scanner.nextLine());
                    pasajeroDTO.eliminarPasajeroDeCoche(idPasajeroEliminar);
                    break;

                case "12":
                    System.out.print("ID del coche para ver sus pasajeros: ");
                    int idCocheVer = Integer.parseInt(scanner.nextLine());
                    pasajeroDTO.listarPasajerosDeCoche(idCocheVer);
                    break;

                case "13":
                    // Guardar coches en fichero
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO_DAT))) {
                        oos.writeObject(concesionario.getCoches());
                        System.out.println("Datos guardados en coches.dat");
                    } catch (IOException e) {
                        System.err.println("Error al guardar datos: " + e.getMessage());
                    }
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
