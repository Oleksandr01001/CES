package model;

public class Coche extends Vehiculo{

    private int cv, cc;

    public Coche() {}

    public Coche(String numSerie, String marca, String modelo, String estado, int precio, int cv, int cc) {
        super(numSerie, marca, modelo, estado, precio);
        this.cv = cv;
        this.cc = cc;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Caballos: "+cv);
        System.out.println("Centimetros cubicos: "+cc);
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }
}
