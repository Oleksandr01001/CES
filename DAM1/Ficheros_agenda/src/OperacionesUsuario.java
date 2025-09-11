import model.Usuario;

import java.io.*;
import java.util.Scanner;

public class OperacionesUsuario {


    public void escribirUsuario(Usuario usuario, String path) {

        Scanner scanner = new Scanner(System.in);

        File file = new File(path);
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter(file, true);
            printWriter = new PrintWriter(fileWriter);

            printWriter.println(usuario.toString());

        } catch (IOException e) {
            System.out.println("Error i/o");
        } finally {
            try{
                printWriter.close();
            } catch (Exception e){
                System.out.println("Error en el cerrado");
            }
        }


    }

    public void lecturaUsuarios(String path) {
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);


        } catch (FileNotFoundException e) {
            System.out.println("Error");
        } finally {
            try {
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println("Error");
            }
        }


    }


    public void escribirUsuarioObjeto(String path, Usuario usuario) throws IOException {
        File file = new File(path);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

        } catch (FileNotFoundException e) {
            System.out.println("Error en el fichero");


        } catch (IOException e) {
            System.out.println("Error en i/o");


        } finally {
            try {

                objectOutputStream.close();

            } catch (IOException | NullPointerException e) {
                System.out.println("Error en i/o");

            }
        }
    }

    public void leerUsuarioObjeto(String path) {
        File file = new File(path);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Usuario usuario = (Usuario) objectInputStream.readObject();


        } catch (FileNotFoundException e) {
            System.out.println("Error en i/o");
        } catch (IOException e) {
            System.out.println("Error");
        } catch (ClassNotFoundException e) {
            System.out.println("Error");
        }
    }
}
