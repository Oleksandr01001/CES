package model;

public class Coche {

    private String nombre;
    private int victorias;

    public Coche(){}

    public Coche(String nombre) {
        this.nombre = nombre;
        this.victorias = 0;
    }

    public void incrementarVictoria() {
        victorias++;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }
}
