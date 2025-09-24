package model;

import java.util.ArrayList;


public class Tarea {




    private String titulo, descripcion;
    private boolean prioritario, completada;
    private Persona[] encargados;
    private ArrayList<Encargo> listaTareas;


    public Tarea() {

    }

    public Tarea(String titulo, String descripcion, boolean prioritario,
                 int numeroPersonas) {
        // completada = false;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioritario = prioritario;
        encargados = new Persona[numeroPersonas];
        listaTareas = new ArrayList<>();
    }

    public Tarea(String titulo, String descripcion, int numeroPersonas) {
        // completada = false;
        // prioritario = false
        this.titulo = titulo;
        this.descripcion = descripcion;
        encargados = new Persona[numeroPersonas];
        listaTareas = new ArrayList<>();
    }



    public void asignarResponsable(Persona persona) {
        for (int i = 0; i < encargados.length; i++) {
            if (encargados[i] == null && !estaDNI(persona.getDni())) {
                encargados[i] = persona;
                System.out.println("Persona agregada correctamente");
                return;
            }
        }
        System.out.println("No hay hueco disponible, tarea completa");
    }

    public void eliminarResponsable(String dni) {
        for (Persona persona : encargados) {
            if (persona != null && persona.getDni().equalsIgnoreCase(dni)) {
                persona = null;
                System.out.println("Persona eliminada correctamente");
                return;
            }
        }
        System.out.printf("La persona con DNI %s no esta en esta tarea%n", dni);
    }



    public void mostrarResponsables() {
        int numeroHuecos = 0;
        for (Persona persona : encargados) {
            if (persona == null) {
                numeroHuecos++;
            } else {
                System.out.println(persona);
            }
        }

        if (numeroHuecos == encargados.length) {
            System.out.println("No hay resposonsables asignados");
        } else if (numeroHuecos > 0) {
            System.out.printf("Hay %d huecos disponibles%n", numeroHuecos);
        } else {
            System.out.println("Todos los responsables estan ubicados");
        }


    }

    private boolean estaDNI(String dni) {
        for (Persona persona : encargados) {
            if (persona != null && persona.getDni().equalsIgnoreCase(dni)) {
                return true;
            }
        }
        return false;
    }

    private Encargo estaEncargo(int id) {

        for (Encargo encargo : listaTareas) {
            if (encargo.getId() == id) return encargo;
        }
        return null;
    }

    public void agregarEncargo(Encargo encargo) {
        if (estaEncargo(encargo.getId()) != null) {
            System.out.println("Error en el proceso, no se puede agregar");
        } else {
            listaTareas.add(encargo);
            System.out.println("Agregado correctamente");
        }
    }

    public void borrarEncargo(int id) {
        if (estaEncargo(id) != null) {
            listaTareas.remove(estaEncargo(id));
            System.out.println("Borrado correctamente");
        } else {
            System.out.println("No esta en la lista el id especificado");
        }
    }


    /*
Listar todos los encargos de una tarea
 */
    public void listarEncargos() {
        for (Encargo encargo : listaTareas) {
            encargo.mostrarDatos();
        }
    }

/*
Buscar un encargo por id y mostrar sus datos
 */
    public void buscarEncargo(int id) {
        if (estaEncargo(id) != null) {
            estaEncargo(id).mostrarDatos();
        } else {
            System.out.println("No sta en la lista");
        }
    }

/*
Completar un encargo -> pasar su variable completada a true
 */


    public void completarEncargo(int id) {
        if(estaEncargo(id) != null) {
            estaEncargo(id).setCompletada(true);
        } else {
            System.out.println("No esta en la lista");
        }
    }

/*
Mostrar un encargo que estan completados
 */
public void listaCompletados() {
    for (Encargo encargo : listaTareas) {
        if (encargo.isCompletada()) {
            encargo.mostrarDatos();
        }
    }
}

/*
Completar una tarea -> Una tarea quedará completa si todos sus encargos
estan completos
 */

    public void completarTarea() {
        for(Encargo encargo:listaTareas) {
            if(!encargo.isCompletada()){
                System.out.println("No se puede completar la tarea");
                return;
            }
        }
        completada = true;
        System.out.println("Tarea comoletada");
    }



    public boolean borrarEncargo1(int id) {
        return listaTareas.remove(estaEncargo(id));
    }

    public Persona[] getEncargados() {
        return encargados;
    }

    public void setEncargados(Persona[] encargados) {
        this.encargados = encargados;
    }

    public ArrayList<Encargo> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(ArrayList<Encargo> listaTareas) {
        this.listaTareas = listaTareas;
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


// creamos un encargo.
// Los encargos tienen una propiedad llamada descripcion,
// una propiedad llamda id y una propiedad llamada completa