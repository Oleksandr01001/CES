package com.example.examen_2.model;

public class Producto {
    private String nombre, categoria;
    private Double precio;

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
