package model;

public class Jugador {

    private String nombre, posicion;
    private boolean estrella;
    private int calidad;

    public Jugador() {}

    public Jugador(String nombre, int calidad, String posicion) {
        this.nombre = nombre;
        this.calidad = calidad;
        this.posicion = posicion;

        this.estrella = calidad > 90;

        /*
        if (calidad > 90) {
            this.estrella = true;
        } else {
            this.estrella = false;
        }
         */

        // this.estrella = calidad>90 ? true:false;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Calidad: "+calidad);
        System.out.println("Posicion: "+posicion);
        System.out.println("Estrella: "+estrella);
        System.out.println();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public boolean isEstrella() {
        return estrella;
    }

    public void setEstrella(boolean estrella) {
        this.estrella = estrella;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }
}
