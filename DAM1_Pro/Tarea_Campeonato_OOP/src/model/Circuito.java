package model;

public class Circuito {

    private String nombre;
    private int vueltas;

    public Circuito() {}

    public Circuito(String nombre, int vueltas) {
        this.nombre = nombre;
        this.vueltas = vueltas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }
}
