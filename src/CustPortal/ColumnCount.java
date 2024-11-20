package CustPortal;

import java.sql.*;

public class ColumnCount {
    static int rowCount;

    public static void main(String[] args) {
        String databaseURL = "jdbc:mysql://localhost:3306/CustPortal"; // Replace with your database URL
        String username = "root"; // Replace with your database username
        String password = "Anaklusmos"; // Replace with your database password
        String tableName = "custcomp"; // Replace with the name of the table

         rowCount = 0;

        try (Connection connection = DriverManager.getConnection(databaseURL, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM " + tableName)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                rowCount = resultSet.getInt(1); // Retrieve the count from the first column
            }
            System.out.println("Total number of rows in the table: " + (rowCount));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}