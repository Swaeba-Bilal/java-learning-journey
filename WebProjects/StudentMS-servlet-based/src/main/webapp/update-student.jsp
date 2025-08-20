<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
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
<li class="nav-item"><a class="nav-link" href="about.jsp ">About</a></li>
</ul>
</div>
</div>
</nav>
<div class="container my-5">
<h2 class="mb-4">Update Student</h2>
<form action="${pageContext.request.contextPath}/update-student" method="post" class="border p-4 rounded
shadow-sm bg-light">
<input type="hidden" name="id" value="${student.id}">
<div class="mb-3">
<label class="form-label">Name:</label>
<input type="text" name="name" value="${student.name}" class="form-control"required>
</div>
<div class="mb-3">
<label class="form-label">Email:</label>
<input type="email" name="email" value="${student.email}" class="form-control" required>
</div>
<div class="mb-3">
<label class="form-label">Date of Birth:</label>
<input type="date" name="dob" value="${student.dob}"class="form-control" required>
</div>
<div class="mb-3">
<label class="form-label">GPA:</label>
<input type="number" step="any" name="gpa" value="${student.gpa}" class="form-control" required>
</div>
<button type="submit" class="btn btn-primary">Update Student</button>
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