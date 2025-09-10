package model;

import database.DBConector;
import database.SchemaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacturaDTO {
    public void insertarFactura(Factura factura){
        String query = "INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?)" ;
        String queryFormateada = String.format(query,
                SchemaDB.TAB_FACTURAS,
                SchemaDB.COL_NUMERO,
                SchemaDB.COL_NOMBRE,
                SchemaDB.COL_DIRECCION,
                SchemaDB.COL_EMAIL,
                SchemaDB.COL_PRODUCTOS,
                SchemaDB.COL_PRECIO
        );

        try (Connection conn = DBConector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queryFormateada)) {

            stmt.setString(1, factura.getNumero());
            stmt.setString(2, factura.getNombre());
            stmt.setString(3, factura.getDireccion());
            stmt.setString(4, factura.getEmail());
            stmt.setString(5, factura.getProductos());
            stmt.setDouble(6, factura.getPrecio());


            stmt.executeUpdate();
            System.out.println("Orden insertada correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al insertar orden: " + e.getMessage());
        }



    }
}
