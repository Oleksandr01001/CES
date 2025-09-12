package controlador.controler;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Object[]> listaContactos;

    public Agenda() {
        listaContactos = new ArrayList<>();
    }


    public void agregarPersona(String nombre, String apellido, int telefono, String dni) {
        Object[] persona = new Object[]{nombre,apellido,telefono,dni};

        for (Object[] item : listaContactos) {
            if (item[3].equals(dni)) {
                System.out.println("Ya existe persona con este dni...");
                return;
            }
        }
        listaContactos.add(persona);
    }

    public void mostrarPersonas() {
        System.out.println("Mostrando la lista...");
        for (Object[] item : listaContactos) {
            System.out.println(item[0] + " " + item[1] + " " + item[2] + " " + item[3]);
        }
    }

}
