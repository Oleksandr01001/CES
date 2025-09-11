import java.io.*;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       /* try {
            FileWriter fileWriter = new FileWriter("src\\recursos\\ejemplo.txt");
            fileWriter.write("hola lkjhgfdsa");
            fileWriter.write(" ");
            fileWriter.write("asdfghj");
            fileWriter.close();

        } catch (Exception e) {
            System.out.println("Se ha producedo un error");
        } finally {
            System.out.println("...");
        }
        */

        /*System.out.println("Cuantas veces quieres ejecutar la programa?");
        int veces = scanner.nextInt();
        int v = 1;


        do {
            try {
                Scanner scanner1 = new Scanner(System.in);
                PrintWriter printWriter = new PrintWriter(new FileWriter("src\\recursos\\ejemplo.txt", true));
                System.out.println("Escribe el texto: ");
                String texto = scanner1.nextLine();
                printWriter.println(texto);

                printWriter.close();
                v++;
            } catch (FileNotFoundException e) {
                System.out.println("Se ha producido un error");
            } catch (IOException e) {
                System.out.println("Se ha producido error");
            } finally {
                System.out.println("Terminado...");
            }
        } while (v <= veces);

         */



        /*try {
           // FileReader fileReader = new FileReader("src\\recursos\\ejemplo.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\recursos\\ejemplo.txt"));
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }


        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Uuu...");
        }

         */

    }

}
