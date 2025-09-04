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
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="home.jsp">
            <i class="fas fa-graduation-cap"></i> StudentMS
        </a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="home.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link active" href="list-students">View Students</a></li>
                <li class="nav-item"><a class="nav-link" href="add-student.jsp">Add Student</a></li>
                <li class="nav-item"><a class="nav-link" href="about.jsp">About</a></li>
                <c:if test="${not empty sessionScope.admin}">
    <li class="nav-item">
        <a class="nav-link text-danger" href="${pageContext.request.contextPath}/logout">
            <i class="fas fa-sign-out-alt"></i> Logout
        </a>
    </li>
</c:if>

            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container my-5">
    <div class="text-center mb-4">
        <h1><i class="fas fa-users"></i> Student Management System</h1>
        <p class="text-muted">Search, filter, and manage your students efficiently</p>
    </div>
    
    <!-- Quick Stats -->
    <div class="quick-stats">
        <div class="row">
            <div class="col-md-3 stat-item">
                <div class="stat-number">${studentList.size()}</div>
                <div>Total Students</div>
            </div>
            <div class="col-md-3 stat-item">
                <div class="stat-number">
                    <c:set var="bscsCount" value="0" />
                    <c:forEach var="student" items="${studentList}">
                        <c:if test="${student.program == 'BSCS'}">
                            <c:set var="bscsCount" value="${bscsCount + 1}" />
                        </c:if>
                    </c:forEach>
                    ${bscsCount}
                </div>
                <div>BSCS Students</div>
            </div>
            <div class="col-md-3 stat-item">
                <div class="stat-number">
                    <c:set var="bsseCount" value="0" />
                    <c:forEach var="student" items="${studentList}">
                        <c:if test="${student.program == 'BSSE'}">
                            <c:set var="bsseCount" value="${bsseCount + 1}" />
                        </c:if>
                    </c:forEach>
                    ${bsseCount}
                </div>
                <div>BSSE Students</div>
            </div>
            <div class="col-md-3 stat-item">
                <div class="stat-number">${currentPage}/${totalPages}</div>
                <div>Page</div>
            </div>
        </div>
    </div>

    <!-- Main Search Form -->
    <div class="google-search-container">
        <form action="list-students" method="get">
            <div class="main-search-box">
                <div class="search-input-group">
                    <input type="text" 
                           name="keyword" 
                           class="main-search-input" 
                           placeholder="🔍 Search students by name, email, program, or section..."
                           value="${param.keyword}">
                    <button type="submit" class="search-btn">
                        <i class="fas fa-search"></i> Search
                    </button>
                </div>
            </div>
            
            <!-- Advanced Filters -->
            <div class="advanced-filters">
                <h6 class="mb-3">
                    <i class="fas fa-filter"></i> Advanced Filters
                    <c:if test="${not empty param.keyword or not empty param.section or not empty param.program}">
                        <a href="list-students" class="clear-filters-btn ms-3">
                            <i class="fas fa-times"></i> Clear All
                        </a>
                    </c:if>
                </h6>
                
                <div class="row filter-row">
                    <div class="col-md-3">
                        <div class="filter-label">Section</div>
                        <select name="section" class="form-select">
                            <option value="">All Sections</option>
                            <option value="A" ${param.section=='A' ? 'selected' : ''}>Section A</option>
                            <option value="B" ${param.section=='B' ? 'selected' : ''}>Section B</option>
                        </select>
                    </div>
                    
                    <div class="col-md-3">
                        <div class="filter-label">Program</div>
                        <select name="program" class="form-select">
                            <option value="">All Programs</option>
                            <option value="BSCS" ${param.program=='BSCS' ? 'selected' : ''}>BSCS</option>
                            <option value="BSSE" ${param.program=='BSSE' ? 'selected' : ''}>BSSE</option>
                        </select>
                    </div>
                    
                    <div class="col-md-3">
                        <div class="filter-label">Sort By</div>
                        <select name="sortBy" class="form-select">
                            <option value="id" ${param.sortBy=='id' ? 'selected' : ''}>Student ID</option>
                            <option value="name" ${param.sortBy=='name' ? 'selected' : ''}>Name</option>
                            <option value="gpa" ${param.sortBy=='gpa' ? 'selected' : ''}>GPA</option>
                            <option value="program" ${param.sortBy=='program' ? 'selected' : ''}>Program</option>
                            <option value="section" ${param.sortBy=='section' ? 'selected' : ''}>Section</option>
                        </select>
                    </div>
                    
                    <div class="col-md-3">
                        <div class="filter-label">Order</div>
                        <select name="order" class="form-select">
                            <option value="ASC" ${param.order=='ASC' ? 'selected' : ''}>Ascending ↑</option>
                            <option value="DESC" ${param.order=='DESC' ? 'selected' : ''}>Descending ↓</option>
                        </select>
                    </div>
                </div>
                
                <div class="text-center mt-3">
                    <button type="submit" class="btn btn-primary btn-lg">
                        <i class="fas fa-search"></i> Apply Filters
                    </button>
                </div>
            </div>
        </form>
    </div>

    <!-- Student Table -->
    <div class="table-container">
        <div class="table-header">
            <h3 class="table-title">
                <i class="fas fa-list"></i> Student Directory
                <c:if test="${not empty param.keyword}">
                    <small class="text-light"> - Results for "${param.keyword}"</small>
                </c:if>
            </h3>
        </div>
        
        <c:choose>
            <c:when test="${empty studentList}">
                <div class="no-results">
                    <i class="fas fa-search"></i>
                    <h4>No students found</h4>
                    <p>Try adjusting your search criteria or <a href="list-students">view all students</a></p>
                </div>
            </c:when>
            <c:otherwise>
                <div class="table-responsive">
                    <table class="table table-hover mb-0">
                        <thead>
                            <tr>
                                <th><i class="fas fa-id-badge"></i> ID</th>
                                <th><i class="fas fa-user"></i> Name</th>
                                <th><i class="fas fa-envelope"></i> Email</th>
                                <th><i class="fas fa-book"></i> Program</th>
                                <th><i class="fas fa-users"></i> Section</th>
                                <th><i class="fas fa-cog"></i> Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="student" items="${studentList}">
                                <tr>
                                    <td><strong>${student.id}</strong></td>
                                    <td>
                                        <strong>${student.name}</strong>
                                    </td>
                                    <td>
                                        <a href="mailto:${student.email}" class="text-decoration-none">
                                            ${student.email}
                                        </a>
                                    </td>
                                    <td>
                                        <span class="program-badge 
                                                     ${student.program == 'BSCS' ? 'bg-primary text-white' : 'bg-success text-white'}">
                                            ${student.program}
                                        </span>
                                    </td>
                                    <td>
                                        <span class="section-badge bg-secondary text-white">
                                            Section ${student.section}
                                        </span>
                                    </td>
                                    <td>
                                        <a href="update-student?id=${student.id}" 
                                           class="action-btn btn btn-warning btn-sm me-2">
                                            <i class="fas fa-edit"></i> Edit
                                        </a>
                                        <a href="delete-student?id=${student.id}" 
                                           class="action-btn btn btn-danger btn-sm"
                                           onclick="return confirm('Are you sure you want to delete ${student.name}?');">
                                            <i class="fas fa-trash"></i> Delete
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <!-- Pagination Controls -->
    <c:if test="${totalPages > 1}">
        <nav aria-label="Student list pagination">
            <ul class="pagination justify-content-center">
                <!-- Previous Button -->
                <c:if test="${currentPage > 1}">
                    <li class="page-item">
                        <a class="page-link" 
                           href="list-students?page=${currentPage-1}&keyword=${param.keyword}&section=${param.section}&program=${param.program}&sortBy=${param.sortBy}&order=${param.order}">
                           <i class="fas fa-chevron-left"></i> Previous
                        </a>
                    </li>
                </c:if>

                <!-- Page Numbers -->
                <c:set var="startPage" value="${currentPage - 2 > 1 ? currentPage - 2 : 1}" />
                <c:set var="endPage" value="${currentPage + 2 < totalPages ? currentPage + 2 : totalPages}" />
                
                <c:if test="${startPage > 1}">
                    <li class="page-item">
                        <a class="page-link" 
                           href="list-students?page=1&keyword=${param.keyword}&section=${param.section}&program=${param.program}&sortBy=${param.sortBy}&order=${param.order}">
                           1
                        </a>
                    </li>
                    <c:if test="${startPage > 2}">
                        <li class="page-item disabled"><span class="page-link">...</span></li>
                    </c:if>
                </c:if>

                <c:forEach begin="${startPage}" end="${endPage}" var="i">
                    <li class="page-item ${i==currentPage ? 'active' : ''}">
                        <a class="page-link" 
                           href="list-students?page=${i}&keyword=${param.keyword}&section=${param.section}&program=${param.program}&sortBy=${param.sortBy}&order=${param.order}">
                           ${i}
                        </a>
                    </li>
                </c:forEach>

                <c:if test="${endPage < totalPages}">
                    <c:if test="${endPage < totalPages - 1}">
                        <li class="page-item disabled"><span class="page-link">...</span></li>
                    </c:if>
                    <li class="page-item">
                        <a class="page-link" 
                           href="list-students?page=${totalPages}&keyword=${param.keyword}&section=${param.section}&program=${param.program}&sortBy=${param.sortBy}&order=${param.order}">
                           ${totalPages}
                        </a>
                    </li>
                </c:if>

                <!-- Next Button -->
                <c:if test="${currentPage < totalPages}">
                    <li class="page-item">
                        <a class="page-link" 
                           href="list-students?page=${currentPage+1}&keyword=${param.keyword}&section=${param.section}&program=${param.program}&sortBy=${param.sortBy}&order=${param.order}">
                           Next <i class="fas fa-chevron-right"></i>
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