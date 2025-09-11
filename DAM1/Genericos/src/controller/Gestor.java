package controller;

import model.Coche;

import java.util.ArrayList;

public class Gestor<S> {

    private ArrayList<S> listado;


    public void anadirElemento(S dato) {
        this.listado.add(dato);
    }


}
