package com.swaiba.student.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.swaiba.student.dao.StudentDAO;

@WebServlet("/delete-student")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO dao = new StudentDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                dao.deleteStudent(id);
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
            }
        }
        // Redirect back to the student list
        response.sendRedirect(request.getContextPath() + "/list-students");
    }
	}
