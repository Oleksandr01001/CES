import model.PlataformaJuegos;
import model.Videojuego;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PlataformaJuegos plataformaJuegos = new PlataformaJuegos();

        plataformaJuegos.anadirVideojuego1(new Videojuego("Juego","Olek","Niños",2025,49.50, 50.0));

        plataformaJuegos.listarVideojuegosOrdenados();
        plataformaJuegos.eliminarVideojuego("Juego");
        plataformaJuegos.listarVideojuegosOrdenados();
        plataformaJuegos.calcularPrecioTotal();
    }
}