package database.repositories;

import database.DatabaseConnection;
import objectData.WebTableObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WebTable {

    public static void insertEntry(WebTableObject dataObject) {
        Connection connection = DatabaseConnection.getConnection(); // Get the database connection

        String insertQuery = "INSERT INTO WebTable (firstNameValue, lastNameValue, emailValue, ageValue, salaryValue, departmentValue, editsalaryValue, editdepartmentValue) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set parameters for the query
            preparedStatement.setString(1, dataObject.getFirstNameValue());
            preparedStatement.setString(2, dataObject.getLastNameValue());
            preparedStatement.setString(3, dataObject.getEmailValue());
            preparedStatement.setInt(4, Integer.parseInt(dataObject.getAgeValue()));
            preparedStatement.setLong(5, Long.parseLong(dataObject.getSalaryValue()));
            preparedStatement.setString(6, dataObject.getDepartmentValue());
            preparedStatement.setLong(7, Long.parseLong(dataObject.getEditsalaryValue()));
            preparedStatement.setString(8, dataObject.getEditdepartmentValue());

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("A new entry was successfully inserted into WebTable.");
            }

        } catch (SQLException e) {
            System.out.println("Error while inserting data: " + e.getMessage());
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
