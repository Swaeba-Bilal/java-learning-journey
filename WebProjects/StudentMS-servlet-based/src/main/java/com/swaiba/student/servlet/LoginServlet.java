package com.swaiba.student.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.swaiba.student.dao.AdminDAO;
import com.swaiba.student.model.Admin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO adminDAO;
   public void init() {
	   adminDAO= new AdminDAO();
   }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Admin admin=adminDAO.validateAdmin(username,password);
		if(admin!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("admin", admin);
			response.sendRedirect("home.jsp");
		}
		else {
			request.setAttribute("errorMessage", "Invalid username and password!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	}
