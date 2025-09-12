
import controller.Concesionario;
import model.Coche;
import model.Pasajero;
import model.PasajeroDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    private static final String FICHERO_DAT = "coches.dat";
    private static final String FICHERO_CSV = "coches.csv";

    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario();


        File file = new File(FICHERO_DAT);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                ArrayList<Coche> coches = (ArrayList<Coche>) ois.readObject();
                concesionario.setCoches(coches);
                System.out.println("Coches cargados desde " + FICHERO_DAT);
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
            System.out.println("6. Terminar programa");
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


                    Coche nuevoCoche = new Coche(id, matricula, marca, modelo, color, precio);
                    concesionario.agregarCoche(nuevoCoche);
                    break;

                case "2":
                    System.out.print("Introduce el ID del coche a borrar: ");
                    int idBorrar = Integer.parseInt(scanner.nextLine());
                    concesionario.borrarCoche(idBorrar);
                    break;

                case "3":
                    System.out.print("Introduce el ID del coche a consultar: ");
                    int idConsulta = Integer.parseInt(scanner.nextLine());
                    concesionario.consultarCoche(idConsulta);
                    break;

                case "4":
                    concesionario.listaCoches();
                    break;

                case "5":
                    concesionario.exportarCochesCSV();
                    break;

                case "6":
                    boolean salirSubMenu = false;
                    while (!salirSubMenu){
                        System.out.println("\n--- Sub Menú ---");
                        System.out.println("1. Añadir nuevo pasajero");
                        System.out.println("2. Borrar pasajero por ID");
                        System.out.println("3. Consultar pasajero por ID");
                        System.out.println("4. Listado de pasajeros");
                        System.out.println("5. Añadir pasajero a coche");
                        System.out.println("6. Eliminar pasajero de un coche");
                        System.out.println("7. Listar pasajeros de un coche");
                        System.out.println("8. Terminar programa");
                        System.out.print("Elige una opción: ");
                    }

                    String opcionSub = scanner.next();

                    switch (opcionSub){
                        case "1":
                            System.out.println("Introduce ID de pasajero");
                            int idPasajero = scanner.nextInt();
                            System.out.println("Escribe nombre de pasajero");
                            String nombre = scanner.next();
                            System.out.println("Escribe edad de pasajero");
                            int edad  = scanner.nextInt();
                            System.out.println("Escribe peso de pasajero");
                            int peso  = scanner.nextInt();

                            Pasajero pasajero = new Pasajero(idPasajero,nombre,edad,peso);

                            concesionario.agregarPasajero(pasajero);

                            break;
                        case "2":
                            System.out.println("introduce ID de pasajero que quieres borrar");
                            int idPasajeroEliminar = scanner.nextInt();
                            concesionario.borrarPasajero(idPasajeroEliminar);
                            break;
                        case "3":
                            System.out.println("introduce ID de pasajero que quieres consultar");
                            int idPasajeroConsultar = scanner.nextInt();
                            concesionario.consultarPasajero(idPasajeroConsultar);
                            break;
                        case "4":
                            System.out.println("Aqui tienes la lista:");
                            concesionario.listaPasajeros();
                            break;
                        case "5":
                            concesionario.asignarPasajeroACoche();
                            break;
                        case "6":
                            concesionario.eliminarPasajeroDeCoche();
                            break;
                        case "7":
                            concesionario.mostrarPasajerosDeCoche();
                            break;
                        case "8":

                            salirSubMenu = true;
                            break;
                        default:
                            System.out.println("Opcion no valida");

                    }


                    break;

                case "7":
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO_DAT))) {
                        oos.writeObject(concesionario.getCoches());
                        System.out.println("Datos guardados en " + FICHERO_DAT);
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
