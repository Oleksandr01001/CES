package controller;

import model.Cita;
import model.Doctor;
import model.Paciente;
import java.util.Date;


import java.util.ArrayList;

public class Centro<S extends Doctor> {

    private ArrayList<Paciente> listaPacientes;
    private ArrayList<S> listaDoctores;
    private ArrayList<Cita> listaCitas;

    public Centro() {
        this.listaPacientes = new ArrayList<>();
        this.listaDoctores = new ArrayList<>();
        this.listaCitas = new ArrayList<>();
    }


    public void admitirPaciente(Paciente paciente) {
        listaPacientes.add(paciente);
    }

    public void contratarDoctor(S doctor) {
        listaDoctores.add(doctor);
    }

    public void verDoctores() {
        if (listaDoctores.isEmpty()) {
            System.out.println("No hay doctores");
        } else {
            for (S doctor : listaDoctores) {
                System.out.println(doctor);
            }
        }
    }

    public void verPacientes() {
        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes");
        } else {
            for (Paciente paciente : listaPacientes) {
                System.out.println(paciente);
            }
        }
    }

    public void verCitas() {
        if (listaCitas.isEmpty()) {
            System.out.println("No hay citas");
        } else {
            for (Cita cita : listaCitas) {
                System.out.println(cita);
            }
        }
    }

    public void pedirCita(String nss, String especialidad, Date fechaCita) {

        Paciente pacienteEncontrado = null;
        for (Paciente paciente : listaPacientes) {
            if (paciente.getNss().equals(nss)) {
                pacienteEncontrado = paciente;
                break;
            }
        }


        Doctor doctorEncontrado = null;
        for (S doctor : listaDoctores) {
            if (doctor.equals(especialidad)) {
                doctorEncontrado = doctor;
                break;
            }
        }


        if (pacienteEncontrado == null) {
            System.out.println("Error: No se encontró un paciente con el NSS indicado.");
            return;
        }

        if (doctorEncontrado == null) {
            System.out.println("Error: No hay doctores disponibles para la especialidad indicada.");
            return;
        }


        Cita nuevaCita = new Cita(doctorEncontrado, pacienteEncontrado, especialidad, fechaCita);
        listaCitas.add(nuevaCita);
        System.out.println("Cita agendada con éxito para " + pacienteEncontrado.getNombre() + " con el doctor " + doctorEncontrado.getNombre());
    }

}
