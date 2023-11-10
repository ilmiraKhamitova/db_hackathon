package itis.hackathon.team5.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtil {
    public static final String URL = "jdbc:postgresql://localhost:5432/hackathon";
    public static final String USER = "test";
    public static final String PASSWORD = "qwerty12345";
    public static final String DRIVER = "org.postgresql.Driver";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
