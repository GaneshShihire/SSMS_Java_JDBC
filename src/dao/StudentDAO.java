package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Student;
import util.DBConnection;


public class StudentDAO {
    
    public boolean addStudent(Student student){
        boolean isInserted = false;

        String sql = "insert into students (name, email, course) values (?, ?, ?)";

        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,  student.getName());
            ps.setString(2,  student.getEmail());
            ps.setString(3,  student.getCourse());

            int rows = ps.executeUpdate();

            if(rows > 0){
                isInserted = true;
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        return isInserted;
    }
}
