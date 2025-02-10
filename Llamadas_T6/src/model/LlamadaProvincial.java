package model;

public class LlamadaProvincial extends Llamadas{

    private final double tarifa = 0.15;

    public LlamadaProvincial() {
    }

    public LlamadaProvincial(int nOrigen, int nDestino, int duracion) {
        super(nOrigen, nDestino, duracion);
        calcularCoste();
    }

    public void calcularCoste() {
        setCoste(getDuracion()*tarifa);
    }
}
