package controller;

import model.Coche;
import model.CocheDTO;
import model.Pasajero;
import model.PasajeroDTO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Concesionario {
    private ArrayList<Coche> coches;
    private ArrayList<Pasajero> pasajeros;
    private Scanner scanner = new Scanner(System.in);

    public Concesionario() {
        coches = new ArrayList<>();
        pasajeros = new ArrayList<>();
    }

    CocheDTO cocheDTO = new CocheDTO();
    PasajeroDTO pasajeroDTO = new PasajeroDTO();

    public void agregarCoche(Coche coche){

        if (!cocheDTO.getCocheMatricula(coche.getMatricula())){
            coches.add(coche);
            cocheDTO.insertarCoche(coche);
            System.out.println("Coche agregado");
        } else {
            System.out.println("Ya existe coche con esa matricula");
        }

    }
    public void agregarPasajero(Pasajero pasajero){
        if (!pasajeroDTO.getPasajeroID(pasajero.getId())){
            pasajeros.add(pasajero);
            pasajeroDTO.insertarPasajero(pasajero);
            System.out.println("Pasajero agregado");
        } else {
            System.out.println("Ya existe pasajero con ese ID");
        }
    }
    public void borrarCoche(int id){
        boolean encontrado = false;
        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).getId()==id){
                coches.remove(i);
                cocheDTO.eliminarCoche(id);
                System.out.println("Coche eliminado");
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("No hemos encontrado coche con este id");
        }
    }
    public void borrarPasajero(int id){
        boolean encontrado = false;
        for (int i = 0; i < pasajeros.size(); i++) {
            if (pasajeros.get(i).getId() == id){
                pasajeros.remove(i);
                pasajeroDTO.eliminarPasajero(id);
                System.out.println("Pasajero eliminado");
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("No he encontrado pasajero con este ID");
        }
    }
    public void consultarCoche(int id){
        for (Coche coche: coches){
            if (coche.getId()== id){
                System.out.println("Coche encontrado "+coche);
                return;
            }
        }
        System.out.println("No se encontro ningun coche con este id");
    }
    public void consultarPasajero(int id){
        for (Pasajero pasajero : pasajeros){
            if (pasajero.getId()==id){
                System.out.println("Pasajero encontrado"+pasajero);
                return;
            }
        }
        System.out.println("No se encontro ningun pasajero con este id");
    }

    public void listaCoches(){
        if (coches.isEmpty()){
            System.out.println("No hay coches en lista");
        } else {
            System.out.println("Lista de coches");
            for (Coche coche : coches){
                System.out.println(coche);
            }
        }
    }
    public void listaPasajeros(){
        if (pasajeros.isEmpty()){
            System.out.println("No hay pasajeros en la lista");
        } else {
            System.out.println("Lista de pasajeros");
            for (Pasajero pasajero : pasajeros){
                System.out.println(pasajero);
            }
        }
    }

    public void exportarCochesCSV(){
        try (FileWriter writer = new FileWriter("coches.csv")) {
            for (Coche coche : coches) {
                String linea = String.format("%d;%s;%s;%s;%s;%d\n",
                        coche.getId(),
                        coche.getMarca(),
                        coche.getColor(),
                        coche.getModelo(),
                        coche.getMatricula(),
                        coche.getPrecio());
                writer.write(linea);
            }
            System.out.println("Coches exportados correctamente a coches.csv");
        } catch (IOException e) {
            System.err.println(" Error al exportar a CSV: " + e.getMessage());
        }

    }
    public void asignarPasajeroACoche() {
        listaCoches();
        System.out.println("Escribe id de coche a que quieres asignar");
        int idCoche = scanner.nextInt();
        listaPasajeros();
        System.out.println("Escribe id de pasajero que quieres asignar");
        int idPasajero = scanner.nextInt();

        pasajeroDTO.agregarPasajeroACoche(idPasajero,idCoche);

    }
    public void eliminarPasajeroDeCoche(){
        listaCoches();
        System.out.println("Escribe id de coche a que quieres asignar");
        int idCoche = scanner.nextInt();
        listaPasajeros();
        System.out.println("Escribe id de pasajero que quieres asignar");
        int idPasajero = scanner.nextInt();

        pasajeroDTO.eliminarPasajeroDeCoche(idPasajero,idCoche);
    }

    public void mostrarPasajerosDeCoche(){
        System.out.println("Escribe id de coche en que quieres ver pasajeros");
        int idCoche  = scanner.nextInt();
        if (pasajeros.isEmpty()){
            System.out.println("No hay pasajeros en lista");
        } else {
            System.out.println("Pasajeros del coche con ID "+idCoche+ ": ");
            pasajeroDTO.mostrarPasajerosDeCoche(idCoche);
        }

    }


    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }
}
