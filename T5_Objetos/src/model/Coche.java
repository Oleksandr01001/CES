package model;

public class Coche {

    // propiedades
    private String marca, modelo, color, matricula, bastidor;

    private double precio;

    private int cv, par;

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
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }


}
