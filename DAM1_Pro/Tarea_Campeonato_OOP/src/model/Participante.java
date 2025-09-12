package model;

public class Participante {

    private Coche coche;
    private int puntos;


    public Participante() {}

    public Participante(Coche coche) {
        this.coche = coche;
        this.puntos = 0;
    }

    public void agregarPuntos(int punt) {
        puntos += punt;
    }


    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
