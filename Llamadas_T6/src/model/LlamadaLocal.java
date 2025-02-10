package model;

public class LlamadaLocal extends Llamadas{

    public LlamadaLocal() {}

    public LlamadaLocal(int nOrigen, int nDestino, int duracion) {
        super(nOrigen, nDestino, duracion);
        calcularCoste();
    }

    public void calcularCoste() {
        setCoste(0);
    }
}
