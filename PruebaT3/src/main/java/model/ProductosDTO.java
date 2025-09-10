package model;

import database.DBConector;
import database.SchemaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductosDTO {
    public void insertarProducto(Productos productos){
        String query = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)",
                SchemaDB.TAB_PRODUCTOS,
                SchemaDB.COL_ID_PRODUCTO,
                SchemaDB.COL_NOMBRE_PRODUCTO,
                SchemaDB.COL_PRECIO,
                SchemaDB.COL_CANTIDAD
                );

        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setInt(1,productos.getId());
            stmt.setString(2,productos.getNombreProducto());
            stmt.setInt(3,productos.getPrecio());
            stmt.setInt(4,productos.getCantidadStock());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean getNombreProducto(String nombre){
        String query = String.format("SELECT * FROM %s WHERE %s = ?",
                SchemaDB.TAB_PRODUCTOS,
                SchemaDB.COL_NOMBRE_PRODUCTO
                );

        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1,nombre);
            return stmt.executeQuery().next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void actualizarPrecio(String nombre, int nuevoPrecio){
        String query = String.format("UPDATE %s SET %s = ? WHERE %s = ?",
                SchemaDB.TAB_PRODUCTOS,
                SchemaDB.COL_PRECIO,
                SchemaDB.COL_NOMBRE_PRODUCTO
                );

        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setInt(1,nuevoPrecio);
            stmt.setString(2,nombre);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Precio actualizado correctamente.");
            } else {
                System.out.println("Producto no encontrado.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void mostrarStock(int cantidad){
        String query = String.format("SELECT * FROM %s WHERE %s <= ?",
                SchemaDB.TAB_PRODUCTOS,
                SchemaDB.COL_CANTIDAD
        );
        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setInt(1,cantidad);

            var rs = stmt.executeQuery();
            System.out.println("Productos con stock menor o igual a "+ cantidad+ ": ");
            while (rs.next()){
                int id = rs.getInt(SchemaDB.COL_ID_PRODUCTO);
                String nombre = rs.getString(SchemaDB.COL_NOMBRE_PRODUCTO);
                int precio = rs.getInt(SchemaDB.COL_PRECIO);
                int stock = rs.getInt(SchemaDB.COL_CANTIDAD);

                System.out.printf("ID: %d | Nombre: %s | Precio: %d | Stock: %d\n", id, nombre, precio, stock);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void eliminarProducto(int id){
        String query = String.format("DELETE FROM %s WHERE %s <= ?",
                SchemaDB.TAB_PRODUCTOS,
                SchemaDB.COL_ID_PRODUCTO
        );
        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setInt(1,id);

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas>0){
                System.out.println("Producto eliminado");
            } else {
                System.out.println("No se encontro un producto con ese ID");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
