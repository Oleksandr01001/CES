package model;

public class Asalariado extends Trabajador{

    private double retencion;

    private int numeroPagas;

    public Asalariado(double salario, int numeroSS, String apellido, String nombre, double retencion, int numeroPagas) {
        super(salario, numeroSS, apellido, nombre);
        this.retencion = 0.02;
        this.numeroPagas = 12;
    }

    public Asalariado() {}

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Retencion: "+retencion);
        System.out.println("Numero pagas: "+numeroPagas);
    }

    @Override
    public void calcularSalarioMes() {

        double salarioMes = (getSalario()-(getSalario()*retencion))/numeroPagas;
        System.out.println("El salario mensual es: "+salarioMes);
    }

    public double getRetencion() {
        return retencion;
    }

    public void setRetencion(double retencion) {
        this.retencion = retencion;
    }

    public int getNumeroPagas() {
        return numeroPagas;
    }

    public void setNumeroPagas(int numeroPagas) {
        this.numeroPagas = numeroPagas;
    }
}
