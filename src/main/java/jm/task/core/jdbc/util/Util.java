package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/example_schema";
    private static final String USER = "root";
    private static final String PASSWORD = "Gun452000";

    private static Connection connection;

    private Util() {
        throw new UnsupportedOperationException("Util class cannot be instantiated");
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (Util.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(URL, USER, PASSWORD);
                        System.out.println("Connection established.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Failed to establish database connection.", e);
                    }
                }
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}