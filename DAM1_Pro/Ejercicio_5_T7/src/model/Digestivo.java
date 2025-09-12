package model;

public class Digestivo extends Doctor{
    private int experiencia;

    public Digestivo() {
    }

    public Digestivo(String nombre, String apellido, String numColegiado, int experiencia) {
        super(nombre, apellido, numColegiado);
        this.experiencia = experiencia;
    }


    public void realizarIntervencion() {
        System.out.println(nombre + " está realizando una intervención digestiva.");
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Años de experiencia: "+experiencia);
    }


    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
}
