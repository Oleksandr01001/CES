package controller;

import model.Audio;
import model.Elemento;
import model.Libro;
import model.Video;

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

    public void listarElementos(int tipo){
        for (Elemento item : elementos) {
            switch (tipo) {
                case 0:
                    if (item instanceof Libro) {
                        item.mostrarDatos();
                        System.out.println();
                    }
                    break;
                case 1:
                    if (item instanceof Audio) {
                        item.mostrarDatos();
                        System.out.println();
                    }
                    break;
                case 2:
                    if (item instanceof Video) {
                        item.mostrarDatos();
                        System.out.println();
                    }
                    break;
                case 3:
                    item.mostrarDatos();
            }
        }
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }
}
