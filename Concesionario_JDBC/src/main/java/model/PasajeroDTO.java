package model;

import database.DBConector;

import java.sql.*;
import java.util.ArrayList;

public class PasajeroDTO {

    // 1) Insertar pasajero
    public void insertarPasajero(Pasajero pasajero) {
        String sql = "INSERT INTO pasajeros (nombre, edad, peso) VALUES (?, ?, ?)";
        try (Connection conn = DBConector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, pasajero.getNombre());
            stmt.setInt(2, pasajero.getEdad());
            stmt.setInt(3, pasajero.getPeso());
            stmt.executeUpdate();

            // opcional: recuperar el id auto-generado
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    pasajero.setId(rs.getInt(1));
                }
            }

            System.out.println("Pasajero insertado correctamente. ID = " + pasajero.getId());
        } catch (SQLException e) {
            System.err.println("Error al insertar pasajero: " + e.getMessage());
        }
    }

    // 2) Borrar pasajero por ID
    public void eliminarPasajero(int idPasajero) {
        String sql = "DELETE FROM pasajeros WHERE id = ?";
        try (Connection conn = DBConector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPasajero);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Pasajero eliminado correctamente.");
            } else {
                System.out.println("No existe pasajero con ID " + idPasajero);
            }
        } catch (SQLException e) {
            System.err.println("Error al borrar pasajero: " + e.getMessage());
        }
    }

    // 3) Consultar pasajero por ID
    public void consultarPasajero(int idPasajero) {
        String sql = "SELECT id, nombre, edad, peso, id_coche FROM pasajeros WHERE id = ?";
        try (Connection conn = DBConector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPasajero);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.printf("Pasajero encontrado: ID=%d, Nombre=%s, Edad=%d, Peso=%d, ID_Coche=%s%n",
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getInt("edad"),
                            rs.getInt("peso"),
                            rs.getObject("id_coche")); // null si no tiene coche
                } else {
                    System.out.println("No se encontró pasajero con ID " + idPasajero);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar pasajero: " + e.getMessage());
        }
    }

    // 4) Listar todos los pasajeros
    public void listarPasajeros() {
        String sql = "SELECT id, nombre, edad, peso, id_coche FROM pasajeros";
        try (Connection conn = DBConector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Listado de pasajeros:");
            while (rs.next()) {
                System.out.printf("ID=%d, Nombre=%s, Edad=%d, Peso=%d, ID_Coche=%s%n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getInt("peso"),
                        rs.getObject("id_coche"));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar pasajeros: " + e.getMessage());
        }
    }

    // 5) Asignar pasajero a coche
    public void asignarPasajeroACoche(int idPasajero, int idCoche) {
        String sql = "UPDATE pasajeros SET id_coche = ? WHERE id = ?";
        try (Connection conn = DBConector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCoche);
            stmt.setInt(2, idPasajero);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Pasajero ID=" + idPasajero + " asignado al coche ID=" + idCoche);
            } else {
                System.out.println("No se encontró pasajero con ID " + idPasajero);
            }
        } catch (SQLException e) {
            System.err.println("Error al asignar pasajero a coche: " + e.getMessage());
        }
    }

    // 6) Eliminar pasajero de un coche (puesta a null la FK)
    public void eliminarPasajeroDeCoche(int idPasajero) {
        String sql = "UPDATE pasajeros SET id_coche = NULL WHERE id = ?";
        try (Connection conn = DBConector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPasajero);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Pasajero ID=" + idPasajero + " desvinculado de su coche.");
            } else {
                System.out.println("No se encontró pasajero con ID " + idPasajero);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar pasajero de coche: " + e.getMessage());
        }
    }

    // 7) Listar pasajeros de un coche
    public void listarPasajerosDeCoche(int idCoche) {
        String sql = "SELECT id, nombre, edad, peso FROM pasajeros WHERE id_coche = ?";
        try (Connection conn = DBConector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCoche);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("Pasajeros asignados al coche ID=" + idCoche + ":");
                boolean alguno = false;
                while (rs.next()) {
                    alguno = true;
                    System.out.printf("ID=%d, Nombre=%s, Edad=%d, Peso=%d%n",
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getInt("edad"),
                            rs.getInt("peso"));
                }
                if (!alguno) {
                    System.out.println("– Ningún pasajero encontrado para ese coche.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar pasajeros de coche: " + e.getMessage());
        }
    }
}
