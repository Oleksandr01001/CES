package controller;

import model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    private List<Usuario> usuarios = new ArrayList<>();
    private final String archivo = "src/recursos/usuarios.obj";


    public void importarDatos() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(archivo));
            usuarios = (List<Usuario>) objectInputStream.readObject();
            System.out.println("Datos importados correctamente");
        } catch (IOException e) {
            System.out.println("Se ha producido un error...");
        } catch (ClassNotFoundException e) {
            System.out.println("Erron en importar datos...");
        }
    }

    public void agregarUsuario(Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        Usuario u = new Usuario(nombre, apellido, correo, telefono);
        usuarios.add(u);
        System.out.println("Usuario agregado");
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    public void buscarUsuario(Scanner sc) {
        System.out.print("Buscar por nombre o apellido: ");
        String texto = sc.nextLine().toLowerCase();

        boolean encontrado = false;
        for (Usuario u : usuarios) {
            if (u.getNombre().toLowerCase().contains(texto) || u.getApellido().toLowerCase().contains(texto)) {
                System.out.println(u);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún usuario con ese nombre o apellido.");
        }
    }

    public void eliminarUsuario(Scanner sc) {
        System.out.print("Introduzca el correo del usuario a eliminar: ");
        String correo = sc.nextLine();

        Usuario usuarioAEliminar = null;

        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                usuarioAEliminar = u;
                break;
            }
        }

        if (usuarioAEliminar != null) {
            usuarios.remove(usuarioAEliminar);
            System.out.println("Usuario eliminado.");
        } else {
            System.out.println("No se encontró ningún usuario con ese correo.");
        }
    }

    public void exportarDatos() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(archivo));
            objectOutputStream.writeObject(usuarios);
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Se ha producido un error");
        }
    }



}
