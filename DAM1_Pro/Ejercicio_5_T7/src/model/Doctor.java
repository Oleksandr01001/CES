package model;

public class Doctor extends Persona{

    private String numColegiado;

    public Doctor() {
    }

    public Doctor(String nombre, String apellido, String numColegiado) {
        super(nombre, apellido);
        this.numColegiado = numColegiado;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Numero Colegiado: "+numColegiado);
    }


    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }
}
