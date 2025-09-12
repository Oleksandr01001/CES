package controller;

import model.Asalariado;
import model.Autonomo;
import model.Jefe;
import model.Trabajador;

import java.util.ArrayList;

public class Empresa {

    private ArrayList<Trabajador> trabajadores;

    public Empresa() {
        trabajadores = new ArrayList<>();
    }

    public void registrarTrabajadores(int tipo) {

        switch (tipo) {
            case 0:
                trabajadores.add(new Jefe());
                break;

            case 1:
                trabajadores.add(new Asalariado());
                break;

            case 2:
                trabajadores.add(new Autonomo());
                break;
        }

    }

    public void listarTrabajadores(int tipo) {

        switch (tipo) {

            case 0:
                
                break;

        }
    }



}
