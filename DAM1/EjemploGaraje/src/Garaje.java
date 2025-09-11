import java.util.ArrayList;
import java.util.Scanner;

public class Garaje {

    private ArrayList<Object[]> listaCoches = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void anadirCoche(String marca, String modelo, int coste, String matricula) {
        Object[] coche = new Object[]{marca,modelo,coste,matricula};

        for (Object[] item : listaCoches) {
            if (item[3].equals(matricula)) {
                System.out.println("Ya existe un coche con esta matrícula: " + matricula);
                return;
            }
        }



        // no > 5 coches
        /*if (listaCoches.size() < 5) {
            listaCoches.add(coche);
        } else {
            System.out.println("No puedes añadir mas coches");
        }*/

    }


    public void mostrarCoches() {
        if (listaCoches.isEmpty()) {
            System.out.println("Lista esta vacia");
        }
        for (Object[] coche : listaCoches) {
            System.out.println(coche[3]+" - "+coche[0]+" - "+coche[1]);
        }
    }

}
