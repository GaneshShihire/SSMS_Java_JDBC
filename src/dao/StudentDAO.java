package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Student;
import util.DBConnection;

public class StudentDAO {

    public boolean addStudent(Student student) {
        boolean isInserted = false;

        String sql = "insert into students (name, email, course) values (?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                isInserted = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isInserted;
    }

    public void getAllStudents() {

        String query = "SELECT * FROM students";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("\nID | NAME | EMAIL | COURSE");
            System.out.println("-----------------------------------");

            while (rs.next()) {

                int id = rs.getInt("student_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String course = rs.getString("course");

                System.out.println(id + " | " + name + " | " + email + " | " + course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int student_id, String name, String email, String course) {

        try {
            Connection conn = DBConnection.getConnection();

            String query = "update students set name=?, email=?, course=? where student_id=?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.setInt(4, student_id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Updated Successfully");
            } else {
                System.out.println("Student not exists !!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int student_id) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "delete from students where student_id=?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, student_id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Deleted Successfully");
            } else {
                System.out.println("Student not exist");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getStudentById(int student_id) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "Select * from students where student_id=?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, student_id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n📍 Student Found");
                System.out.println("ID     : " + rs.getInt("student_id"));
                System.out.println("Name   : " + rs.getString("name"));
                System.out.println("Email  : " + rs.getString("email"));
                System.out.println("Course : " + rs.getString("course"));
            } else {
                System.out.println("⚠ Student not found with ID: " + student_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
