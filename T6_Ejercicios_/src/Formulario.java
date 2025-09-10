import java.util.Scanner;

public class Formulario {
    private String nombre;
    private String apellidos;
    private String dni;

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Formulario ---");
            System.out.println("1. Rellenar nombre");
            System.out.println("2. Rellenar apellidos");
            System.out.println("3. Rellenar DNI");
            System.out.println("4. Finalizar");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese su nombre: ");
                    nombre = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Ingrese sus apellidos: ");
                    apellidos = scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Ingrese su DNI: ");
                    String inputDNI = scanner.nextLine();
                    try {
                        validarDNI(inputDNI);
                        dni = inputDNI;
                    } catch (LongitudDNINoValidaException | UltimoDigitoNoLetraException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    if (nombre == null || apellidos == null || dni == null) {
                        System.out.println("Error: Debe completar todos los datos antes de salir.");
                        opcion = 0; // Evita salir del bucle
                    } else {
                        System.out.println("\nFormulario completado con éxito:");
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Apellidos: " + apellidos);
                        System.out.println("DNI: " + dni);
                    }
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private void validarDNI(String dni) throws LongitudDNINoValidaException, UltimoDigitoNoLetraException {
        if (dni.length() != 9) {
            throw new LongitudDNINoValidaException("El DNI debe tener exactamente 9 caracteres.");
        }
        char ultimoCaracter = dni.charAt(8);
        if (!Character.isLetter(ultimoCaracter)) {
            throw new UltimoDigitoNoLetraException("El último carácter del DNI debe ser una letra.");
        }
    }
}
