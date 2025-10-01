package model;

public class VideojuegoAccion extends Videojuego{

    private int nivelViolencia;
    private boolean modoMultijugador;

    public VideojuegoAccion() {
    }

    public VideojuegoAccion(String titulo, String desarrollador, String clasificacionEdad, int anoLanzamiento, double precio, double tamanoGB, int nivelViolencia, boolean modoMultijugador) {
        super(titulo, desarrollador, clasificacionEdad, anoLanzamiento, precio, tamanoGB);
        this.nivelViolencia = nivelViolencia;
        this.modoMultijugador = modoMultijugador;
    }


    @Override
    public void calcularPrecioFinal() {
        double precio = getPrecio();
        if (nivelViolencia > 3) {
            precio = ((super.getPrecio()*5)/100);
            super.setPrecio(precio);
            System.out.println("Ahora precio es: "+precio);
        } else if (nivelViolencia > 3 && modoMultijugador) {
            precio = ((super.getPrecio()*10)/100);
            super.setPrecio(precio);
            System.out.println("Ahora precio es: "+precio);
        }
    }

    public int getNivelViolencia() {
        return nivelViolencia;
    }

    public void setNivelViolencia(int nivelViolencia) {
        this.nivelViolencia = nivelViolencia;
    }

    public boolean isModoMultijugador() {
        return modoMultijugador;
    }

    public void setModoMultijugador(boolean modoMultijugador) {
        this.modoMultijugador = modoMultijugador;
    }


    @Override
    public String toString() {
        return super.toString()+" VideojuegoAccion{" +
                "nivelViolencia=" + nivelViolencia +
                ", modoMultijugador=" + modoMultijugador +
                '}';
    }
}
