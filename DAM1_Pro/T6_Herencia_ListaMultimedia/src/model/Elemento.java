package model;

public class Elemento {

    private String id, titulo, formato;
    private Persona autor;
    private int tamano;

    public Elemento() {}

    public Elemento(String id, String titulo, String formato, Persona autor, int tamano) {
        this.id = id;
        this.titulo = titulo;
        this.formato = formato;
        this.autor = autor;
        this.tamano = tamano;
    }

    public void mostrarDatos() {
        System.out.println("Id: "+id);
        System.out.println("Titulo: "+titulo);
        System.out.println("Formato: "+formato);
        System.out.println("Autor: "+autor.getNombre());
        System.out.println("Tamaño: "+tamano);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
}
