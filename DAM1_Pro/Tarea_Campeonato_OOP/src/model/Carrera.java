package model;

import java.util.Hashtable;
import java.util.Map;

public class Carrera {

    private Circuito circuito;
    private Hashtable<Participante, Integer> resultados;

    public Carrera() {}

    public Carrera(Circuito circuito) {
        this.circuito = circuito;
        this.resultados = new Hashtable<>();
    }

    public void registrarResultado(Participante participante, int pocicion) {
        int puntos = switch (pocicion) {
            case 1 -> 10;
            case 2 -> 7;
            case 3 -> 6;
            default -> 0;
        };
        participante.agregarPuntos(puntos);

        if (pocicion == 1) {
            participante.getCoche().incrementarVictoria();
        }

        resultados.put(participante, pocicion);
    }

    public Participante obtenerGanadorCarrera() {
        Participante ganador = null;

        for (Map.Entry<Participante, Integer> entrada : resultados.entrySet()) {
            if (entrada.getValue() == 1) {
                ganador = entrada.getKey();
                break; // No necesitamos seguir buscando
            }
        }

        if (ganador != null) {
            System.out.println("El ganador de la carrera es: " + ganador.getCoche().getNombre());
        } else {
            System.out.println("No hay ganador en la carrera.");
        }

        return ganador;
    }


    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public Hashtable<Participante, Integer> getResultados() {
        return resultados;
    }

    public void setResultados(Hashtable<Participante, Integer> resultados) {
        this.resultados = resultados;
    }
}