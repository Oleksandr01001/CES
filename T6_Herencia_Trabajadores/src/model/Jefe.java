package model;
import controller.Empresa;

public class Jefe extends Trabajador{

    private int acciones;
    private double beneficio;

    public Jefe() {}

    public Jefe(String nombre, String apellido, String dni, int acciones, double beneficio) {
        super(nombre, apellido, dni);
        this.acciones = acciones;
        this.beneficio = beneficio;
    }

    public void mostarDatos() {
        super.mostrarDatos();
        System.out.println("Acciones: "+acciones);
        System.out.println("Beneficio: "+beneficio);
    }

    public void despedirTrabajador(String dni) {

    }
}
