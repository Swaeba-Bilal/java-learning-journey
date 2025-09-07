<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add-Pet</title>
</head>
<body>
<form action="add-pet" method="post">
<label>Enter Name:</label>
<input type="text" name="name" required><br><br> 
<label>Enter type:</label>
<input type="text" name="type" required><br><br> 
<label>Enter Breed:</label>
<input type="text" name="breed" required><br><br> 
<label>Enter age:</label>
<input type="number" name="age" required><br><br> 
<label>Enter Description:</label>
<input type="text" name="description" required><br><br> 
<label>Enter photo_url:</label>
<input type="text" name="photo_url" required><br><br> 
<button type="submit">Submit </button>

</form>
</body>
</html>