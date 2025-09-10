package model;

import java.util.ArrayList;

public class Inventario<T> {

    private ArrayList<T> listaProductos = new ArrayList<>();

    public Inventario() {
    }

    public void agregar(T elemento) {
        listaProductos.add(elemento);
    }

    public void mostrarInventario() {
        for (T item : listaProductos) {
            System.out.println(item);
        }
    }


    public class Producto {

        String nombre;
        double precio;
        int stock;

        public Producto() {
        }

        public Producto(String nombre, double precio, int stock) {
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        @Override
        public String toString() {
            return "Producto{" +
                    "nombre='" + nombre + '\'' +
                    ", precio=" + precio +
                    ", stock=" + stock +
                    '}';
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }
    }

}
