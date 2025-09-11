package controller;

import model.Llamadas;

import java.util.ArrayList;

public class Centralita {

    private ArrayList<Llamadas> llamadas;

    public Centralita() {
        llamadas = new ArrayList<>();
    }

    public void registrarLlamada(Llamadas llamada) {
        llamadas.add(llamada);
    }

    public void mostrarLlamadas() {
        for (Llamadas item : llamadas) {
            item.mostrarDatos();
        }
    }

    public void mostrarCostes() {
        double total = 0;

        for (Llamadas item : llamadas) {
            total += item.getCoste();
        }
        System.out.println("El coste total de todas las llamadas: "+total);
    }

}
