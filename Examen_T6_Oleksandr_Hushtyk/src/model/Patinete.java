package model;

public class Patinete extends Vehiculo{

    private int autonomia;

    public Patinete() {
    }

    public Patinete(String numSerie, String marca, String modelo, String estado, int precio, int autonomia) {
        super(numSerie, marca, modelo, estado, precio);
        this.autonomia = autonomia;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Autonomia: "+autonomia);
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }
}
