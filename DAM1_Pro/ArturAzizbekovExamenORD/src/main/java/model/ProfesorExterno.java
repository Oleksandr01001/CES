package model;

public class ProfesorExterno extends Profesor {
    private int numHoras;
    private double precioPorHora;

    public ProfesorExterno(String nombre, String dni, int salarioAnual, int numHoras, double precioPorHora) {
        super(nombre, dni, salarioAnual);
        this.numHoras = numHoras;
        this.precioPorHora = precioPorHora;
    }

    @Override
    public double calcularSalarioTotal() {
        return getSalarioAnual()  + numHoras * precioPorHora * 12;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(double precioPorHora) {
        this.precioPorHora = precioPorHora;
    }
}
