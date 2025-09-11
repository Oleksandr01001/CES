import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Entrada {

    public static void main(String[] args) {

        File ficheroAlumnos = new File("C:\\Users\\oleks\\Documents\\GitHub\\Oleksandr_Hushtyk_PRO\\repaso\\src\\main\\java\\resources\\alumno.txt");


        FileWriter fileWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter(ficheroAlumnos);
            printWriter = new PrintWriter(new FileWriter(ficheroAlumnos));
            printWriter.print("Hola que tal");

        } catch (IOException e) {
            System.out.println("Error el encontrar el fichero");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("No se puede cerrar");
            }
        }
    }
}
