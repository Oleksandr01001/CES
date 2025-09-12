package Ejercicio1.controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Hotel {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<Object[]> listaReservas = new ArrayList<>();


    public void reservar() {
        int numeroHabitacion;
        String nombre;
        int telefono;
        String dni;
        int numPersonas;

        System.out.println("Introduce el numero de habitacion que queire reservar:");
        numeroHabitacion = scanner.nextInt();
        System.out.println("Introduce nombre:");
        nombre = scanner.next();
        System.out.println("Introduce telefono:");
        telefono = scanner.nextInt();
        System.out.println("Introduce dni:");
        dni = scanner.next();
        System.out.println("Introduce numero de personas:");
        numPersonas = scanner.nextInt();

        Object[] hotel = new Object[]{numeroHabitacion,nombre,telefono,dni,numPersonas};
        for (Object[] item : listaReservas){
            if (item[3].equals(dni)){
                System.out.println("Ya existe la reserva con este dni, vuelve mas tarde");
                return;
            }
        }
        listaReservas.add(hotel);
        System.out.println("Se ha reservado con exito");

    }
    public void cancelarRecerva() {
        System.out.println("Introduce dni para cancelar la reserva:");
        String dni = scanner.next();

        for (Object[] item : listaReservas){
            if (item[3].equals(dni)){
                System.out.println("La reserva se ha cancelado con exito");
                listaReservas.remove(item);
                return;
            } else {
                System.out.println("Se ha producedo un error");
            }
        }

    }
    public void mostrarReservas() {
        System.out.println("Mostrando reservas:");
        for (Object[] item : listaReservas){
            System.out.println("Numero de habitacion:"+item[0]+" Nombre de huesped:" + item[1]+ " Dni:"+item[3]);
        }
        System.out.println("Se ha mostado con exito");
    }
    public void mostrarReservasOrdenadas() {
            Collections.sort(listaReservas, new Comparator<Object[]>() {
                @Override
                public int compare(Object[] o1, Object[] o2) {
                    if (Integer.valueOf(o1[4].toString()) > Integer.valueOf(o2[4].toString())){
                        return -1;
                    } else if (Integer.valueOf(o1[4].toString()) < Integer.valueOf(o2[4].toString())) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
        System.out.println("Se ha ordenado con exito");
    }
}
