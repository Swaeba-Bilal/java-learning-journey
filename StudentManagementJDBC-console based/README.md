# 🎓 Student Management System (Console-Based, JDBC + MySQL)

[![Java](https://img.shields.io/badge/Java-22-orange?logo=java&logoColor=white)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/Database-MySQL-blue?logo=mysql&logoColor=white)](https://www.mysql.com/)
[![JDBC](https://img.shields.io/badge/JDBC-Database%20Connectivity-yellowgreen)](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/)
[![GitHub](https://img.shields.io/badge/Version%20Control-GitHub-black?logo=github)](https://github.com/)

This is a **console-based Student Management System** developed in **Java** using **JDBC** for database connectivity with **MySQL**.  
The project demonstrates **Object-Oriented Programming (OOP) principles**, database CRUD operations, and good coding practices like using a `db.properties` file for secure database configuration.

---

## 🚀 Features
- ➕ Add new students  
- 📋 List all students  
- 🔍 Search student by ID  
- ✏️ Update student details  
- ❌ Delete student records  
- 💾 Data persistence using MySQL database  

---

## 🛠️ Tech Stack
- **Java 22** (Core Java, OOP)  
- **JDBC** (Java Database Connectivity)  
- **MySQL** (Relational Database)  
- **Properties File** (`db.properties`) for secure credentials  

---

## ⚙️ Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/<your-username>/java-learning-journey.git
   cd java-learning-journey/StudentManagementJDBC
2. **Create MySQL Database**
   CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    grade VARCHAR(10)
);
3. **Configure db.properties (Not pushed to GitHub)**
Create a file src/db.properties:
db.url=jdbc:mysql://localhost:3306/studentdb
db.username=root
db.password=yourpassword
4. **Compile & Run**
🔑 **Key Learning Outcomes**

Hands-on with JDBC connectivity

Best practice of externalizing credentials with db.properties

Practical application of OOP principles in a real-world project

Version control with Git & GitHub
📌 **Notes**

db.properties is excluded via .gitignore for security reasons.

This project is part of my Java Learning Journey, where I build projects from basic to advanced level.
👤 Author

Swaeba
💻 Passionate Computer Science student | Exploring Java, Databases & Web Development
