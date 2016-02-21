package record;

import json.get.HomeworkJson;
import json.get.HomeworkReplyJson;
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

    /**
     * This method returns an object with information for a single homework assignment.
     *
     * @param homeworkId
     * @return
     * @throws SQLException
     */

    public static String getHomeworkModels(String homeworkId) throws SQLException {
        final String sqlString = "SELECT assignment, date_due, course_name " +
                "FROM public.homework WHERE homework_id =?";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlString)) {
            preparedStatement.setString(1, homeworkId);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                HomeworkJson homeworkJson = new HomeworkJson();

                homeworkJson.setAssignment(result.getString(1));
                homeworkJson.setDateDue(result.getString(2));
                homeworkJson.setCourseName(result.getString(3));

                return homeworkJson.toJson();
            }

        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return null;
    }

    /**
     * @param hrId
     * @return homeworkReplyJson.toJson()
     * @throws SQLException
     */

    public static String getHomeworkReplyModels(String hrId) throws SQLException {
        final String sqlString = "SELECT comment_content, comment_time, first_name, last_name, status, score, homework " +
                "FROM public.homework_reply WHERE hr_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlString)) {
            preparedStatement.setString(1, hrId);


            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                HomeworkReplyJson homeworkReplyJson = new HomeworkReplyJson();

                homeworkReplyJson.setCommentContent(result.getString(1));
                homeworkReplyJson.setCommentTime(result.getString(2));
                homeworkReplyJson.setFirstName(result.getString(3));
                homeworkReplyJson.setLastName(result.getString(4));
                homeworkReplyJson.setStatus(result.getBoolean(5));
                homeworkReplyJson.setScore(result.getInt(6));
                homeworkReplyJson.setHomework(result.getString(7));

                return homeworkReplyJson.toJson();
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return null;
    }

    /**
     * @param courseId
     * @return ArrayList of HomeworkJson objects.
     * @throws SQLException
     */

    public static ArrayList<HomeworkJson> getHomeworkOfCourseModel(String courseId) throws SQLException {
        final String sqlString = "SELECT assignment, date_due, course_name " +
                "FROM public.homework_course WHERE course_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlString)) {
            preparedStatement.setString(1, courseId);

            ResultSet result = preparedStatement.executeQuery();
            ArrayList<HomeworkJson> arrayList = new ArrayList<HomeworkJson>();

            while (result.next()) {
                HomeworkJson homeworkJson = new HomeworkJson();
                homeworkJson.setAssignment(result.getString(1));
                homeworkJson.setDateDue(result.getString(2));
                homeworkJson.setCourseName(result.getString(3));

                arrayList.add(homeworkJson);
            }
            return arrayList;

        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return null;
    }
}