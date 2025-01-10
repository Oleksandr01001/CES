package garajeHash;

import garajeHash.controler.Garaje;

public class garaje_hashGaraje {

    public static void main(String[] args) {

        Garaje garaje = new Garaje();
        garaje.agregarCoche();
        // garaje.modificarCoche("3456C");
        // garaje.getCoche("3456C");
        garaje.recorrerCochesKey();
        garaje.recorrerCocheElement();

    }
}
