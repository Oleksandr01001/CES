package model;

import database.DBConector;
import database.SchemaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesorDTO {
    public void insertarProfesor(Profesor profesor){
        String query  = String.format("INSERT INTO %s (%s,%s,%s) VALUES (?,?,?)",
                SchemaDB.TAB_PROFESORES,
                SchemaDB.COL_NOMBRE,
                SchemaDB.COL_DNI,
                SchemaDB.COL_SALARIO
                );


        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement stmt  = connection.prepareStatement(query);

            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getDni());
            stmt.setInt(3,profesor.getSalarioAnual());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void mostrarDatos(){
        String query  = String.format("SELECT * FROM %s",
                SchemaDB.TAB_PROFESORES
                );


        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
