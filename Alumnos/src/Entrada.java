import model.Alumno;
import model.Asignatura;
import model.Profesor;

import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {

        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        asignaturas.add(new Asignatura(1));
        asignaturas.add(new Asignatura(2));
        asignaturas.add(new Asignatura(3));

        /*
        Asignatura progrmacion = new Asignatura(1);
        Asignatura sistemas = new Asignatura(2);
        Asignatura lenguaje = new Asignatura(3);
         */

        // Alumno Olek = new Alumno(progrmacion,sistemas,lenguaje); -> incorrecto

        //Alumno Olek = new Alumno(1,2,3);

        Alumno Olek = new Alumno(asignaturas.get(0).getIdentificador(),asignaturas.get(1).getIdentificador(),asignaturas.get(2).getIdentificador());
        Profesor profesor = new Profesor();
        profesor.ponerNotas(Olek);

        System.out.println("La nota de la asignatura programacion es "+Olek.getAsignatura1().getCalificacion());
        System.out.println("La nota de la asignatura sistemas es "+Olek.getAsignatura2().getCalificacion());
        System.out.println("La nota de la asignatura lenguaje es "+Olek.getAsignatura3().getCalificacion());
        System.out.println("La media del alumno es "+profesor.calcularMedia(Olek));
    }
}
