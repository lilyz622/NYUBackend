package record;

import json.get.HomeworkJson;
import json.get.UserJson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecordGetter extends Record {
    public static String getUserModels(String userId) throws SQLException {
        final String sqlString = "SELECT first_name, last_name, age, grade_level, major, school_name " +
                "FROM public.user WHERE user_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlString)) {
            preparedStatement.setString(1, userId);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                UserJson userJson = new UserJson();

                userJson.setFirstName(result.getString(1));
                userJson.setLastName(result.getString(2));
                userJson.setAge(result.getInt(3));
                userJson.setGradeLevel(result.getInt(4));
                userJson.setMajor(result.getString(5));
                userJson.setSchoolName(result.getString(6));

                return userJson.toJson();
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return null;
    }


    /*
    public static String getHomeworkModels(String homeworkId) throws SQLException {

        final String sqlString = "SELECT assignment, date_due, course_name" + "FROM public.homework WHERE homework_id =?";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlString)) {
            preparedStatement.setString(1, homeworkId);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                HomeworkJson messageJson = new HomeworkJson();

                messageJson.setAssignment(result.getString(1));
                messageJson.setDateDue(result.getString(2));
                messageJson.setCourseName(result.getString(3));

                return messageJson.toJson();
            }

        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return null;
    }
    */

}