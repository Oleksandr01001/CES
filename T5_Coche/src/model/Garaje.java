package model;

public class Garaje {

    private Coche coche;
    private String averiaAsociada;
    private int numeroCoches;

   public void Garaje() {
       this.coche = null;
       this.averiaAsociada = "";
       this.numeroCoches = 0;
   }

   public boolean aceptarCoche(Coche coche, String averiaAsociada) {
       if (coche != null) {
           return false;
       }
       this.coche = coche;
       this.averiaAsociada = averiaAsociada;
       coche.acumularAveria(averiaAsociada);
       numeroCoches++;
       return true;
   }

   public void devolverCoche() {
       this.coche = null;
       this.averiaAsociada = "";
   }
}
