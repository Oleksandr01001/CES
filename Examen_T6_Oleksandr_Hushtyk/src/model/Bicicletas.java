package model;

public class Bicicletas extends Vehiculo{

    private String tipo;

    public Bicicletas() {}

    public Bicicletas(String numSerie, String marca, String modelo, String estado, int precio, String tipo) {
        super(numSerie, marca, modelo, estado, precio);
        this.tipo = tipo;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Tipo: "+tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
