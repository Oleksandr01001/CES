package model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private final static long serialVersionUID = 123456789L;

    String nombre, apellido, correo;
    int telefono;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + ", " + apellido + ", " + correo + ", " + telefono;
    }

    public void mostarrDatos() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido = " + apellido);
        System.out.println("Correo = " + correo);
        System.out.println("Telefono = " + telefono);
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
