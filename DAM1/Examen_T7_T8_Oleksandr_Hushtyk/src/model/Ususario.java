package model;

import java.io.Serializable;

class Usuario implements Serializable {

    private static final long serialVersionUID = -5673816542793472397L;

    private String nombre, apellido, dni;
    private int edad;


    public Usuario(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public int getEdad() {
        return edad;
    }

    public void setTelefono(int telefono) {
        this.edad = telefono;
    }

    public String mostrarDatos(){
        return String.format("nombre: %s, apellidos: %s, teléfono: %d %n", getNombre(), getApellido(), getEdad());
    }
}
