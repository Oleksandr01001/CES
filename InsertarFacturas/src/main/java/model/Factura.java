package model;

public class Factura {
    public String numero;
    public String nombre;
    public String direccion;
    public String email;
    public String productos;
    public double precio;

    public Factura() {
    }

    public Factura(String numero, String nombre, String direccion, String email, String productos, double precio) {
        this.numero = numero;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.productos = productos;
        this.precio = precio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
