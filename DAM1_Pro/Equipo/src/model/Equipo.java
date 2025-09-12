package model;

import java.util.ArrayList;

public class Equipo {

    private ArrayList<Jugador> plantilla;
    private String nombre;
    private int nivelAtaque, nivelMedio, nivelDefensa;
    private int goles;

    public Equipo() {}

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.nivelAtaque = (int) (Math.random()*101);
        this.nivelMedio = (int) (Math.random()*101);
        this.nivelDefensa = (int) (Math.random()*101);
    }

    public Equipo(String nombre, int ataque, int defensa, int medio) {
        this.nombre = nombre;
        this.nivelAtaque = ataque;
        this.nivelDefensa = defensa;
        this.nivelMedio = medio;
        this.plantilla = new ArrayList<>();
    }

    public boolean atacar() {
        double resultado = (nivelAtaque * Math.random()*1) + ((nivelMedio * Math.random()*1) /2);
        if (resultado > 90) {
            goles++;
            return true;
        }
        return false;
    }

    public void ficharJugador(Jugador jugador) {
        this.plantilla.add(jugador);
    }

    public void mostrarDatos() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Ataque: "+nivelAtaque);
        System.out.println("Medio: "+nivelMedio);
        System.out.println("Defensa: "+nivelDefensa);
    }

    public void listarDelanteros() {
        for (Jugador item : plantilla) {
            if (item.getPosicion().equalsIgnoreCase("delantero")) {
                item.mostrarDatos();
            }
        }
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    public int getNivelMedio() {
        return nivelMedio;
    }

    public void setNivelMedio(int nivelMedio) {
        this.nivelMedio = nivelMedio;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    /*
    @Override
    public String toString() {
        return nombre;
    }
     */
}
