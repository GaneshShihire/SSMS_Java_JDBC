package main;

import java.util.List;
import java.util.Scanner;
import dao.StudentDAO;
import model.Student;

public class SSMSApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Search Students by Course");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            // while(true){

            switch (choice) {

                case 1:

                    sc.nextLine(); // buffer clear
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty");
                        break;
                    }

                    System.out.print("Enter Student Email: ");
                    String email = sc.nextLine();
                    if (!email.contains("@")) {
                        System.out.println("Invalid Email");
                        break;
                    }

                    System.out.print("Enter Student Course: ");
                    String course = sc.nextLine();
                    if (course.isEmpty()) {
                        System.out.println("Course cannot be empty");
                        break;
                    }

                    Student s = new Student(name, email, course);
                    dao.addStudent(s);
                    break;

                case 2:
                    dao.getAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to Update: ");
                    int uid = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    dao.updateStudent(uid, newName, newEmail, newCourse);
                    break;

                case 4:
                    System.out.print("Enter Student ID to Delete: ");
                    int did = sc.nextInt();

                    dao.deleteStudent(did);
                    break;

                case 5:
                    System.out.println("Enter ID to search");
                    int sid = sc.nextInt();
                    dao.getStudentById(sid);
                    break;

                case 6:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Course Name: ");
                    String c = sc.nextLine();
                    List<Student> students = dao.getStudentByCourse(c);
                    if (students.isEmpty()) {
                        System.out.println("❌ No students found");
                    } else {
                        students.forEach(System.out::println);
                    }
                    break;

                case 7:
                    System.out.println("Thank you! Application Closed.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        }
    }
}
