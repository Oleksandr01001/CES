package model;

import java.util.ArrayList;
import java.util.Date;

public class TareaProfesional extends Tarea{

    private int presupuesto;
    private Date fechaLimite;


    public TareaProfesional(){}

    /*
    @Override
    public void enviarRecordatorio() {
        for ( Persona persona : getEncargados() ) {
            if (persona !=null){
                System.out.printf("%s recuerda que completar %d tareas pendientes\n"
                        ,persona.getNombre(),getListaTareas().size());
            }
        }
    }
     */

    public TareaProfesional(int id, String titulo, String descripcion, int numeroPersonas, Prioridad prioridad,
                            int presupuesto, Date fechaLimite){
        super(id,titulo,descripcion,numeroPersonas,prioridad);
        this.fechaLimite = fechaLimite;
        this.presupuesto = presupuesto;
    }

    public TareaProfesional(int id, String titulo, String descripcion, boolean prioritario,
                            int numeroPersonas, Prioridad prioridad, int presupuesto, Date fechaLimite) {
        super(id,titulo, descripcion, prioritario, numeroPersonas,prioridad);
        this.presupuesto = presupuesto;
        this.fechaLimite = fechaLimite;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    @Override
    public String toString() {
        return super.toString()+" TareaProfesional{" +
                "presupuesto=" + presupuesto +
                ", fechaLimite=" + fechaLimite +
                '}';
    }
}