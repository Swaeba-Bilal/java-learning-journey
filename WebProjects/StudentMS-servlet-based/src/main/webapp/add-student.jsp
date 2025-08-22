<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("home.jsp"); // kick out if not logged in
        return;
    }
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
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
<li class="nav-item"><a class="nav-link" href="add-student.jsp active">Add Student</a></li>
<li class="nav-item"><a class="nav-link" href="about.jsp ">About</a></li>
<% if (session.getAttribute("admin") != null) { %>
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="logout">Logout</a>
                    </li>
                <% } %>
</ul>
</div>
</div>
</nav>
<div class="container my-5">
<h2 class="mb-4">Add New Student</h2>

<form action="${pageContext.request.contextPath}/add-student" method="post" class="border p-4 rounded 
shadow-sm bg-light">
<div class ="mb-3">
 <label class="form-label">Name:</label>
<input type="text" name="name" class="form-control" required>
</div>
<div class="mb-3">
<label class="form-label">Email:</label>
<input type="email" name="email" class="form-control"required>
</div>
<div class="mb-3">
<label class="form-label">Date of Birth:</label>
 <input type="date" name="dob" class="form-control" required>
 </div>
 <div class="mb-3">
 <label class="form-label">GPA:</label>
<input type="number" step="any" name="gpa" class="form-control"required>
</div>
<button type="submit" class="btn btn-success">Add Student</button>
<a href="${pageContext.request.contextPath}/list-students" class="btn btn-secondary ms-2">Back to Student List</a>
</form>
</div>
<!-- Footer -->
<footer class="bg-dark text-white text-center py-3 mt-5">
  <p>&copy; 2025 Student Management System | Developed by Swaeba Bilal</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>