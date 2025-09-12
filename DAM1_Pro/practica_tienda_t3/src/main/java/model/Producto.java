package model;

import java.io.Serializable;

public class Producto implements Serializable {

    private static final long serializable = 1L;


    private String id;
    private int precio;
    private int cantidad;

    public Producto() {
    }

    public Producto(String id, int precio, int cantidad) {
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
