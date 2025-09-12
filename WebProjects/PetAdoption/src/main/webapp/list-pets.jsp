<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pet List-- Pet Adoption</title>
</head>
<body>
<h2>Available Pets</h2>
<table>
<tr>
<th>Id</th>
<th>Name</th>
<th>Type</th>
<th>Breed</th>
<th>Age</th>
<th>Description</th>
<th>Status</th>
<th>Photo</th>
</tr>
<c:forEach var="pet" items="${petslist}">
<tr>
<td>${pet.id}</td>
<td>${pet.name}</td>
<td>${pet.type}</td>
<td>${pet.breed}</td>
<td>${pet.age}</td>
<td>${pet.description}</td>
<td>${pet.status}</td>
<td>${pet.photo}</td>
</tr>
</c:forEach>
</table>
</body>
</html>