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

@WebServlet("/update-student")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDAO dao= new StudentDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
	    System.out.println("DEBUG: Received id param = " + idParam); // Debug log

	    if (idParam == null || idParam.isEmpty()) {
	        response.getWriter().println("Error: No ID provided in request!");
	        return;
	    }
		try {
			int id = Integer.parseInt(idParam);
			Student s =dao.getStudentById(id);
			if(s!=null) {
				request.setAttribute("student", s);
				request.getRequestDispatcher("update-student.jsp").forward(request, response);
			}
			else {
				response.getWriter().println("Student not found!");
			}
		}
		catch (NumberFormatException e) {
	        response.getWriter().println("Invalid ID format!");
	    }
		catch(SQLException e) {
			throw  new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
	        double gpa = Double.parseDouble(request.getParameter("gpa"));
	        System.out.println("Updating student with ID = " + id);

	        Student s = new Student(name, email, dob, gpa);
	        s.setId(id);
	        System.out.println("Student object before update: " + s);

	        boolean updated = dao.updateStudent(s);

	        if (updated) {
	            response.sendRedirect(request.getContextPath() + "/list-students");
	        } else {
	            response.getWriter().println("Update failed!");
	        }
	    } catch (Exception e) {
	        throw new ServletException(e);
	    }
	}

	}
