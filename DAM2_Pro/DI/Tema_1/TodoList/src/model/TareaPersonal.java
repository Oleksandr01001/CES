package model;

public class TareaPersonal extends Tarea{

    private String ubicacion;


    public TareaPersonal() {}

    /*@Override
    public void enviarRecordatorio() {
        System.out.println("Enviar un recordatorio para reservar citio en "+ubicacion);
    }
     */

    public TareaPersonal(int id, String titulo, String descripcion, boolean prioritario, int numeroPersonas, Prioridad prioridad, String ubicacion) {
        super(id,titulo, descripcion, prioritario, numeroPersonas,prioridad);
        this.ubicacion = ubicacion;
    }

    public TareaPersonal(int id, String titulo, String descripcion, int numeroPersonas, Prioridad prioridad, String ubicacion) {
        super(id,titulo, descripcion, numeroPersonas,prioridad);
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return super.toString()+" TareaPersonal{" +
                "ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
