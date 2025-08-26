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
			List<Student> students=null;
			String keyword=normalize(request.getParameter("keyword"));
			String section =normalize(request.getParameter("section"));
			String program= normalize(request.getParameter("program"));
			if(keyword.isEmpty() && section.isEmpty() && program.isEmpty() ){
				students=dao.getAllStudent();
			}
			else {
				students=dao.searchStudents(keyword,section,program);
			}
			request.setAttribute("studentList", students);
			request.getRequestDispatcher("/list-students.jsp").forward(request, response);
			
		}
		catch(SQLException e) {
			throw new ServletException("Error fetching students", e);
		}
	}
	private String normalize(String param) {
        return (param == null) ? "" : param.trim();
    }

}
