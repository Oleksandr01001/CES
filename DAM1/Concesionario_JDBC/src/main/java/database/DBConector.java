//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConector {
    private static final String URL = "jdbc:mysql://localhost:3306/pasajeros";
    private static final String USER = "root";
    private static final String PASSWORD = "Artur190905";
    private static Connection connection;

    public DBConector() {
    }

    public static Connection getConnection() {
        if (connection == null || isClosed()) {
            createConnection();
        }

        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pasajeros", "root", "M1h5o0n4_");
            System.out.println("Conexión establecida con éxito.");
        } catch (SQLException var1) {
            SQLException e = var1;
            System.out.println("Error al establecer la conexión con la base de datos:");
            System.out.println(e.getMessage());
        }

    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException var1) {
                SQLException e = var1;
                System.out.println("Error al cerrar la conexión:");
                System.out.println(e.getMessage());
            }
        }

    }

    private static boolean isClosed() {
        try {
            return connection == null || connection.isClosed();
        } catch (SQLException var1) {
            return true;
        }
    }
}
