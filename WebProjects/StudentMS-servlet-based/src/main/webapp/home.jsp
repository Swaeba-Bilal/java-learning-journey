<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About - Student Management System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="home.jsp">StudentMS</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link active" href="home.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="list-students">View Students</a></li>
                <li class="nav-item"><a class="nav-link" href="add-student.jsp">Add Student</a></li>
                <li class="nav-item"><a class="nav-link " href="about.jsp">About</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- About Content -->
<div class="container my-5">
    <h2 class="mb-4">About This Project</h2>
    <p>
        The <strong>Student Management System</strong> is a web-based application built using 
        <em>Java Servlets, JSP, JSTL, and MySQL</em>. It allows users to manage student records 
        efficiently with features such as:
    </p>
    <ul>
        <li>Add new student records</li>
        <li>View all students in a tabular format</li>
        <li>Update existing student information</li>
        <li>Delete student records</li>
    </ul>

    <p>
        This project was created as part of a learning journey in <strong>Java Web Development</strong> 
        and demonstrates the use of <em>MVC architecture</em>, JDBC for database connectivity, and 
        JSTL for dynamic rendering.
    </p>

    <p>
        Future improvements may include:
        <ul>
            <li>User authentication (login system)</li>
            <li>Search & filter features</li>
            <li>Pagination for large student data</li>
            <li>Responsive dashboard UI</li>
        </ul>
    </p>
</div>

<!-- Footer -->
<footer class="bg-dark text-white text-center py-3">
    <p>&copy; 2025 Student Management System | Developed by Swaeba Bilal</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
