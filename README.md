# Smart Student Management System (SSMS)

## 📌 Project Overview
Smart Student Management System (SSMS) is a console-based Java application
built using Core Java, JDBC, and MySQL.  
It helps manage students, courses, and their relationships efficiently.

This project is designed to demonstrate backend concepts such as
CRUD operations, database connectivity, validation, and authentication.

---

## 🧱 Tech Stack
- Java (Core Java)
- JDBC
- MySQL
- VS Code / Eclipse
- Git & GitHub

---

## 🗄️ Database Tables
1. **students**
   - student_id (AUTO_INCREMENT, PRIMARY KEY)
   - name
   - email
   - course

2. **courses**
   - course_id (AUTO_INCREMENT, PRIMARY KEY)
   - course_name
   - duration

3. **student_course**
   - student_id
   - course_id  
   *(Many-to-Many relationship)*

4. **admin**
   - username (PRIMARY KEY)
   - password

---

## ⚙️ Features

### 👤 Student Module
- Add student
- View all students
- Update student details
- Delete student
- Search student by ID
- Search students by course

### 📚 Course Module
- Add course
- View all courses
- Assign student to course
- View students enrolled in a course

### 🔐 Admin Module
- Admin login using username and password
- Menu access only after successful login
- Limited login attempts

---

## 🧠 Concepts Used
- JDBC Architecture
- PreparedStatement
- ResultSet
- DAO Design Pattern
- AUTO_INCREMENT Primary Keys
- Exception Handling
- Input Validation
- Menu-driven Console Application

---

## ▶️ How to Run the Project
1. Clone the repository
2. Create the database and tables in MySQL
3. Update DB credentials in `DBConnection.java`
4. Run `SSMSApp.java`

---

## 🎯 Learning Outcome
This project helped me understand:
- How Java interacts with databases using JDBC
- How to design a structured backend application
- How to handle real-world edge cases and validation

---

## 👤 Author
Ganesh Shihire  
B.Tech CSE
