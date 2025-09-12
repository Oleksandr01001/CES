package model;

public class Jefe extends Trabajador implements Empleador{

    @Override
    public void calcularSalarioMes() {
        System.out.println("El salario mensual es: " +getSalario());
    }

    public Jefe() {
    }

    public Jefe(double salario, int numeroSS, String apellido, String nombre) {
        super(salario, numeroSS, apellido, nombre);
    }


    @Override
    public void realizarTrabajo() {
        
    }
}
