package model;

abstract public class Vehiculo {

    private String numSerie, marca, modelo, estado;
    private int precio;

    public Vehiculo() {}

    public Vehiculo(String numSerie, String marca, String modelo, String estado, int precio) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        this.precio = precio;
    }

    public void mostrarDatos() {
        System.out.println("Numero serie: "+numSerie);
        System.out.println("Marca: "+marca);
        System.out.println("Modelo: "+modelo);
        System.out.println("Estado: "+estado);
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
