package model;

public class VideojuegoRPG extends Videojuego{

    private boolean mundoAbierto;
    private int horasHistoriaPrincipal;

    public VideojuegoRPG() {
    }

    public VideojuegoRPG(String titulo, String desarrollador, String clasificacionEdad, int anoLanzamiento, double precio, double tamanoGB, boolean mundoAbierto, int horasHistoriaPrincipal) {
        super(titulo, desarrollador, clasificacionEdad, anoLanzamiento, precio, tamanoGB);
        this.mundoAbierto = mundoAbierto;
        this.horasHistoriaPrincipal = horasHistoriaPrincipal;
    }

    @Override
    public void calcularPrecioFinal() {
        double precio = getPrecio();
        if (mundoAbierto == true) {
            precio = ((super.getPrecio()*15)/100);
            super.setPrecio(precio);
            System.out.println("Ahora precio es: "+precio);
        }
        if (horasHistoriaPrincipal >= 10) {
            precio += (((precio*2)/100)* horasHistoriaPrincipal);
            System.out.println("Ahora precio es: "+precio);
        }
    }

    public boolean isMundoAbierto() {
        return mundoAbierto;
    }

    public void setMundoAbierto(boolean mundoAbierto) {
        this.mundoAbierto = mundoAbierto;
    }

    public int getHorasHistoriaPrincipal() {
        return horasHistoriaPrincipal;
    }

    public void setHorasHistoriaPrincipal(int horasHistoriaPrincipal) {
        this.horasHistoriaPrincipal = horasHistoriaPrincipal;
    }

    @Override
    public String toString() {
        return super.toString()+" VideojuegoRPG{" +
                "mundoAbierto=" + mundoAbierto +
                ", horasHistoriaPrincipal=" + horasHistoriaPrincipal +
                '}';
    }
}
