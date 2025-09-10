package controller;

import model.Cliente;
import model.Consumicion;
import util.Provedor;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    private Scanner scanner = new Scanner(System.in);

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Consumicion> listaPedidos;
    private double caja;
    private Provedor provedor;

    public Restaurante(Provedor provedor) {
        listaClientes = new ArrayList<>();
        this.provedor = provedor;
    }

    public Restaurante() {
        listaClientes = new ArrayList<>();
    }


    public void informacionProvedor() {
        if (provedor == null) {
            System.out.println("El restaurante no tiene provedor asignado");
        } else {
            System.out.println("El nombre de provedor es: "+provedor.name());
            System.out.println("La informacion de provedor es: ");
            System.out.println(provedor.getNombre());
            System.out.println(provedor.getDescuento());
            System.out.println(provedor.getContacto());
        }
    }


    // admitir clientes. Tan solo se podrá admitir un cliente
    // si no existe uno con ese nombre
    public void agregarCliente(Cliente cliente){
        // no pido los datos aqui!!!, esto lo hace la ENTRADA - UI->l controlador es la LOGICA
        // metera al cliente dentro de la lista
        if (estaCliente(cliente.getNombre())!=null){
            System.out.println("Ya esta en el resutaurante");
        } else {
            listaClientes.add(cliente);
            System.out.println("Bienvenido al resultaurante");
        }
    }

    // obtener informacion de todos los clientes que estan en el resustaurante
    // en el caso de tener un cliente sin consumiciones, deberá aparecer el mensaje
    // aun no ha pedido
    public void mostrarClientes(){
        for (Cliente cliente: listaClientes) {
            cliente.mostrarDatos();
        }
    }

    // un cliente puede pedir una una consumicion
    // si en la lista de consumiciones del cliente, ya existe ese producto
    // preguntar si realmente quiere pedirlo. En el caso de decir que si
    // preguntar si quiere agregar mas de uno, e indicar el numero concreto
    private Cliente estaCliente(String nombre){
        for ( Cliente cliente : listaClientes ) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)){
                return cliente;
            }
        }
        return null;
    }
    private void agregarPedido(Consumicion consumicion,String nombre){
        Cliente cliente = estaCliente(nombre);
        for (Consumicion consumicion1: listaPedidos){
            if (consumicion1.equals(consumicion)){
                System.out.println("Estas seguro que qieres añadir consumicion otra vez?");
                String respuesta = scanner.next();
                if (respuesta.equalsIgnoreCase("si")){
                    System.out.println("Cuantas mas quieres?");
                    int cantidadConsumiciones = scanner.nextInt();
                    for (int i = 0; i < cantidadConsumiciones; i++) {
                        listaPedidos.add(consumicion);
                    }
                }
            } else {
                listaPedidos.add(consumicion);
            }
        }
    }


}