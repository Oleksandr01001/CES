package model;

import database.DBConector;
import database.SchemaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CocheDTO {

    public void insertarCoche(Coche coche){
        String query = "INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?)";
        String queryFormateada = String.format(query,
                SchemaDB.TAB_COCHES,
                SchemaDB.COL_ID_COCHE,
                SchemaDB.COL_MARCA,
                SchemaDB.COL_COLOR,
                SchemaDB.COL_MODELO,
                SchemaDB.COL_MATRICULA,
                SchemaDB.COL_PRECIO
        );

        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(queryFormateada);

            preparedStatement.setInt(1, coche.getId());
            preparedStatement.setString(2, coche.getMarca());
            preparedStatement.setString(3, coche.getColor());
            preparedStatement.setString(4, coche.getModelo());
            preparedStatement.setString(5, coche.getMatricula());
            preparedStatement.setInt(6, coche.getPrecio());

            preparedStatement.executeUpdate();
            System.out.println("Coche insertado correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al insertar el coche: " + e.getMessage());
        }
    }


    public boolean getCocheMatricula(String matricula) {
        String query = String.format("SELECT * FROM %s WHERE %s = ?",
                SchemaDB.TAB_COCHES,
                SchemaDB.COL_MATRICULA
        );

        try (Connection connection = DBConector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, matricula);
            return preparedStatement.executeQuery().next();

        } catch (SQLException e) {
            System.err.println("Error al comprobar matrícula: " + e.getMessage());
        }

        return false;
    }

    public void eliminarCoche(int id) {
        String query = String.format("DELETE FROM %s WHERE %s = ?",
                SchemaDB.TAB_COCHES,
                SchemaDB.COL_ID_COCHE
        );

        try (Connection conn = DBConector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Coche eliminado de la base de datos.");
            } else {
                System.out.println("No se encontró ningún coche con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el coche: " + e.getMessage());
        }
    }


}
