import model.Persona;
import model.Tarea;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Tarea tarea = new Tarea("Practica DI",
                "Esta practica de DI es hacer un programa todolist",
                true,
                4);



        tarea.asignarPersona (new Persona("Nombre","apellido","123a",15));
        tarea.asignarPersona (new Persona("Nombre","apellido","123b",15));
        tarea.asignarPersona (new Persona("Nombre","apellido","123c",15));



        tarea.eliminarResponsable("123b");
        tarea.listarResponsables();

    }

}
