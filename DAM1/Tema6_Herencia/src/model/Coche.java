package model;

public class Coche extends Vehiculo{
    // atributos ->
    // metodos -> mostrarDatos y getter/setter
    // constructor -> vacio

    private String traccion;

    public Coche(Motor motor, String bastidor, String traccion) {
        super(motor,bastidor);
        this.traccion = traccion;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Traccion: "+traccion);
    }
}
