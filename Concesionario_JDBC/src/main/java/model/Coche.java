//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

import java.io.Serializable;

public class Coche implements Serializable {
    private static final long serializable = 1L;
    private int id;
    private String marca;
    private String color;
    private String modelo;
    private String matricula;
    private int precio;
    private int idPasajero;

    public Coche() {
    }

    public Coche(int id, String marca, String color, String modelo, String matricula, int precio, int id_pasajero) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.matricula = matricula;
        this.precio = precio;
        this.idPasajero = id_pasajero;
    }

    public int getIdPasajero() {
        return this.idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String toString() {
        return String.format("ID=%d, Marca=%s, Modelo=%s, Color=%s, Matrícula=%s, Precio=%d, ID_Pasajero=%d", this.id, this.marca, this.modelo, this.color, this.matricula, this.precio, this.idPasajero);
    }
}
