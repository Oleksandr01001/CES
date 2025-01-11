package Ejercicio3.controler;

import java.util.*;

public class Campeonato {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    Hashtable<String,String[]> pilotos = new Hashtable<>();

    private final int limitePilotos = 10;
    private final int limiteCarreras = 7;
    private int carrerasCompletas = 0;

    public void agregarPilotos() {
        if (pilotos.size() >= limitePilotos) {
            System.out.println("No se pueden agregar mas pilotos...");
            return;
        }

        System.out.print("Introduce su nombre: ");
        String nombre = scanner.next();

        System.out.print("Introduce el bastidor de su coche: ");
        String bastidor = scanner.next();

        if (pilotos.containsKey(bastidor)) {
            System.out.println("Ya existe coche con este bastidor");
        } else {
            pilotos.put(bastidor, new String[] {nombre, "0"});
            System.out.println("Piloto agregado con exito");
        }
    }

    public void actualizarPuntos() {
        if (carrerasCompletas >= limiteCarreras) {
            System.out.println("No se puede hacer mas carreras, campeonato finalzado...");
            return;
        }
        if (pilotos.isEmpty()) {
            System.out.println("No hay pilotos registrados para repartir los puntos...");
            return;
        }
        LinkedHashSet<Integer> puntos = new LinkedHashSet<>();
        while (puntos.size() < pilotos.size()) {
            puntos.add(random.nextInt(13));
        }
        Iterator<Integer> puntosIterator = puntos.iterator();
        for (String bastidor : pilotos.keySet()) {
            int punto = puntosIterator.next();
            String[] pilotDatos = pilotos.get(bastidor);
            int actualizarPuntos = Integer.parseInt(pilotDatos[1]) + punto;
            pilotDatos[1] = String.valueOf(actualizarPuntos);
            System.out.println("Piloto " + pilotDatos[0] + " obtiene " + punto + "puntos");
        }
        carrerasCompletas++;
        System.out.println("Numero de carreras comletas: "+carrerasCompletas);
    }

    public void mostrarInfoPiloto() {
        System.out.print("Introduce el bastidor del piloto para ver la informacion: ");
        String bastidor = scanner.next();

        if (!pilotos.containsKey(bastidor)) {
            System.out.println("No se ha podido encontrar el piloto...");
        } else {
            String[] pilotDatos = pilotos.get(bastidor);
            System.out.println("Nombre: " + pilotDatos[0]);
            System.out.println("Bastidor: " + bastidor);
            System.out.println("Puntos acumulados: " + pilotDatos[1]);
        }
    }

    public void mostrarClasificacion() {
        if (pilotos.isEmpty()) {
            System.out.println("No se han podido encontrar los pilotos para mostrar la clacificacion...");
            return;
        }
        List<Map.Entry<String, String[]>> pilotList = new ArrayList<>(pilotos.entrySet());
        pilotList.sort((entry1, entry2) -> {
            int points1 = Integer.parseInt(entry1.getValue()[1]);
            int points2 = Integer.parseInt(entry2.getValue()[1]);
            return Integer.compare(points2, points1);
        });

        int rango = 1;
        for (Map.Entry<String, String[]> entry : pilotList) {
            String[] pilotDatos = entry.getValue();
            System.out.println(rango + ". " + pilotDatos[0] + " - " + pilotDatos[1] + " puntos");
            rango++;
        }
    }



}
