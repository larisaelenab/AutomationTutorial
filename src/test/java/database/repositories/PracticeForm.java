package database.repositories;

import database.DatabaseConnection;
import objectData.PracticeFormObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PracticeForm {

    public static void insertEntry(PracticeFormObject dataObject) {
        Connection connection = DatabaseConnection.getConnection(); // Get the database connection

        String insertQuery = "INSERT INTO PracticeForm (firstNameValue, lastNameValue, emailValue, genderValue, userNumberValue, chooseDayValue, subjectValue, activitatiValue, terminatiePath, userAddressValue, stateinputValue, cityinputValue) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set parameters for the query
            preparedStatement.setString(1, dataObject.getFirstNameValue());
            preparedStatement.setString(2, dataObject.getLastNameValue());
            preparedStatement.setString(3, dataObject.getEmailValue());
            preparedStatement.setString(4, dataObject.getGenderValue());
            preparedStatement.setString(5, dataObject.getUserNumberValue());
            preparedStatement.setString(6, dataObject.getChooseDayValue());
            preparedStatement.setString(7, dataObject.getSubjectValue());
            preparedStatement.setString(8, String.join(", ", dataObject.getActivitatiValue())); // Convert List<String> to comma-separated String
            preparedStatement.setString(9, dataObject.getTerminatiePath());
            preparedStatement.setString(10, dataObject.getUserAddressValue());
            preparedStatement.setString(11, dataObject.getStateinputValue());
            preparedStatement.setString(12, dataObject.getCityinputValue());

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("A new entry was successfully inserted into PracticeForm.");
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
