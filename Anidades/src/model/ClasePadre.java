package model;

public class ClasePadre {

    private String nombre, apellido, correo;


    public ClasePadre() {
    }

    public ClasePadre(String nombre, String apellido, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public void mostrarDatos() {
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("correo = " + correo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

class ClaseHija {

    private String nombreHija, apellidoHija, correoHija;

     public ClaseHija() {
     }

     public ClaseHija(String nombreHija, String apellidoHija, String correoHija) {
         this.nombreHija = nombreHija;
         this.apellidoHija = apellidoHija;
         this.correoHija = correoHija;
     }

     public void mostrarDatos() {
         System.out.println("nombreHija = " + nombreHija);
         System.out.println("apellidoHija = " + apellidoHija);
         System.out.println("correoHija = " + correoHija);
     }

     public String getNombreHija() {
         return nombreHija;
     }

     public void setNombreHija(String nombreHija) {
         this.nombreHija = nombreHija;
     }

     public String getApellidoHija() {
         return apellidoHija;
     }

     public void setApellidoHija(String apellidoHija) {
         this.apellidoHija = apellidoHija;
     }

     public String getCorreoHija() {
         return correoHija;
     }

     public void setCorreoHija(String correoHija) {
         this.correoHija = correoHija;
     }
 }


