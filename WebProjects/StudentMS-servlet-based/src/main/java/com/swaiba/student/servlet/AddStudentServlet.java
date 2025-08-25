package com.swaiba.student.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import com.swaiba.student.dao.StudentDAO;
import com.swaiba.student.model.Student;

@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String dobStr=request.getParameter("dob");
	String gpaStr=request.getParameter("gpa");
	String section=request.getParameter("section");
	String program=request.getParameter("program");
	//Convert data types
	LocalDate dob=LocalDate.parse(dobStr);
	Double gpa=Double.parseDouble(gpaStr);
	Student s= new Student(name,email,dob,gpa,section,program);
	StudentDAO dao= new StudentDAO();
	try {
		dao.addStudent(s);
		response.sendRedirect(request.getContextPath()+"/list-students");
	}
	catch(SQLException e){
		throw new ServletException("Error adding Student", e);
	}
	
	}

}
