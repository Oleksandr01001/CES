package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SchemaDB {

    public static void createSchema() {
        String sql = "CREATE TABLE IF NOT EXISTS facturas (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "numero_factura VARCHAR(50), " +
                "nombre VARCHAR(100), " +
                "direccion TEXT, " +
                "email VARCHAR(100), " +
                "productos TEXT, " +
                "precio DOUBLE" +
                ");";

        try (Connection conn = DBConnector.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla ya esta creada");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
