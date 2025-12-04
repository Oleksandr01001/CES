package com.example.pizzeria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pedido {
    private int id;
    private String nombre,telefono;
    private boolean servido;
    private Pizza pizza;


    public Pedido(String nombre, String telefono, Pizza pizza) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.pizza = pizza;
        this.servido = false;
    }
}
