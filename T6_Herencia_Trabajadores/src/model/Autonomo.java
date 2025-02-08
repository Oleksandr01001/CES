package model;

public class Autonomo extends Trabajador{

    private double sueldo;
    private boolean contratodo;

    public Autonomo() {}

    public Autonomo(String nombre, String apellido, String dni, double sueldo, boolean contratodo) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
        this.contratodo = contratodo;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Salario Anual: "+(sueldo*12));
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isContratodo() {
        return contratodo;
    }

    public void setContratodo(boolean contratodo) {
        this.contratodo = contratodo;
    }
}
