package model;

public class VideojuegoEstrategia extends Videojuego {

    private int complejidad, duracionPartida;


    public VideojuegoEstrategia() {
    }

    public VideojuegoEstrategia(String titulo, String desarrollador, String clasificacionEdad, int anoLanzamiento, double precio, double tamanoGB, int complejidad, int duracionPartida) {
        super(titulo, desarrollador, clasificacionEdad, anoLanzamiento, precio, tamanoGB);
        this.complejidad = complejidad;
        this.duracionPartida = duracionPartida;
    }


    @Override
    public void calcularPrecioFinal() {
        double precio = getPrecio();
        if (complejidad > 0) {
            precio = (((super.getPrecio()*3)/100) * complejidad);
            super.setPrecio(precio);
            System.out.println("Precio ahora: "+precio);
        }
    }

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public int getDuracionPartida() {
        return duracionPartida;
    }

    public void setDuracionPartida(int duracionPartida) {
        this.duracionPartida = duracionPartida;
    }


    @Override
    public String toString() {
        return super.toString()+" VideojuegoEstrategia{" +
                "complejidad=" + complejidad +
                ", duracionPartida=" + duracionPartida +
                '}';
    }
}
