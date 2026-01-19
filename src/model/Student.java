package model;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private String course;

    // no arg constructor
    public Student() {

    }

    // paramaterized constructor

    public Student(String name, String email, String course) {
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // 2️⃣ Constructor for FETCH / UPDATE / DELETE (ID from DB)
    public Student(int studentId, String name, String email, String course) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // getters and setters

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d | Name: %s | Email: %s | Course: %s",
                studentId, name, email, course);
    }

}
