package main;

//import java.sql.Connection;

import dao.StudentDAO;
import model.Student;
//import util.DBConnection;

public class SSMSApp {
    public static void main(String[] args) {

        Student student = new Student(

                "Ganesh",
                "ganesh@gmail.com",
                "Java FullStack");

        StudentDAO dao = new StudentDAO();
        boolean result = dao.addStudent(student);

        if (result) {
            System.out.println("Inserted Successfully");
        } else {
            System.out.println("Failed to insert");
        }

    }
}
