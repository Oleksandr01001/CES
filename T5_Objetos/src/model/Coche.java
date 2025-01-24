package model;

import java.util.Random;

public class Coche {

    static Random random = new Random();

    // propiedades
    private String marca, modelo, color, matricula, bastidor;

    private double precio;

    private int cv, par, km;

    // constructores -> por defecto tengo el constructor vacio sin escribir nada
    public Coche() {
        // inicializar el objeto y por ende todos los atributos de este
        matricula = "sin definir";
        modelo = "sin definir";
        marca = "sin definir";
        bastidor = "sin definir";
        color = "sin definir";
    }

    public Coche(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }
    public Coche(String marca, String modelo, int cv) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.par = (int) Math.pow(cv*2,2);
    }

    // inicializar el coche con marca modelo color mat cv precio bastido
    // par -> calcula
    // precio -> lo que me dan +%15
    public Coche(String marca, String modelo, String color, int cv, double precio, String bastidor, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.cv = cv;
        this.par = (int) Math.pow(cv*2,2);
        this.precio = precio + (precio * 0.15);
        this.bastidor = bastidor;
        this.matricula = matricula;
    }

    public Coche(String ford, String focus) {
    }

    public Coche(String marca, String modelo, String matricula, int cv) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.cv = cv;
        this.km = 0;
    }

    // metodos
    public void mostrarDatos() {
        System.out.println("La marca es: " + this.marca);
        System.out.println("El modelo es: " + this.modelo);
        System.out.println("Los caballos son: " + this.cv);
        System.out.println("El par es: " + this.par);
        System.out.println("El color es: " + this.color);
        System.out.println("El n de bastidor es: " + this.bastidor);
        System.out.println("La matricula es: " + this.matricula);
        System.out.println("El precio es: " + this.precio);
    }


    // metodos especiales

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        Coche.random = random;
    }

    public void setKm(int km) {
        this.km = km;
    }
    public int getKm() {
        return this.km;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return this.modelo;
    }

    public String getMarca() {
        return this.marca;
    }


}
