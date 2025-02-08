package model;

public class Asalariado extends Trabajador{

    private double sueldo;
    private int numeroPagas;
    private boolean contratodo;

    public Asalariado() {}

    public Asalariado(String nombre, String apellido, String dni, double sueldo, int numeroPagas, boolean contratodo) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
        this.numeroPagas = numeroPagas;
        this.contratodo = contratodo;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Salario Anual: "+(sueldo * numeroPagas));
        System.out.println("Salario Mensual: "+sueldo);
        System.out.println("Numero de Pagas: "+numeroPagas);
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getNumeroPagas() {
        return numeroPagas;
    }

    public void setNumeroPagas(int numeroPagas) {
        this.numeroPagas = numeroPagas;
    }

    public boolean isContratodo() {
        return contratodo;
    }

    public void setContratodo(boolean contratodo) {
        this.contratodo = contratodo;
    }
}
