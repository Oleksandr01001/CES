package controller;

import model.Carrera;
import model.Coche;
import model.Participante;

import java.util.ArrayList;

public class Campeonato {

    private ArrayList<Participante> participantes;
    private ArrayList<Carrera> carreras;

    public Campeonato() {
        participantes = new ArrayList<>();
        carreras = new ArrayList<>();
    }

    public void agregarParticipante(Participante participante) {
        if (participantes.size() < 10) {
            participantes.add(participante);
        } else {
            System.out.println("No se puede agregar mas participantes");
        }
    }

    public void agregarCarrera(Carrera carrera) {
        if (carreras.size() < 8) {
            carreras.add(carrera);
        } else {
            System.out.println("No se puede agregar mas carreras");
        }
    }

    public Participante obtenerGanadorCampeonato() {
        if (participantes.isEmpty()) {
            return null;
        }

        Participante ganador = participantes.get(0);
        for (Participante participante : participantes) {
            if (participante.getPuntos() > ganador.getPuntos()) {
                ganador = participante;
            }
        }
        return ganador;
    }

    public Coche obtenerCocheGanador() {
        if (participantes.isEmpty()) {
            return null;
        }

        Coche mejorCoche = participantes.get(0).getCoche();
        for (Participante participante : participantes) {
            if (participante.getCoche().getVictorias() > mejorCoche.getVictorias()) {
                mejorCoche = participante.getCoche();
            }
        }
        return mejorCoche;
    }


    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }
}
