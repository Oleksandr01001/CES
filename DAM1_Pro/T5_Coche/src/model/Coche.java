package model;

import java.util.Random;

public class Coche {

    private Motor motor;
    private String marca, modelo, matricula;
    private double averias;

    public  Coche() {}

    public  Coche(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public  Coche(String marca, String modelo, String matricula, Motor motor) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.motor = motor;
    }

    public void acumularAveria(String averias) {
        Random random = new Random();
        double gastado = random.nextDouble(100,500);
        averias += gastado;
        if ("aceite".equalsIgnoreCase(averias)) {
            motor.setAceite(motor.getAceite() + 10);
        } else {
            motor.setAceite(motor.getAceite() + random.nextInt(0,100));
        }
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getAverias() {
        return averias;
    }

    public void setAverias(double averias) {
        this.averias = averias;
    }
}
