package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/profesores";
    private static final String USER = "root";
    private static final String PASSWORD = "M1h5o0n4_";

    private static Connection connection;


    public static Connection getConnection() {
        if (connection == null || isClosed()) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connection");
        }
    }

    private static boolean isClosed() {
        try {
            return connection == null || connection.isClosed();
        } catch (SQLException e) {
            return true;
        }
    }



}
