<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About | StudentMS</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="home.jsp">Student MS</a>
    <div class="collapse navbar-collapse">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item"><a class="nav-link" href="home.jsp">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="list-students">View Students</a></li>
        <li class="nav-item"><a class="nav-link" href="add-student.jsp">Add Student</a></li>
        <li class="nav-item"><a class="nav-link active" href="about.jsp">About</a></li>

        <!-- Show Login if not logged in, Logout if logged in -->
        <c:choose>
          <c:when test="${not empty sessionScope.admin}">
            <li class="nav-item">
              <a class="nav-link" href="logout">Logout</a>
            </li>
          </c:when>
          <c:otherwise>
            <li class="nav-item">
              <a class="nav-link" href="login.jsp">Login</a>
            </li>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
  </div>
</nav>

<!-- page content -->
<div class="container my-5">
  <h2 class="mb-4">About Student Management System</h2>
  <p class="lead">
    The <strong>Student Management System (Student MS)</strong> is a web application built using
    <em>Java, JSP, Servlets, JSTL, MySQL</em>, and <em>Bootstrap</em>.
    It allows administrators to manage student records efficiently, including adding, updating, viewing,
    and deleting students.
  </p>

  <h4>Features</h4>
  <ul>
    <li>View all students in a structured table</li>
    <li>Add new students with details such as name, email, DOB, and GPA</li>
    <li>Update student information easily</li>
    <li>Delete students with confirmation</li>
    <li>User-friendly Bootstrap UI</li>
  </ul>

  <h4>Technology stack</h4>
  <ul>
    <li>Frontend: JSP, HTML, CSS, Bootstrap 5</li>
    <li>Backend: Java Servlets, JSTL</li>
    <li>Database: MySQL</li>
    <li>Server: Apache Tomcat 10</li>
  </ul>

  <h4>Developer</h4>
  <p>
    This project is developed by <strong>Swaeba Bilal</strong> as part of 
    learning and practicing <em>Web Development with Java</em>.
  </p>
</div>

<!-- Footer -->
<footer class="bg-dark text-white text-center py-3">
  <p>&copy; 2025 Student Management System | Developed by Swaeba Bilal</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
