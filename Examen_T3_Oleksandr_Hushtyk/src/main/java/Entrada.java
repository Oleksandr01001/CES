import controller.CentroFormacion;
import database.DBConnector;
import model.ProfesorDTO;
import model.ProfesorInterno;

public class Entrada {

    public static void main(String[] args) {


        ProfesorDTO profesorDTO = new ProfesorDTO();

        //profesorDTO.insertarProfesor(new ProfesorInterno("Olek","123456789L",1200,300));

        CentroFormacion centroFormacion = new CentroFormacion();
        centroFormacion.mostrarDatos();
    }
}
