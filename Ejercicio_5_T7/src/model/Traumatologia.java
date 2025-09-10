package model;

public class Traumatologia extends Doctor {

    public Traumatologia() {
    }

    public Traumatologia(String nombre, String apellido, String numColegiado) {
        super(nombre, apellido, numColegiado);
    }

    public void realizarVenda() {
        System.out.println(nombre + " ha realizado una venda.");
    }


}
