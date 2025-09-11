package model;

public class Productos {
    private int id;
    private String nombreProducto;
    private int precio;
    private int cantidadStock;


    public Productos(int id, String nombreProducto, int precio, int cantidadStock) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    public Productos() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
}
