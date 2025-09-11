package model;

import database.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacturaDTO {

    public void insertarFactura(Factura factura) {
        String query = "INSERT INTO facturas (numeroFactura, nombre, direccion, email, productos, precio) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, factura.getNumeroFactura());
            pstmt.setString(2, factura.getNombre());
            pstmt.setString(3, factura.getDireccion());
            pstmt.setString(4, factura.getEmail());
            pstmt.setString(5, factura.getProductos());
            pstmt.setDouble(6, factura.getPrecio());

            pstmt.executeUpdate();
            System.out.println("Factura añadida correctamente");

        } catch (SQLException e) {
            System.err.println("Error al insertar la factura: " + e.getMessage());
        }
    }
}
