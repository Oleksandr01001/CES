package controller;

import model.Coche;

import java.util.List;
import java.util.Random;

public class Carrera {

    private List<Coche> coches;
    private int kmEtepa = 10000;
    private Random random = new Random();

    public Carrera(List<Coche> coches, int kmEtepa){
        this.coches = coches;
        this.kmEtepa = kmEtepa;
    }

    public void inicarCarrera(){
        System.out.println("Inicio de la carrera");

        for (Coche coche : coches){
            coche.mostrarDatos();
        }

        do {
            for (Coche coche : coches){
                int velocidad = random.nextInt(10, 30);
                coche.acelerar(velocidad);
                System.out.println(coche.getModelo() + " [" + coche.getMatricula() + "] - Velocidad: " +
                        coche.getVelocidad() + " km/h - Kilómetros recorridos: " + coche.getKm() + " km");
            }
            System.out.println("----------------------------------------");

        } while (!haTerminado());

        determinarGanador();
    }

    public boolean haTerminado(){
        for (Coche coche : coches){
            if (coche.getKm() >= kmEtepa){
                return true;
            }
        }
        return false;
    }

    public void determinarGanador(){
        System.out.println("Fin de la carrera");

        Coche ganador = coches.get(0);
        for (Coche coche : coches){
            if (coche.getKm() > ganador.getKm()){
                ganador = coche;
            }
        }
        System.out.println("El ganador es: " + ganador.getModelo() + " [" + ganador.getMatricula() + "] con "
                + ganador.getKm() + " km recorridos");
    }
}
