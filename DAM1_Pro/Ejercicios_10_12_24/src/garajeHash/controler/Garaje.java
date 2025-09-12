package garajeHash.controler;

import java.util.Enumeration;
import java.util.Hashtable;

public class Garaje {


    private Hashtable<String,Object[]> listaCohes;

    public Garaje() {
        listaCohes = new Hashtable<>();
    }

    public void agregarCoche() {
        Object[] coche1 = {"1234A","Mercedes","ClaseA",10000,150};
        Object[] coche2 = {"2345B","Mercedes","ClaseB",20000,250};
        Object[] coche3 = {"3456C","Mercedes","ClaseC",30000,350};
        Object[] coche4 = {"4567D","Mercedes","ClaseD",40000,450};
        listaCohes.put(coche1[0].toString(),coche1);
        listaCohes.put(coche2[0].toString(),coche2);
        listaCohes.put(coche3[0].toString(),coche3);
        listaCohes.put(coche4[0].toString(),coche4);
    }

    public void getCoche(String matricula) {
        if (listaCohes.containsKey(matricula)) {
            Object[] cocheEncontrado = listaCohes.get(matricula);
            System.out.println(cocheEncontrado[3]);
        }
    }

    public void borrarCoche (String matricula) {
        listaCohes.remove(matricula);
    }

    public void modificarCoche(String matricula) {
        Object[] coche = listaCohes.get(matricula);
        coche[3] = Integer.valueOf(coche[3].toString()) + 20000;
    }

    public void recorrerCochesKey() {
        Enumeration<String> keys = listaCohes.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            getCoche(key);
        }
    }

    public void recorrerCocheElement() {
        Enumeration<Object[]> coches = listaCohes.elements();
        while (coches.hasMoreElements()) {
            Object[] coche = coches.nextElement();
            getCoche(coche[1].toString());
        }
    }
}
