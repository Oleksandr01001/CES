package model;

import database.DBConector;
import database.SchemaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrabajadoresDTO {
    public void insertarUsuarios(Trabajadores trabajadores){
        String query = String.format("INSERT INTO %s (%s,%s,%s,%s,%s,%s) VALUES (?,?,?,?,?,?)",
                SchemaDB.TAB_TRABAJADORES,
                SchemaDB.COL_ID_USUARIO,
                SchemaDB.COL_NOMBRE,
                SchemaDB.COL_CARGO,
                SchemaDB.COL_SALARIO,
                SchemaDB.COL_CORREO,
                SchemaDB.COL_PASSWORD
                );


        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setInt(1,trabajadores.getId());
            stmt.setString(2,trabajadores.getNombre());
            stmt.setString(3,trabajadores.getCargo());
            stmt.setInt(4,trabajadores.getSalario());
            stmt.setString(5,trabajadores.getCorreo());
            stmt.setString(6,trabajadores.getPassword());

            stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean getUsuario(String usuario){
        String query = String.format("SELECT * FROM %s WHERE %s = ?",
                SchemaDB.TAB_TRABAJADORES,
                SchemaDB.COL_NOMBRE
                );
        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1,usuario);
            return stmt.executeQuery().next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
