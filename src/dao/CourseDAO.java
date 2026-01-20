package dao;

import java.sql.*;
import model.Course;
import util.DBConnection;

public class CourseDAO {
    // Add course

    public void addCourse(Course course) {
        String sql = "insert into courses(course_name, duration) values (?, ?)";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getDuration());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Course added Successfully");
            } else {
                System.out.println("Failed to add course");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllCourses() {

        String query = "SELECT * FROM courses";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("\nID | COURSE NAME   |   DURATION");
            System.out.println("-----------------------------------");

            while (rs.next()) {

                int id = rs.getInt("course_id");
                String courseName = rs.getString("course_name");
                String duration = rs.getString("duration");
                // String course = rs.getString("course");

                System.out.println(id + " | " + courseName + " | " + duration + " | ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void assignStudentToCourse(int studentId, int courseId) {
        String sql = "insert into student_course (student_id, course_id) values (?, ?)";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ps.executeUpdate();
            System.out.println("Student Assigned to course Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewStudentsPerCourse(int courseId) {
        String sql = """
                select s.student_id, s.name, s.email
                from students s
                join student_course sc
                on s.student_id = sc.student_id
                where sc.course_id =?
                """;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, courseId);

            ResultSet rs = ps.executeQuery();

            System.out.println("Students in course ID " + courseId);
            while (rs.next()) {
                System.out.println(
                        rs.getInt("student_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
