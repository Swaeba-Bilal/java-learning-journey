package com.pet.petadoption.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.pet.petadoption.dao.DAOUser;
import com.pet.petadoption.model.User;

/**
 * This servlet handles user login requests.
 * <p>
 * It validates user credentials against the database 
 * using {@link DAOUser}, and if valid, creates an HTTP session 
 * to store user details (id, username, role).
 * <br>
 * If the login fails, an error message is displayed.
 * </p>
 * 
 * @author Swaeba
 * @version 1.0
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /** Unique identifier for serialization */
    private static final long serialVersionUID = 1L;

    /**
     * Handles POST requests for user login.
     * <p>
     * Retrieves the username and password from the request, 
     * validates them using {@link DAOUser}, and sets session attributes 
     * if authentication succeeds. Otherwise, it returns an error message.
     * </p>
     *
     * @param request  the {@link HttpServletRequest} containing login form data
     * @param response the {@link HttpServletResponse} used to send output
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an input or output error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get form inputs
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate user credentials through DAO
        DAOUser userDAO = new DAOUser();
        User user = userDAO.validateUser(username, password);

        if (user != null) {
            // Login successful → create session
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole());

            // Redirect to welcome page
            response.sendRedirect("welcome.jsp");
        } else {
            // Login failed → show error message
            response.getWriter().write("❌ Invalid username or password.");
        }
    }
}
