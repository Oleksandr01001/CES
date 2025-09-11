package model;

public class General extends Doctor{

    private String tipo;

    public General() {
    }

    public General(String nombre, String apellido, String numColegiado, String tipo) {
        super(nombre, apellido, numColegiado);
        this.tipo = tipo;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Tipo: "+tipo);
    }

    public void recetarPastillas() {
        System.out.println("Recetando pastillas.");
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
