package controller;

import model.Coche;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Carrera2 {

    static Random random = new Random();

    private int vueltas;
    private String nombre;
    private ArrayList<Coche2> participantes;

    public Carrera2(int vueltas, String nombre) {
        this.nombre = nombre;
        this.vueltas = vueltas;
        participantes = new ArrayList<>();
    }

    public void inscribirParticipante(Coche2 coche2) {
        for (Coche2 item : participantes) {
            if (coche2.getMatricula().equals(item.getMatricula())) {
                System.out.println("Lo siento no puedes inscribir...");
                return;
            }
        }

        if (participantes.size()==8 || coche2.getCv()>=300) {
            System.out.println("Lo siento no puedes inscribir...");
        } else {
            participantes.add(coche2);
            System.out.println("Agregado con exito");
        }
    }

    public void desinscribirParticipante(String matricula) {
        for (Coche2 coche2 : participantes) {
            if (matricula.equals(coche2.getMatricula())) {
                participantes.remove(coche2);
            }
        }
        System.out.println("Participante desinscribido con exito");
    }

    public void imprimirCoches() {
        for (Coche2 item : participantes) {
            System.out.println("Marca: "+item.getMarca()+" Modelo: "+item.getModelo()+" Matricula: "+item.getMatricula()+" Caballos: "+item.getCv());
        }
    }

    public void inicializarCarrera(int vueltas) {
        for (int i = 0; i < vueltas; i++) {
            System.out.println("Vuelta " + (i + 1) + ":");
            for (Coche2 coche2 : participantes) {
                int kmRecorrido = random.nextInt(50,75);
                coche2.setKm(coche2.getKm() + kmRecorrido);
                System.out.println(coche2.getMarca() + " " + coche2.getModelo() + " ha recorrido " + kmRecorrido
                        + " km. Total: " + coche2.getKm() + " km.");
            }
        }
    }

    public void mostrarGanador() {
        participantes.sort((o1, o2) -> Integer.compare(o2.getKm(), o1.getKm()));
        Coche2 ganador = participantes.get(0);
        System.out.println("\nGanador:");
        System.out.printf("Marca: %s, Modelo: %s, Matrícula: %s, Kilómetros: %d%n",
                ganador.getMarca(), ganador.getModelo(), ganador.getMatricula(), ganador.getKm());
    }

    public void mostrarClasificacion() {
        participantes.sort((o1, o2) -> Integer.compare(o2.getKm(), o1.getKm()));
        System.out.println("\nClasificación de Participantes:");
        for (Coche2 coche : participantes) {
            System.out.printf("Marca: %s, Modelo: %s, Matrícula: %s, Kilómetros: %d%n",
                    coche.getMarca(), coche.getModelo(), coche.getMatricula(), coche.getKm());
        }
    }






}
