package model;

public class ProfesorExterno extends Profesor{

    private int numeroHoras;
    private double precioHora;

    public ProfesorExterno() {
    }

    public ProfesorExterno(String nombre, String dni, double salario, int numeroHoras, double precioHora) {
        super(nombre, dni, salario);
        this.numeroHoras = numeroHoras;
        this.precioHora = precioHora;
    }

    @Override
    public double calcularSalario() {
        return getSalario() + numeroHoras * precioHora * 12;
    }


    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }
}
