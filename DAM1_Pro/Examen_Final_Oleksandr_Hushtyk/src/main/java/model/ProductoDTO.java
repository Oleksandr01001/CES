package model;

import database.DBConnector;
import database.SchemaDB;

import java.sql.*;

public class ProductoDTO {





    public void crear(Producto p) {
        Connection connection = DBConnector.getConnection();

        String sql = "INSERT INTO productos(id,nombre,precio,cantidad) VALUES (?,?,?,?)";
        try (
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getCantidad());
            ps.execute();


        } catch (SQLException e) {
            throw new RuntimeException("Error al crear producto", e);
        }
    }


    public Producto leer(int id) {
        String sql = "SELECT * FROM productos WHERE id = ?";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Producto(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getInt("cantidad")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al leer producto", e);
        }
        return null;
    }


    public boolean actualizar(Producto p) {
        String sql = "UPDATE productos SET nombre=?, precio=?, cantidad=? WHERE id=?";
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getCantidad());
            ps.setInt(4, p.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar producto", e);
        }
    }


    public boolean eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar producto", e);
        }
    }



}
