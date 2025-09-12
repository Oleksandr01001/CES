package model;

public class Paciente extends Persona{
    String nss, dolencia;


    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String nss, String dolencia) {
        super(nombre, apellido);
        this.nss = nss;
        this.dolencia = dolencia;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("NSS: "+nss);
        System.out.println("Dolencia: "+dolencia);
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getDolencia() {
        return dolencia;
    }

    public void setDolencia(String dolencia) {
        this.dolencia = dolencia;
    }
}
