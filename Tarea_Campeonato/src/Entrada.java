
import controller.Carrera;
import model.Coche;

import java.util.ArrayList;
import java.util.List;

public class Entrada {
    public static void main(String[] args) {


        List<Coche> coches = new ArrayList<>();
        coches.add(new Coche("Ferrari", "1234ABC", 500));
        coches.add(new Coche("Lamborghini", "5678DEF", 550));
        coches.add(new Coche("Bugatti", "9101GHI", 600));


        Carrera carrera = new Carrera(coches, 10000);


        carrera.inicarCarrera();
    }
}