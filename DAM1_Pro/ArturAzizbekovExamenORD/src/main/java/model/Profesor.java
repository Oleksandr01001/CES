package model;

public abstract class Profesor {
    private String nombre;
    private String dni;
    private int salarioAnual;

    public Profesor(String nombre, String dni, int salarioAnual) {
        this.nombre = nombre;
        this.dni = dni;
        this.salarioAnual = salarioAnual;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getSalarioAnual() {
        return salarioAnual;
    }

    public void setSalarioAnual(int salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    public abstract double calcularSalarioTotal();
}
