package model;

public class Libro extends Elemento{

    private String isbn;
    private int nDeP;

    public Libro() {}

    public Libro(String id, String titulo, String formato, Persona autor, int tamano, String isbn, int nDeP) {
        super(id, titulo, formato, autor, tamano);
        this.isbn = isbn;
        this.nDeP = nDeP;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("ISBN: "+isbn);
        System.out.println("Numero de paginas: "+nDeP);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getnDeP() {
        return nDeP;
    }

    public void setnDeP(int nDeP) {
        this.nDeP = nDeP;
    }
}
