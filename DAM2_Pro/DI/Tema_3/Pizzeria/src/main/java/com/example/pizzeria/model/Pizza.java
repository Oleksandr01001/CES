package com.example.pizzeria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pizza {
    private String nombre,tamanio;
    private double precio;



    @Override
    public String toString() {
        return nombre;
    }


}
