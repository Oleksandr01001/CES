package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConector {
    private static final String URL = "jdbc:mysql://localhost:3306/pruebaT3";
    private static final String USER = "root";
    private static final String PASSWORD = "Artur190905";

    private static Connection connection;

    public static Connection getConnection(){
        if (connection == null || isClosed() ){
            createConnection();
        }
        return connection;
    }

    private static void createConnection(){
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isClosed() {
        try {
            return connection == null || connection.isClosed();
        } catch(SQLException e){
            return true;
        }
    }

}
