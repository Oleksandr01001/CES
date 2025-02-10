package model;

public class Llamadas {

    private int nOrigen, nDestino, duracion;
    private double coste;

    public Llamadas() {}

    public Llamadas(int nOrigen, int nDestino, int duracion) {
        this.nOrigen = nOrigen;
        this.nDestino = nDestino;
        this.duracion = duracion;
    }

    public void mostrarDatos() {
        System.out.println("Origen: " + nOrigen + " Destino: " + nDestino + " Duracion: " + duracion + " Coste: " + coste);
    }

    public int getnOrigen() {
        return nOrigen;
    }

    public void setnOrigen(int nOrigen) {
        this.nOrigen = nOrigen;
    }

    public int getnDestino() {
        return nDestino;
    }

    public void setnDestino(int nDestino) {
        this.nDestino = nDestino;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }
}
