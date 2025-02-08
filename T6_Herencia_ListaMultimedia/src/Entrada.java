import controller.Coleccion;
import model.Audio;
import model.Elemento;
import model.Libro;
import model.Persona;

public class Entrada {

    public static void main(String[] args) {
        Coleccion coleccion = new Coleccion();
        Audio audio = new Audio("123a","Hola","Vertical",new Persona("Olek","12345a"),250,2.5,"No se");
        Audio audio1 = new Audio("123a","Hola","Vertical",new Persona("Olek","12345a"),250,2.5,"No se");
        Audio audio2 = new Audio("123a","Hola","Vertical",new Persona("Olek","12345a"),250,2.5,"No se");

        Libro libro = new Libro("12345a","Lol","Horizontal",new Persona("Ol","5123f"),450,"fjf",250);

        coleccion.anadirElemento(audio);
        coleccion.anadirElemento(audio1);
        coleccion.anadirElemento(audio2);
        coleccion.anadirElemento(libro);

        coleccion.listarElementos(0);
    }
}
