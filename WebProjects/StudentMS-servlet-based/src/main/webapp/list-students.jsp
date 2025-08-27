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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
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
<h2 class="mb-4">Search Students</h2>
<div class="card p-4 mb-4 shadow-sm">
    <form action="list-students" method="get" class="search-form">
        <!-- Keyword -->
            <input type="text" name="keyword" class="form-control" 
                   placeholder="Search by name or email" value="${param.keyword}">

        <!-- Section -->
        
            <select name="section" class="form-select">
                <option value="">--Select Section--</option>
                <option value="A" ${param.section=='A' ? 'selected' : ''}>A</option>
                <option value="B" ${param.section=='B' ? 'selected' : ''}>B</option>
            </select>
        

        <!-- Program -->
       
            <select name="program" class="form-select">
                <option value="">--Select Program--</option>
                <option value="BSCS" ${param.program=='BSCS' ? 'selected' : ''}>BSCS</option>
                <option value="BSSE" ${param.program=='BSSE' ? 'selected' : ''}>BSSE</option>
            </select>
      
<!-- Sort By -->
    
        <select name="sortBy" class="form-select" onchange="this.form.submit()">
            <option value="id" ${param.sortBy=='id' ? 'selected' : ''}>ID</option>
            <option value="name" ${param.sortBy=='name' ? 'selected' : ''}>Name</option>
            <option value="gpa" ${param.sortBy=='gpa' ? 'selected' : ''}>GPA</option>
            <option value="program" ${param.sortBy=='program' ? 'selected' : ''}>Program</option>
            <option value="section" ${param.sortBy=='section' ? 'selected' : ''}>Section</option>
        </select>
    
    <!-- Order -->
    
        <select name="order" class="form-select" onchange="this.form.submit()">
            <option value="ASC" ${param.order=='ASC' ? 'selected' : ''}>Ascending</option>
            <option value="DESC" ${param.order=='DESC' ? 'selected' : ''}>Descending</option>
        </select>
    
        <!-- Button -->
        
            <button type="submit" class="btn btn-primary w-100">Search</button>
      
    </form>
</div>
<h2 class="mb-4">Student List</h2>
<div class="card shadow-sm p-3">
    <div class="table-responsive">
        <table class="table table-striped table-hover table-bordered align-middle">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Program</th>
                    <th>Section</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${studentList}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.email}</td>
                        <td>${student.program}</td>
                        <td>${student.section}</td>
                        <td class="text-center">
                            <a href="update-student?id=${student.id}" class="btn btn-sm btn-warning me-1">Edit</a>
                            <a href="delete-student?id=${student.id}" class="btn btn-sm btn-danger"
                               onclick="return confirm('Are you sure you want to delete this student?');">
                               Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!-- Pagination Controls -->
        <c:if test="${totalPages > 1}">
            <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center mt-3">

                    <!-- Previous -->
                    <c:if test="${currentPage > 1}">
                        <li class="page-item">
                            <a class="page-link" 
                               href="list-students?page=${currentPage-1}&keyword=${param.keyword}&section=${param.section}&program=${param.program}">
                               Previous
                            </a>
                        </li>
                    </c:if>

                    <!-- Page Numbers -->
                    <c:forEach begin="1" end="${totalPages}" var="i">
                        <li class="page-item ${i==currentPage ? 'active' : ''}">
                            <a class="page-link" 
                               href="list-students?page=${i}&keyword=${param.keyword}&section=${param.section}&program=${param.program}">
                               ${i}
                            </a>
                        </li>
                    </c:forEach>

                    <!-- Next -->
                    <c:if test="${currentPage < totalPages}">
                        <li class="page-item">
                            <a class="page-link" 
                               href="list-students?page=${currentPage+1}&keyword=${param.keyword}&section=${param.section}&program=${param.program}">
                               Next
                            </a>
                        </li>
                    </c:if>

                </ul>
            </nav>
        </c:if>
      
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
