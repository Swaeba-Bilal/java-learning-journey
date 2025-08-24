<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

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
</ul>
</div>
</div>
</nav>
<h2 class="admin-login-title">Admin Login</h2>
<div class="container my-5">
<%String errorMessage=(String) request.getAttribute("errorMessage"); 
if (errorMessage != null) {
    %>
        <p style="color:red;"><%= errorMessage %></p>
    <%
        }
    %>
<form action="login" method="post"class="border p-4 rounded 
shadow-sm bg-light">
<div class="mb-3">
<label class="form-label">Enter Username:</label>
<input type="text" name="username" class="form-control"required>
</div>
<div class="mb-3">
<label class="form-label">Enter Password:</label>
<input type="password" name="password" class="form-control" required>
</div>
<button type="submit" class="btn btn-success">Login</button>
</form>
</div>
</body>
</html>