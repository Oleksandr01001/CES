package model;

public class Accionista implements Empleador{

    private String nombre, apellido, dni;
    private double acciones;
    private double beficio;

    public Accionista() {
    }

    public Accionista(String nombre, String apellido, String dni, int acciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.acciones = acciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAcciones() {
        return acciones;
    }

    public void setAcciones(int acciones) {
        this.acciones = acciones;
    }

    @Override
    public void calcularBeneficio() {
        acciones = beficio*0.2;
        System.out.println("Acciones: "+acciones);
    }
}
