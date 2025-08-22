<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("home.jsp"); // kick out if not logged in
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="home.jsp">StudentMS</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="home.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link active" href="list-students">View Students</a></li>
                <li class="nav-item"><a class="nav-link" href="add-student.jsp">Add Student</a></li>
                <li class="nav-item"><a class="nav-link" href="about.jsp">About</a></li>
                <% if (session.getAttribute("admin") != null) { %>
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="logout">Logout</a>
                    </li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container my-5">
    <h2 class="mb-4">All Students</h2>

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>DOB</th>
                <th>GPA</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="s" items="${studentList}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.email}</td>
                    <td>${s.dob}</td>
                    <td>${s.gpa}</td>
                    <td>
                        <a class="btn btn-sm btn-primary" 
                           href="${pageContext.request.contextPath}/update-student?id=${s.id}">Edit</a>
                        <a class="btn btn-sm btn-danger" 
                           href="${pageContext.request.contextPath}/delete-student?id=${s.id}" 
                           onclick="return confirm('Are you sure you want to delete this student?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- Footer -->
<footer class="bg-dark text-white text-center py-3">
    <p>&copy; 2025 Student Management System | Developed by Swaeba Bilal</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
