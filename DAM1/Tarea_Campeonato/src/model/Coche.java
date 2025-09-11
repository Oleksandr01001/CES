package model;

import java.util.Random;

public class Coche {
    private int cv, velocidad;
    private String matricula, modelo;
    private double km;
    private Random random = new Random();

    public Coche(String modelo, String matricula, int cv) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.cv = cv;
        this.km = 0.0;
    }

    public void acelerar(int acelero){
        velocidad += acelero;
        if (velocidad > 180){
            System.out.println("Tienes velocidad máxima 180");
            velocidad = 180;
        }
        km += velocidad * (cv * random.nextInt(1, 10) * 0.001);
    }

    public void mostrarDatos(){
        System.out.println("Matricula: " + matricula + " Modelo: " + modelo + " CV: " + cv +
                " Velocidad: " + velocidad + " km/h - Kilómetros: " + km + " km");
    }

    public int getVelocidad() { return velocidad; }
    public String getModelo() { return modelo; }
    public String getMatricula() { return matricula; }
    public double getKm() { return km; }
}
