//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

public class Pasajero {
    private int id;
    private String nombre;
    private int edad;
    private int peso;
    private int id_coche;

    public Pasajero(int id, String nombre, int edad, int peso, int id_coche) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.id_coche = id_coche;
    }

    public Pasajero() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getId_coche() {
        return this.id_coche;
    }

    public void setId_coche(int id_coche) {
        this.id_coche = id_coche;
    }
}
