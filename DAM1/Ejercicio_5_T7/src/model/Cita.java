package model;

import java.util.Date;

public class Cita {

    private Doctor doctor;
    private Paciente paciente;
    private String especialidad;
    private Date fechaCita;

    public Cita() {
    }

    public Cita(Doctor doctor, Paciente paciente, String especialidad, Date fechaCita) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.especialidad = especialidad;
        this.fechaCita = fechaCita;
    }

    public String mostrarDatosCita() {
        return "Cita el " + fechaCita + " con " + doctor.nombre + " " + doctor.apellido + "" +
                " (Especialidad: " + especialidad + ") para " + paciente.nombre + " " + paciente.apellido;
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }
}
