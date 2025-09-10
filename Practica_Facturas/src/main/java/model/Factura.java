package model;

public class Factura {

    private String numeroFactura, nombre, direccion, email, productos;
    private double precio;

    public Factura() {
    }

    public Factura(String numeroFactura, String nombre, String direccion, String email, String productos, double precio) {
        this.numeroFactura = numeroFactura;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.productos = productos;
        this.precio = precio;
    }


    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
