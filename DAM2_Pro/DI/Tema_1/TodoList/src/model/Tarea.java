package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


 public class Tarea {

     static Scanner sc = new Scanner(System.in);

    private int id;
    private String titulo, descripcion;
    private boolean prioritario, completada;
    private Persona[] encargados;
    private ArrayList<Encargo> listaTareas;
    private ArrayList<Tarea> tareas;
    private Prioridad prioridad;




    public Tarea() {
        listaTareas = new ArrayList<>();
        tareas = new ArrayList<>();
        encargados = new Persona[0];
    }

    public Tarea(int id,String titulo, String descripcion, boolean prioritario,
                 int numeroPersonas, Prioridad prioridad) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioritario = prioritario;
        encargados = new Persona[numeroPersonas];
        listaTareas = new ArrayList<>();
        tareas = new ArrayList<>();
        this.prioridad = prioridad;
    }

    public Tarea(int id, String titulo, String descripcion, int numeroPersonas, Prioridad prioridad) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        encargados = new Persona[numeroPersonas];
        listaTareas = new ArrayList<>();
        tareas = new ArrayList<>();
        this.prioridad = prioridad;
    }






    //public abstract void enviarRecordatorio();

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


    public void listarEncargos(){
        for (Encargo item : listaTareas) {
            System.out.println(item);
        }
    }

    public void listarEncargosCompletados(){
        for (Encargo encargo: listaTareas) {
            if(encargo.isCompletada()){
                encargo.mostrarDatos();
            }
        }
    }


     public void completarEncargo(int id){
         if (estaEncargo(id)!=null && !estaEncargo(id).isCompletada()){
             estaEncargo(id).setCompletada(true);
             System.out.println("Encargo completado correctamente");
         } else {
             System.out.println("El encargo no se puede completar, " +
                     "no esta en la lista o ya esta completado");
         }
     }








     private Tarea estaTarea(int id) {
         for (Tarea tarea : tareas) {
             if (tarea.getId() == id) return tarea;
         }
         return null;
     }

     public void agregarTarea(Tarea tarea) {
         if (estaTarea(tarea.getId()) != null) {
             System.out.println("Error en el proceso, no se puede agregar");
         } else {
             tareas.add(tarea);
             System.out.println("Agregado correctamente");
         }
     }

     public void listarTareas() {
        for (Tarea tarea: tareas) {
            System.out.println(tarea);
        }
     }

     public void listarTareasCompletadas(){
         for (Tarea tarea : tareas) {
             if(tarea.isCompletada()){
                 System.out.println(tarea);
             }
         }
     }

     public void listarTareasNoCompletadas(){
         for (Tarea tarea : tareas) {
             if(!tarea.isCompletada()){
                 System.out.println(tarea);
             }
         }
     }

     public void completarTarea(){
         for (Encargo encargo: listaTareas) {
             if (!encargo.isCompletada()){
                 System.out.println("No se puede completar la tarea");
                 return;
             }
         }
         completada = true;
         System.out.println("Tarea completada con exito");
     }


     public void modificarTarea(int id) {
        if(estaTarea(id) != null) {

            Tarea tarea = estaTarea(id);
            //TareaProfesional tareaProfesional = (TareaProfesional) estaTarea(id);
            //TareaPersonal tareaPersonal = (TareaPersonal) estaTarea(id);


            int opcionTarea;
            int opcion;

            String nuevoTitulo, nuevaDescripcion, dni, descripcionSubTarea;
            Prioridad nuevaPrioridad;
            int idSubTarea;





            do {
                System.out.println("Elige que tipo de tarea quieres modificar: ");
                System.out.println("1. Tarea Profecional");
                System.out.println("2. Tarea Personal");
                System.out.println("0. Salir del modificacion");
                opcionTarea = sc.nextInt();

                switch (opcionTarea) {
                    case 1:
                        if (!(tarea instanceof TareaProfesional tareaProfesional)) {
                            System.out.println("La tarea con id " + id + " NO es profesional.");
                            break;
                        }
                        do {
                            System.out.println("Introduce la opcion: ");
                            System.out.println("1. Cambiar titulo");
                            System.out.println("2. Cambiar descripcion");
                            System.out.println("3. Cambiar prioridad");
                            System.out.println("4. Añadir responsable");
                            System.out.println("5. Eliminar responsable");
                            System.out.println("6. Añadir subtarea");
                            System.out.println("7. Eliminar subtarea");
                            System.out.println("8. Cambiar presupuesto");
                            System.out.println("0. Salir de modificacion de tarea Profesional");
                            opcion = sc.nextInt();

                            switch (opcion) {
                                case 1:
                                    System.out.println("Introduce nuevo titulo: ");
                                    nuevoTitulo = sc.next();
                                    tareaProfesional.setTitulo(nuevoTitulo);
                                    System.out.println("Titulo actualizado");
                                    break;
                                case 2:
                                    System.out.println("Introduce nueva descripcion: ");
                                    nuevaDescripcion = sc.next();
                                    tareaProfesional.setDescripcion(nuevaDescripcion);
                                    System.out.println("Descripcion actualizada");
                                    break;
                                case 3:
                                    System.out.println("Introduce nueva prioridad: ");
                                    nuevaPrioridad = Prioridad.valueOf(sc.next().toUpperCase());
                                    tareaProfesional.setPrioridad(nuevaPrioridad);
                                    System.out.println("Prioridad actualizada");
                                    break;
                                case 4:
                                    System.out.println("Introduce dni: ");
                                    dni = sc.next();
                                    System.out.println("Introduce nombre: ");
                                    String nombre = sc.next();
                                    System.out.println("Introduce apellido: ");
                                    String apellido = sc.next();
                                    System.out.println("Introduce edad: ");
                                    int edad = sc.nextInt();
                                    tareaProfesional.asignarResponsable(new Persona(dni,nombre,apellido,edad));
                                    break;
                                case 5:
                                    System.out.println("Introduce el dni del responsable que quieres eliminar: ");
                                    dni = sc.next();
                                    tareaProfesional.eliminarResponsable(dni);
                                    break;
                                case 6:
                                    System.out.println("Introduce id de subtarea: ");
                                    idSubTarea = sc.nextInt();
                                    System.out.println("Introduce descripcion de subtarea: ");
                                    descripcionSubTarea = sc.next();
                                    tareaProfesional.agregarEncargo(new Encargo(idSubTarea,descripcionSubTarea));
                                    break;
                                case 7:
                                    System.out.println("Introduce el id de subtarea que quieres eliminar: ");
                                    idSubTarea = sc.nextInt();
                                    tareaProfesional.borrarEncargo(idSubTarea);
                                    break;
                                case 8:
                                    System.out.println("Introduce nuevo presupuesto: ");
                                    int nuevoPresupuesto = sc.nextInt();
                                    tareaProfesional.setPresupuesto(nuevoPresupuesto);
                                    break;
                                case 0:
                                    System.out.println("Saliedo de modificacion de la tarea profecional...");
                                    break;

                            }

                        } while (opcion != 0);
                        break;


                    case 2:
                        if (!(tarea instanceof TareaPersonal tareaPersonal)) {
                            System.out.println("La tarea con id " + id + " NO es profesional.");
                            break;
                        }
                        do {
                            System.out.println("Introduce la opcion: ");
                            System.out.println("1. Cambiar titulo");
                            System.out.println("2. Cambiar descripcion");
                            System.out.println("3. Cambiar prioridad");
                            System.out.println("4. Añadir responsable");
                            System.out.println("5. Eliminar responsable");
                            System.out.println("6. Añadir subtarea");
                            System.out.println("7. Eliminar subtarea");
                            System.out.println("8. Cambiar ubicacion");
                            System.out.println("0. Salir de modificacion de tarea Profesional");
                            opcion = sc.nextInt();

                            switch (opcion) {
                                case 1:
                                    System.out.println("Introduce nuevo titulo: ");
                                    nuevoTitulo = sc.next();
                                    tareaPersonal.setTitulo(nuevoTitulo);
                                    System.out.println("Titulo actualizado");
                                    break;
                                case 2:
                                    System.out.println("Introduce nueva descripcion: ");
                                    nuevaDescripcion = sc.next();
                                    tareaPersonal.setDescripcion(nuevaDescripcion);
                                    System.out.println("Descripcion actualizada");
                                    break;
                                case 3:
                                    System.out.println("Introduce nueva prioridad: ");
                                    nuevaPrioridad = Prioridad.valueOf(sc.next().toUpperCase());
                                    tareaPersonal.setPrioridad(nuevaPrioridad);
                                    System.out.println("Prioridad actualizada");
                                    break;
                                case 4:
                                    System.out.println("Introduce dni: ");
                                    dni = sc.next();
                                    System.out.println("Introduce nombre: ");
                                    String nombre = sc.next();
                                    System.out.println("Introduce apellido: ");
                                    String apellido = sc.next();
                                    System.out.println("Introduce edad: ");
                                    int edad = sc.nextInt();
                                    tareaPersonal.asignarResponsable(new Persona(dni,nombre,apellido,edad));
                                    break;
                                case 5:
                                    System.out.println("Introduce el dni del responsable que quieres eliminar: ");
                                    dni = sc.next();
                                    tareaPersonal.eliminarResponsable(dni);
                                    break;
                                case 6:
                                    System.out.println("Introduce id de subtarea: ");
                                    idSubTarea = sc.nextInt();
                                    System.out.println("Introduce descripcion de subtarea: ");
                                    descripcionSubTarea = sc.next();
                                    tareaPersonal.agregarEncargo(new Encargo(idSubTarea,descripcionSubTarea));
                                    break;
                                case 7:
                                    System.out.println("Introduce el id de subtarea que quieres eliminar: ");
                                    idSubTarea = sc.nextInt();
                                    tareaPersonal.borrarEncargo(idSubTarea);
                                    break;
                                case 8:
                                    System.out.println("Introduce nuevo ubicacion: ");
                                    String nuevoUbicacion = sc.next();
                                    tareaPersonal.setUbicacion(nuevoUbicacion);
                                    break;
                                case 0:
                                    System.out.println("Saliedo de modificacion de la tarea personal...");
                                    break;

                            }

                        } while (opcion != 0);
                        break;


                    case 0:
                        System.out.println("Saliendo de la modificacion...");
                        break;
                }


            } while (opcionTarea != 0);

        } else {
            System.out.println("La tarea no esta o el id de la tarea introducido incorrecto");
        }
     }










    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

     public Prioridad getPrioridad() {
         return prioridad;
     }

     public void setPrioridad(Prioridad prioridad) {
         this.prioridad = prioridad;
     }

     @Override
    public String toString() {
        return "Tarea{\n" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prioritario=" + prioritario +
                ", completada=" + completada +
                ", prioridad=" + prioridad +
                ",\n encargados=" + Arrays.toString(encargados) +
                ",\n listaTareas=" + listaTareas +
                '}';
    }
}


