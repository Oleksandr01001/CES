package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/tienda";
    private static final String USER = "root";
    private  static final String PASSWORD = "";
    private static Connection connection;


    public DBConnector() {
    }

    public static Connection getConnection() {
        if(connection == null ) {
            createConnection();
        }
        return connection;
    }

    public static void createConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda","root","M1h5o0n4_");
            System.out.println("Connectado");
        } catch (SQLException e) {
            System.out.println("Se ha prodecido un error en coneccion");
        }

    }
}
