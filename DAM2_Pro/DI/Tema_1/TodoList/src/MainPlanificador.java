import model.*;

import java.util.Date;
import java.util.Scanner;

public class MainPlanificador {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Tarea tarea = new Tarea() {};



        int id, numPersonas, cantidadSubTareas, idSubTarea;
        String titulo, descripcion, descripcionSubTarea;
        boolean prioritario;
        Prioridad prioridad;








        int opcion;
        int opcionTarea;
        int opcionResponsables;
        int opcionSubTarea;


        do {
            System.out.println("Elige la opcion: ");
            System.out.println("1.Registrar una tarea");
            System.out.println("2.Modificar tarea");
            System.out.println("3.Listar tareas");
            System.out.println("4.Completar tarea");
            System.out.println("5.Listar completas");
            System.out.println("6.Listar incompletas");
            System.out.println("0.Salir de la aplicacion...");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Que tarea quieres registrar?");
                    System.out.println("Elige la opcion: ");
                    System.out.println("1.Tarea Profesional");
                    System.out.println("2.Tarea Personal");
                    opcionTarea = sc.nextInt();
                    switch (opcionTarea) {
                        case 1:
                            System.out.println("Introduce ID: ");
                            id = sc.nextInt();
                            System.out.println("Introduce titulo: ");
                            titulo = sc.next();
                            System.out.println("Introduce descripcion: ");
                            descripcion = sc.next();
                            System.out.println("Introduce si es prioritario (True, False): ");
                            prioritario = sc.nextBoolean();
                            System.out.println("Introduce numero personas: ");
                            numPersonas = sc.nextInt();
                            System.out.println("Introduce prioridad (BAJA, MEDIA, ALTA): ");
                            prioridad = Prioridad.valueOf(sc.next().toUpperCase());
                            System.out.println("Introduce presupuesto: ");
                            int presupuesto = sc.nextInt();
                            //System.out.println("Introduce fecha limite: ");
                            Date date = new Date();



                            TareaProfesional tareaProfesional = new
                                    TareaProfesional(id,titulo,descripcion,prioritario,numPersonas,prioridad,presupuesto,date);
                            tarea.agregarTarea(tareaProfesional);


                            System.out.println("Quiere añadir responsables ahora? (1.Si/2.No): ");
                            opcionResponsables = sc.nextInt();

                            switch (opcionResponsables) {
                                case 1:
                                    for (int i = 0; i < numPersonas; i++) {
                                        System.out.println("Introduce dni: ");
                                        String dni = sc.next();
                                        System.out.println("Introduce nombre: ");
                                        String nombre = sc.next();
                                        System.out.println("Introduce apellido: ");
                                        String apellido = sc.next();
                                        System.out.println("Introduce edad: ");
                                        int edad = sc.nextInt();
                                        tareaProfesional.asignarResponsable(new Persona(dni,nombre,apellido,edad));
                                    }
                                    break;
                                case 2:
                                    System.out.println("Los responsables se asignaran luego...");
                                    break;
                            }


                            System.out.println("Quieres añadir subtareas ahora? (1.Si/2.No): ");
                            opcionSubTarea = sc.nextInt();

                            switch (opcionSubTarea) {
                                case 1:
                                    System.out.println("Cuantos subtareas quieres añadir? ");
                                    cantidadSubTareas = sc.nextInt();

                                    for (int i = 0; i < cantidadSubTareas; i++) {
                                        System.out.println("Introduce id de subtarea: ");
                                        idSubTarea = sc.nextInt();
                                        System.out.println("Introduce descripcion de subtarea: ");
                                        descripcionSubTarea = sc.next();
                                        tarea.agregarEncargo(new Encargo(idSubTarea,descripcionSubTarea));
                                    }

                                    break;
                                case 2:
                                    System.out.println("Las subtareas se añadiran luego...");
                                    break;
                            }


                            break;
                        case 2:
                            System.out.println("Introduce ID: ");
                            id = sc.nextInt();
                            System.out.println("Introduce titulo: ");
                            titulo = sc.next();
                            System.out.println("Introduce descripcion: ");
                            descripcion = sc.next();
                            System.out.println("Introduce si es prioritario (True, False): ");
                            prioritario = sc.nextBoolean();
                            System.out.println("Introduce numero personas: ");
                            numPersonas = sc.nextInt();
                            System.out.println("Introduce prioridad (BAJA, MEDIA, ALTA): ");
                            prioridad = Prioridad.valueOf(sc.next().toUpperCase());
                            System.out.println("Introduce ubicacion: ");
                            String ubicacion = sc.next();

                            TareaPersonal tareaPersonal = new
                                    TareaPersonal(id,titulo,descripcion,prioritario,numPersonas,prioridad,ubicacion);
                            tarea.agregarTarea(tareaPersonal);



                            System.out.println("Quiere añadir responsables ahora? (1.Si/2.No): ");
                            opcionResponsables = sc.nextInt();

                            switch (opcionResponsables) {
                                case 1:
                                    for (int i = 0; i < numPersonas; i++) {
                                        System.out.println("Introduce dni: ");
                                        String dni = sc.next();
                                        System.out.println("Introduce nombre: ");
                                        String nombre = sc.next();
                                        System.out.println("Introduce apellido: ");
                                        String apellido = sc.next();
                                        System.out.println("Introduce edad: ");
                                        int edad = sc.nextInt();
                                        tareaPersonal.asignarResponsable(new Persona(dni,nombre,apellido,edad));
                                    }
                                    break;
                                case 2:
                                    System.out.println("Los responsables se asignaran luego...");
                                    break;
                            }


                            System.out.println("Quieres añadir subtareas ahora? (1.Si/2.No): ");
                            opcionSubTarea = sc.nextInt();

                            switch (opcionSubTarea) {
                                case 1:
                                    System.out.println("Cuantos subtareas quieres añadir? ");
                                    cantidadSubTareas = sc.nextInt();

                                    for (int i = 0; i < cantidadSubTareas; i++) {
                                        System.out.println("Introduce id de subtarea: ");
                                        idSubTarea = sc.nextInt();
                                        System.out.println("Introduce descripcion de subtarea: ");
                                        descripcionSubTarea = sc.next();
                                        tarea.agregarEncargo(new Encargo(idSubTarea,descripcionSubTarea));
                                    }
                                    break;
                                case 2:
                                    System.out.println("Las subtareas se añadiran luego...");
                                    break;
                            }

                            break;
                    }
                    break;
                case 2:
                    System.out.println("Introduce id de la tarea que quieres modificar: ");
                    int iD = sc.nextInt();
                    tarea.modificarTarea(iD);
                    break;
                case 3:
                    tarea.listarTareas();
                    break;
                case 4:
                    tarea.completarTarea();
                    break;
                case 5:
                    tarea.listarTareasCompletadas();
                    break;
                case 6:
                    tarea.listarTareasNoCompletadas();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
            }
        } while (opcion != 0);
    }
}
