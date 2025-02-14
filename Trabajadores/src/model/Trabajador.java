package model;

abstract public class Trabajador {

    private String nombre, apellido;
    private int numeroSS;
    private double salario;

    public Trabajador() {
    }

    public Trabajador(double salario, int numeroSS, String apellido, String nombre) {
        this.salario = salario;
        this.numeroSS = numeroSS;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("Salario: "+salario);
        System.out.println("Numero SS: "+numeroSS);
    }
    public abstract void calcularSalarioMes();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(int numeroSS) {
        this.numeroSS = numeroSS;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
