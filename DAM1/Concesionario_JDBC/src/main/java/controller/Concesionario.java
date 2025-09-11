//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import model.Coche;
import model.CocheDTO;

public class Concesionario {
    private ArrayList<Coche> coches = new ArrayList();
    CocheDTO cocheDTO = new CocheDTO();

    public Concesionario() {
    }

    public void agregarCoche(Coche coche) {
        if (!this.cocheDTO.getCocheMatricula(coche.getMatricula())) {
            this.coches.add(coche);
            this.cocheDTO.insertarCoche(coche);
            System.out.println("Coche agregado");
        } else {
            System.out.println("Ya existe coche con esa matricula");
        }

    }

    public void borrarCoche(int id) {
        boolean encontrado = false;

        for(int i = 0; i < this.coches.size(); ++i) {
            if (((Coche)this.coches.get(i)).getId() == id) {
                this.coches.remove(i);
                this.cocheDTO.eliminarCoche(id);
                System.out.println("Coche eliminado");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hemos encontrado coche con este id");
        }

    }

    public void consultarCoche(int id) {
        Iterator var2 = this.coches.iterator();

        Coche coche;
        do {
            if (!var2.hasNext()) {
                System.out.println("No se encontro ningun coche con este id");
                return;
            }

            coche = (Coche)var2.next();
        } while(coche.getId() != id);

        System.out.println("Coche encontrado " + String.valueOf(coche));
    }

    public void listaCoches() {
        if (this.coches.isEmpty()) {
            System.out.println("No hay coches en lista");
        } else {
            System.out.println("Lista de coches");
            Iterator var1 = this.coches.iterator();

            while(var1.hasNext()) {
                Coche coche = (Coche)var1.next();
                System.out.println(coche);
            }
        }

    }

    public void exportarCochesCSV() {
        try {
            FileWriter writer = new FileWriter("coches.csv");

            try {
                Iterator var2 = this.coches.iterator();

                while(true) {
                    if (!var2.hasNext()) {
                        System.out.println("Coches exportados correctamente a coches.csv");
                        break;
                    }

                    Coche coche = (Coche)var2.next();
                    String linea = String.format("%d;%s;%s;%s;%s;%d;%d\n", coche.getId(), coche.getMarca(), coche.getColor(), coche.getModelo(), coche.getMatricula(), coche.getPrecio(), coche.getIdPasajero());
                    writer.write(linea);
                }
            } catch (Throwable var6) {
                try {
                    writer.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            writer.close();
        } catch (IOException var7) {
            IOException e = var7;
            System.err.println(" Error al exportar a CSV: " + e.getMessage());
        }

    }

    public void asignarPasajeroACoche(int idCoche, int idPasajero) {
        Iterator var3 = this.coches.iterator();

        Coche coche;
        do {
            if (!var3.hasNext()) {
                System.out.println("No se encontró ningún coche con ese ID");
                return;
            }

            coche = (Coche)var3.next();
        } while(coche.getId() != idCoche);

        coche.setIdPasajero(idPasajero);
        this.cocheDTO.agregarPasajero(idCoche, idPasajero);
        System.out.println("Pasajero asignado al coche correctamente");
    }

    public ArrayList<Coche> getCoches() {
        return this.coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }
}
