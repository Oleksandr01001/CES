package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/p_facturas";   // ← твоя БД
    private static final String USER = "root";                                  // ← твій юзер
    private static final String PASSWORD = "M1h5o0n4_";                                  // ← твій пароль (або "")

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
