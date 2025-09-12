package model;

import java.io.Serializable;

public class Coche implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String marca;
    private String color;
    private String modelo;
    private String matricula;
    private int precio;

    public Coche() {}

    public Coche(int id, String marca, String color, String modelo, String matricula, int precio) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.matricula = matricula;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("ID=%d, Marca=%s, Modelo=%s, Color=%s, Matrícula=%s, Precio=%d",
                id, marca, modelo, color, matricula, precio);
    }
}
