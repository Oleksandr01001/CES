package model;

import java.io.*;
import java.util.ArrayList;
import java.util.SortedMap;

public class Ejercicio3 implements Serializable{

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    //El serial version uid para poder leer los
    // objetos que están guardados en el fichero es de 987L.
    // Ademas, los objetos tendran una estructura de nombre, apellido,
    // telefono y edad (definida la clase dentro de un paquete llamado model)

    public void ejercicio3() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/recursos/ejercicio3.obj"))) {
            while (true) {
                try {
                    Usuario usuario = (Usuario) ois.readObject();
                    System.out.println(usuario);
                } catch (Exception e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void ejercicio4() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("src/recursos/ejercicio3.obj"));
            usuarios = (ArrayList<Usuario>) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.print(usuario.mostrarDatos());
        }
    }

}
