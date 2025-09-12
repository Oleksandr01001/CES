import java.util.ArrayList;
import java.util.Scanner;

public class chatGPT {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Pedido> pedidosPendientes = new ArrayList<>();
    static double totalCaja = 0;
    static int contadorId = 1;

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1 -> realizarPedido();
                case 2 -> servirPedido();
                case 3 -> mostrarPedidosPendientes();
                case 4 -> mostrarCaja();
                case 0 -> System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("\n=== MENÚ PIZZERÍA ===");
        System.out.println("1. Realizar pedido");
        System.out.println("2. Servir pedido");
        System.out.println("3. Mostrar pedidos pendientes");
        System.out.println("4. Mostrar caja");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void realizarPedido() {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el teléfono del usuario: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese la cantidad de ingredientes (debe ser mayor a 1): ");
        int cantidadIngredientes = Integer.parseInt(scanner.nextLine());
        if (cantidadIngredientes <= 1) {
            System.out.println("La cantidad de ingredientes debe ser mayor que uno.");
            return;
        }

        ArrayList<Ingrediente> ingredientesSeleccionados = new ArrayList<>();
        for (int i = 0; i < cantidadIngredientes; i++) {
            mostrarListaIngredientes();
            System.out.print("Seleccione el número del ingrediente: ");
            int opcion = Integer.parseInt(scanner.nextLine());
            Ingrediente ingrediente = Ingrediente.obtenerIngrediente(opcion);
            if (ingrediente != null) {
                ingredientesSeleccionados.add(ingrediente);
            } else {
                System.out.println("Ingrediente no válido.");
                i--; // Para que el usuario vuelva a seleccionar
            }
        }

        double precioTotal = ingredientesSeleccionados.stream()
                .mapToDouble(Ingrediente::getPrecio)
                .sum();

        Pedido pedido = new Pedido(contadorId++, nombre, telefono, ingredientesSeleccionados, precioTotal);
        pedidosPendientes.add(pedido);

        System.out.println("Pedido realizado con éxito. ID del pedido: " + pedido.getId());
    }

    public static void mostrarListaIngredientes() {
        System.out.println("\n=== LISTA DE INGREDIENTES ===");
        for (Ingrediente ingrediente : Ingrediente.getIngredientesDisponibles()) {
            System.out.println(ingrediente.getId() + ". " + ingrediente.getNombre() + " - $" + ingrediente.getPrecio());
        }
    }

    public static void servirPedido() {
        System.out.print("Ingrese el ID del pedido que desea servir: ");
        int id = Integer.parseInt(scanner.nextLine());
        Pedido pedidoAServir = null;

        for (Pedido pedido : pedidosPendientes) {
            if (pedido.getId() == id) {
                pedidoAServir = pedido;
                break;
            }
        }

        if (pedidoAServir != null) {
            pedidosPendientes.remove(pedidoAServir);
            totalCaja += pedidoAServir.getPrecio();
            System.out.println("Pedido servido y cobrado con éxito. Total cobrado: $" + pedidoAServir.getPrecio());
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    public static void mostrarPedidosPendientes() {
        if (pedidosPendientes.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
            return;
        }

        System.out.println("\n=== PEDIDOS PENDIENTES ===");
        for (Pedido pedido : pedidosPendientes) {
            System.out.println(pedido);
        }
    }

    public static void mostrarCaja() {
        System.out.println("Total recaudado hasta ahora: $" + totalCaja);
    }
}

class Pedido {
    private int id;
    private String nombreUsuario;
    private String telefonoUsuario;
    private ArrayList<Ingrediente> ingredientes;
    private double precio;

    public Pedido(int id, String nombreUsuario, String telefonoUsuario, ArrayList<Ingrediente> ingredientes, double precio) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.ingredientes = ingredientes;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        StringBuilder detallesIngredientes = new StringBuilder();
        for (Ingrediente ingrediente : ingredientes) {
            detallesIngredientes.append(ingrediente.getNombre()).append(", ");
        }
        return "ID: " + id +
                " | Usuario: " + nombreUsuario +
                " | Teléfono: " + telefonoUsuario +
                " | Ingredientes: " + detallesIngredientes +
                "Precio: $" + precio;
    }
}

class Ingrediente {
    private int id;
    private String nombre;
    private double precio;

    private static ArrayList<Ingrediente> ingredientesDisponibles = new ArrayList<>();

    static {
        ingredientesDisponibles.add(new Ingrediente(1, "Queso", 1.5));
        ingredientesDisponibles.add(new Ingrediente(2, "Pepperoni", 2.0));
        ingredientesDisponibles.add(new Ingrediente(3, "Jamón", 2.5));
        ingredientesDisponibles.add(new Ingrediente(4, "Champiñones", 1.8));
        ingredientesDisponibles.add(new Ingrediente(5, "Aceitunas", 1.2));
    }

    public Ingrediente(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public static ArrayList<Ingrediente> getIngredientesDisponibles() {
        return ingredientesDisponibles;
    }

    public static Ingrediente obtenerIngrediente(int id) {
        for (Ingrediente ingrediente : ingredientesDisponibles) {
            if (ingrediente.getId() == id) {
                return ingrediente;
            }
        }
        return null;
    }
}

