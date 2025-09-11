package model;

import database.DBConector;
import database.SchemaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasajeroDTO {
    public void insertarPasajero(Pasajero pasajero){
        String query = "INSERT INTO %s (%s, %s, %s, %s,%s) VALUES (?, ?, ?, ?, ?)";
        String queryFormateda = String.format(query,
                SchemaDB.TAB_PASAJEROS,
                SchemaDB.COL_ID_PASAJERO,
                SchemaDB.COL_NOMBRE,
                SchemaDB.COL_EDAD,
                SchemaDB.COL_PESO,
                SchemaDB.COL_ID_COCHE_REFERENCE
        );

        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(queryFormateda);

            preparedStatement.setInt(1, pasajero.getId());
            preparedStatement.setString(2, pasajero.getNombre());
            preparedStatement.setInt(3, pasajero.getEdad());
            preparedStatement.setInt(4, pasajero.getPeso());
            preparedStatement.setInt(5,pasajero.getId_coche());

            preparedStatement.executeUpdate();
            System.out.println("Orden insertada correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al insertar orden: " + e.getMessage());
        }
    }
    public boolean getPasajeroID(int id){
        String query = String.format("SELECT * FROM %s WHERE %s = ?",
                SchemaDB.TAB_PASAJEROS,
                SchemaDB.COL_ID_PASAJERO
        );


        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement stmt  = connection.prepareStatement(query);

            stmt.setInt(1,id);

            return stmt.executeQuery().next();
        } catch (SQLException e) {
            System.out.println("Error al comprobar ID"+ e.getMessage());
        }

        return false;

    }
    public void eliminarPasajero(int id){
        String query = String.format("DELETE FROM %s WHERE %s = ?",
                SchemaDB.TAB_PASAJEROS,
                SchemaDB.COL_ID_PASAJERO
                );


        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement stmt  = connection.prepareStatement(query);

            stmt.setInt(1,id);
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Pasajero eliminado de la base de datos.");
            } else {
                System.out.println("No se encontró ningún pasajero con ese ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el pasajero");
        }
    }
    public void agregarPasajeroACoche(int idPasajero,int idCoche){
        String query  = String.format("UPDATE %s SET %s = ? WHERE %s = ?",
                SchemaDB.TAB_PASAJEROS,
                SchemaDB.COL_ID_COCHE_REFERENCE,
                SchemaDB.COL_ID_PASAJERO
                );

        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement stmt  = connection.prepareStatement(query);

            stmt.setInt(1,idCoche);
            stmt.setInt(2,idPasajero);
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Pasajero asignado correctamente al coche.");
            } else {
                System.out.println("No se encontró ningún pasajero con ese ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error al asignar pasajero al coche: " + e.getMessage());
        }

    }
    public void eliminarPasajeroDeCoche(int idPasajero, int idCoche) {
        String query = String.format("UPDATE %s SET %s = NULL WHERE %s = ? AND %s = ?",
                SchemaDB.TAB_PASAJEROS,
                SchemaDB.COL_ID_COCHE_REFERENCE,
                SchemaDB.COL_ID_PASAJERO,
                SchemaDB.COL_ID_COCHE_REFERENCE
        );

        try (Connection connection = DBConector.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, idPasajero);
            stmt.setInt(2, idCoche);

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Pasajero eliminado correctamente del coche.");
            } else {
                System.out.println("No se encontró ningún pasajero con ese ID asociado al coche indicado.");
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar pasajero del coche: " + e.getMessage());
        }
    }

    public void mostrarPasajerosDeCoche(int idCoche){
        String query = String.format("SELECT * FROM %s WHERE %s = ?",
                SchemaDB.TAB_PASAJEROS,
                SchemaDB.COL_ID_COCHE_REFERENCE
        );


        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setInt(1,idCoche);

            ResultSet rs = stmt.executeQuery();
            boolean hayPasajeros = false;

            while (rs.next()){
                hayPasajeros = true;
                int id = rs.getInt(SchemaDB.COL_ID_PASAJERO);
                String nombre = rs.getString(SchemaDB.COL_NOMBRE);
                int edad = rs.getInt(SchemaDB.COL_EDAD);
                int peso = rs.getInt(SchemaDB.COL_PESO);

                System.out.printf("ID: %d | Nombre: %s | Edad: %d | Peso: %dkg\n", id, nombre, edad, peso);
            }
            if (!hayPasajeros){
                System.out.println("No hay pasajeros asignados a este coche");
            }

        } catch (SQLException e) {
            System.out.println("Erro al obtener pasajeros de coche"+ e.getMessage());
        }
    }



}
