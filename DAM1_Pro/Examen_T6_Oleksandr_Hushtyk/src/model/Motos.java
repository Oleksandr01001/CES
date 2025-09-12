package model;

public class Motos extends Vehiculo{

    private int peso;
    private String transmision;

    public Motos() {}

    public Motos(String numSerie, String marca, String modelo, String estado, int precio, String transmision, int peso) {
        super(numSerie, marca, modelo, estado, precio);
        this.transmision = transmision;
        this.peso = peso;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Peso: "+peso);
        System.out.println("Transmicion: "+transmision);
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
}
