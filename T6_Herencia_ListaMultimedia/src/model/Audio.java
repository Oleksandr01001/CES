package model;

public class Audio extends Elemento{

    private double duracion;
    private String soporte;

    public Audio() {}

    public Audio(String id, String titulo, String formato, Persona autor, int tamano, double duracion, String soporte) {
        super(id, titulo, formato, autor, tamano);
        this.duracion = duracion;
        this.soporte = soporte;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Duracion: "+duracion);
        System.out.println("Soporte: "+soporte);
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }
}
