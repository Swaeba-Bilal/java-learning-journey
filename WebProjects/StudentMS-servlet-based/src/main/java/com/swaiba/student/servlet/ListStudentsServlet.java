package com.swaiba.student.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.swaiba.student.dao.StudentDAO;
import com.swaiba.student.model.Student;

@WebServlet("/list-students")
public class ListStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  private StudentDAO dao=new StudentDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Student> students=dao.getAllStudent();
			request.setAttribute("studentList", students);
			request.getRequestDispatcher("/list-students.jsp").forward(request, response);
		}
		catch(SQLException e) {
			throw new ServletException("Error fetching students", e);
		}
	}

}
