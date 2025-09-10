package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public Connection getConnection() {

        if(connection == null) {
            createConnection();
        }
        return connection;
    }

    private void createConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumnos","root","");
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar");
        }
    }
}
