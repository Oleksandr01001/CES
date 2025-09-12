package model;

import utils.Orientacion;
import utils.ConstruccionException;

public class Terreno {
    private Casa casa;
    private int metrosCuadrados;
    private Orientacion orientacion;
    private double valoracion;

    public Terreno() {
    }

    public Terreno(int metrosCuadrados, Orientacion orientacion, double valoracion) {
        this.metrosCuadrados = metrosCuadrados;
        this.orientacion = orientacion;
        this.valoracion = valoracion * orientacion.getRevalorizacion();
    }

    public void construirCasa(int metrosCuadrados) throws ConstruccionException {
        if (casa != null) {
            throw new ConstruccionException("Ya existe una casa en el terreno.");
        }
        if (this.metrosCuadrados < metrosCuadrados) {
            throw new ConstruccionException("No hay suficiente espacio en el terreno.");
        }
        casa = new Casa(metrosCuadrados);
        revalorizarTerreno();
        System.out.println("Casa construida con éxito.");
    }

    public void revalorizarTerreno() {
        if (casa == null) {
            System.out.println("No hay casa para revalorizar.");
            return;
        }
        double incremento = 0.25;
        if (casa.getMetrosCuadrados() > 100) incremento = 0.30;
        if (casa.isPiscina()) incremento = 0.50;

        valoracion += valoracion * incremento + valoracion * orientacion.getRevalorizacion();
        System.out.println("Nueva valoración del terreno: " + valoracion);
    }

    public Casa getCasa() {
        return casa;
    }

    public String getMetrosCuadrados() {
        return "";
    }

    public String getValoracion() {
        return "";
    }

    public class Casa {
        private int metrosCuadrados;
        private boolean piscina;
        private int habitaciones;

        public Casa(int metrosCuadrados) {
            this.metrosCuadrados = metrosCuadrados;
            this.piscina = false;
            this.habitaciones = 0;
        }

        public int getMetrosCuadrados() {
            return metrosCuadrados;
        }

        public boolean isPiscina() {
            return piscina;
        }

        public void construirHabitacion(int metros) throws ConstruccionException {
            if (metros > metrosCuadrados) {
                throw new ConstruccionException("No hay suficiente espacio en la casa.");
            }
            metrosCuadrados -= metros;
            habitaciones++;
            System.out.println("Habitación construida. Quedan " + metrosCuadrados + " m2 disponibles en la casa.");
        }

        public void construirPiscina() throws ConstruccionException {
            if (piscina) {
                throw new ConstruccionException("Ya existe una piscina en la casa.");
            }
            piscina = true;
            System.out.println("Piscina construida con éxito.");
        }

        public void construirAnexo(int metros) throws ConstruccionException {
            if (metros > Terreno.this.metrosCuadrados - this.metrosCuadrados) {
                throw new ConstruccionException("No hay suficiente espacio en el terreno para el anexo.");
            }
            Terreno.this.metrosCuadrados -= metros;
            System.out.println("Anexo construido con éxito.");
        }
    }
}