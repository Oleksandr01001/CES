package model;

import java.util.ArrayList;

public class PlataformaJuegos {
    private ArrayList<Videojuego> listaJuegos = new ArrayList<>();

// no funciona
    public void anadirVideojuego(Videojuego videojuego) {
        for (Videojuego item : listaJuegos) {
            if (item.getTitulo().equals(videojuego.getTitulo())) {
                System.out.println("No se puede agregar juego");
                return;
            } else {
                listaJuegos.add(videojuego);
                System.out.println("Juego añadido con exito");
            }
        }
    }
    public void anadirVideojuego1(Videojuego videojuego) {
                listaJuegos.add(videojuego);
                System.out.println("Juego añadido con exito");

    }

    public void eliminarVideojuego(String titulo) {

        for (int i = 0; i < listaJuegos.size(); i++) {
            if (listaJuegos.get(i).getTitulo() == titulo) {
                listaJuegos.remove(listaJuegos.get(i));
                System.out.println("Juego se ha eliminado");
            } else {
                System.out.println("No se ha encontrado");
            }
        }
    }

    public void listarVideojuegosOrdenados() {
        for (Videojuego videojuego: listaJuegos) {
            System.out.println(videojuego);
        }
    }

    public void listarVideojuegosEdad() {
        for (Videojuego videojuego: listaJuegos) {
            System.out.println(videojuego);
        }
    }

    public void calcularPrecioTotal() {
        double precio = 0.0;
        for (Videojuego videojuego : listaJuegos) {
            precio += videojuego.getPrecio();
        }
        System.out.println("El precio total es: "+precio);
    }


}
