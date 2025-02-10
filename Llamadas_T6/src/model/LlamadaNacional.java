package model;

public class LlamadaNacional extends Llamadas{

    private int franja;

    public LlamadaNacional() {}

    public LlamadaNacional(int nOrigen, int nDestino, int duracion, int franja) {
        super(nOrigen, nDestino, duracion);
        this.franja = franja;
        calcularCoste();
    }

    public void calcularCoste() {
        switch (franja) {
            case 1:
                setCoste(getDuracion()*0.20);
                break;
            case 2:
                setCoste(getDuracion()*0.25);
                break;
            case 3:
                setCoste(getDuracion()*0.30);
                break;
            default:
                setCoste(getDuracion()*0.15);
        }
    }
}
