import model.Coche;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Carrera {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    final int participantes = 8;


    public void inscribirPerticipantes(){
        System.out.println("Escribe cuantos participantes quieres inscribir:");
        int numParticipantes = scanner.nextInt();
    }

    public static void main(String[] args) {
        ArrayList<Coche> listaCoches = new ArrayList<>();

        listaCoches.add(new Coche("Ford","Focus","Plata"));
        listaCoches.add(new Coche("Seat","Ibiza","Blanco"));
        for (Coche coche : listaCoches){
            coche.mostrarDatos();
            System.out.println();
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("Escribe marca de coche:");
            String marca = scanner.next();
            System.out.println("Escribe modelo de coche:");
            String modelo = scanner.next();
            System.out.println("Escribe cv de coche:");
            int cv = scanner.nextInt();
            System.out.println("Escribe matricula de coche:");
            String matricula = scanner.next();
            listaCoches.add(new Coche(marca,modelo,matricula,cv));

        }
        System.out.println("Escribe cuantas vueltas quieres:");
        int vueltas  = scanner.nextInt();
        for (int i = 0; i < vueltas; i++) {
            System.out.println("Vuelta " + (i + 1) + ":");
            for (Coche coche: listaCoches){
                int kmRecorrido = random.nextInt(50,75);
                coche.setKm(coche.getKm()+kmRecorrido);
                System.out.println(coche.getMarca() + " " + coche.getModelo() + " ha recorrido " + kmRecorrido
                        + " km. Total: " + coche.getKm() + " km.");
            }
        }

        listaCoches.sort(new Comparator<Coche>() {
            @Override
            public int compare(Coche o1, Coche o2) {
                if (o1.getKm() > o2.getKm()){
                    return 1;
                } else if (o1.getKm() < o2.getKm()) {
                    return -1;
                }
                return 0;
            }
        });
        for (Coche coche : listaCoches){
            System.out.printf("Marca:%s Modelo:%s Matricula:%s",coche.getMarca(),coche.getModelo(),coche.getMatricula());
        }

        /*Un coche tiene un atributo KM,
        los cuales pueden decir la distanaia que ha recorrido un coche
        Para poder hacer una carrera, es necesario que se pida por consola
        los datos de 6 participantes, donde se debe indicar marca, madela,
        matricula, cv
        Una vez indicados todos los participantes, es necesario indicar cuantas
        vueltas consta la carrera
        Una vez indica el no de vueltas, la carrera comienza. Para ello en cada vuelta
        cada coche recorre un numero de km aleatorio (50-75)
        Una vez se terminan las vueltas el sistema mostrara:


        El ganado es el cache XXXX XXXX XXXXX
        La clasificacion final es.
        1- XXXX XXXX*/
    }
}