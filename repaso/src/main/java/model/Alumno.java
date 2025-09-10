package model;


import lombok.Data;

@Data

public class Alumno {

    private static long serialVercion = 1L;
    private String nombre, apellido, correo;



    public String mostrarDatos() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
