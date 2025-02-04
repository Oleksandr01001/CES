package controller;

import model.Elemento;

import java.util.ArrayList;

public class Coleccion {

    private ArrayList<Elemento> elementos;

    public Coleccion() {
        elementos = new ArrayList<>();
    }

    public void anadirElemento(Elemento elemento) {
        elementos.add(elemento);
    }

    public void eleminarElemento(String id) {

        for (Elemento item : elementos) {
            if (item.getId().equalsIgnoreCase(id)) {
                elementos.remove(item);
            }
        }
    }

    public void buscarElemento(String id) {
        for (Elemento item : elementos) {
            if (item.getId().equalsIgnoreCase(id)) {
                item.mostrarDatos();
            }
        }
    }

    public void listarElementos(int tipo) {

    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }
}
