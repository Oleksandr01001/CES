import model.Coche;

public class Entrada {
    public static void main(String[] args) {

        Coche coche = new Coche();
        coche.setMarca("Fiat");
        coche.mostrarDatos();

        System.out.println();

        Coche coche2 = new Coche("Ford","Focus","gris");
        coche2.mostrarDatos();

        System.out.println();

        Coche coche3 = new Coche("Opel", "Corsa", 250);
        coche3.mostrarDatos();

        System.out.println();

        Coche coche4 = new Coche("BMW","m5","negro",1000,250000,"12bb2","123445667B");
        coche4.mostrarDatos();
    }
}
