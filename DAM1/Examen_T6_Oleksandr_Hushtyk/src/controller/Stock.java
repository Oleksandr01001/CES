package controller;

import model.Bicicletas;
import model.Vehiculo;

import java.util.ArrayList;

public class Stock {

    private int caja;

    private ArrayList<Vehiculo> vehiculos;

    public Stock() {
        vehiculos = new ArrayList<>();
    }

    public void agragarVehculo(Vehiculo vehiculo) {
        if (vehiculo.getEstado().toLowerCase().equals("nuevo")) {
            vehiculo.setPrecio(vehiculo.getPrecio() * 10/100);
            vehiculos.add(vehiculo);
        }
        if (vehiculo.getEstado().toLowerCase().equals("seminuevo")) {
            vehiculo.setPrecio(vehiculo.getPrecio() * 5/100);
            vehiculos.add(vehiculo);
        }
        if (vehiculo.getEstado().toLowerCase().equals("usado")) {
            vehiculos.add(vehiculo);
        }


    }

    public void repararVehiculo(Vehiculo vehiculo,String tipo) {

        switch (tipo.toLowerCase()) {
            case "bici":
                vehiculo.setPrecio(vehiculo.getPrecio()*5/100);
                vehiculo.setEstado("reparado");
                vehiculos.add(vehiculo);
                break;
            case "patinete":
                vehiculo.setPrecio(vehiculo.getPrecio()*10/100);
                vehiculo.setEstado("reparado");
                vehiculos.add(vehiculo);
                break;
            default:
                System.out.println("No se puede arreglar ya que no se tienen las\n" +
                        "capacidades...");
        }
    }

    public void mostrarVehiculos() {
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarDatos();
        }
    }

    public void venderVehiculo(Vehiculo vehiculo) {
        caja += vehiculo.getPrecio();
        vehiculos.remove(vehiculo);
    }

    public void mostrarCaja() {
        System.out.println("En la caja hay: "+caja);
    }


    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }
}
