package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "student_management_system";
    private static final String USER = "root";
    private static final String PASSWORD = "MyNewPass";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL + DATABASE_NAME, USER, PASSWORD);
    }

    public static void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Create the database if it does not exist
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME);

            // Switch to the database
            statement.executeUpdate("USE " + DATABASE_NAME);

            // Create the 'students' table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "name VARCHAR(255),"
                    + "age INT,"
                    + "grade VARCHAR(10))";
            statement.executeUpdate(createTableSQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}