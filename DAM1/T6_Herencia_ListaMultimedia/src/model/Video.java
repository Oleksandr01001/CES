package model;

import java.util.ArrayList;

public class Video extends Elemento{

    private Persona director;
    private ArrayList<Persona> actores;

    public Video() {}

    public Video(String id, String titulo, String formato, Persona autor, int tamano, Persona director) {
        super(id, titulo, formato, autor, tamano);
        this.director = director;
        this.actores = new ArrayList<>();
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Director: "+director);
        for (Persona item : actores) {
            System.out.println("Actor: "+item);
        }
    }

    public Persona getDirector() {
        return director;
    }

    public void setDirector(Persona director) {
        this.director = director;
    }

    public ArrayList<Persona> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Persona> actores) {
        this.actores = actores;
    }
}
