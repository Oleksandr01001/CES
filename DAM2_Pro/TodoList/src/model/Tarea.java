package model;

public class Tarea {

    // variables

    private String titulo, descripcion;
    private boolean prioritario, completada;

    private  Persona[] encargados;


    // constructores

    public Tarea() {

    }

    public Tarea(String titulo, String descripcion, boolean prioritario, int numeroPersonas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioritario = prioritario;
        encargados = new Persona[numeroPersonas];
    }

    public Tarea(String titulo, String descripcion, int numeroPersonas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        encargados = new Persona[numeroPersonas];

    }

    //metodos -> getter / setter

    public void asignarPersona(Persona persona) {
        for (int i = 0; i < encargados.length; i++) {
            if (encargados[i] == null && !comprobarDNI(persona.getDni())) {
                encargados[i] = persona;
                System.out.println("Persona agregada");
                return;
            }
        }
        System.out.println("No hay hueco disponible, tarea completa");
    }

    private boolean comprobarDNI(String dni) {
        for (Persona p : encargados) {
            if(p!= null && p.getDni().equalsIgnoreCase(dni)) {
                return true;
            }
        }
        return false;
    }

    public void eliminarResponsable(String dni) {
        for (Persona p : encargados) {
            if(p!= null && p.getDni().equalsIgnoreCase(dni)) {
                p = null;
                System.out.println("Persona eliminada");
                return;
            }
        }
        System.out.println("La persona no esta en esta lista");
    }


    public void listarResponsables() {
        int numeroHuecos = 0;
        for (Persona p : encargados) {
            if (p == null) {
                numeroHuecos++;
                break;
            } else {
                System.out.println("Nombre: "+p.getNombre());
                System.out.println("Apellido: "+p.getApellido());
                System.out.println("DNI: "+p.getDni());
                System.out.println("Edad: "+p.getEdad());
                System.out.println();
            }
        }
        if (numeroHuecos > 0) {
            System.out.println("Numero huecos: " + numeroHuecos);
        }
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isPrioritario() {
        return prioritario;
    }

    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prioritario=" + prioritario +
                ", completada=" + completada +
                '}';
    }



}
