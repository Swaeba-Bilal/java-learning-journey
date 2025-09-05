package com.pet.petadoption.servlet;

import com.pet.petadoption.db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * This servlet handles user signup by validating the username
 * and inserting a new user into the database if available.
 * <p>
 * On successful signup, the user is redirected to {@code login.jsp}.
 *  If the username already exists, an error message is displayed.
 * </p>
 * @author Swaeba
 * @version 1.0
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
/**
 * Processes POST requests for user signup
 * <p>
 * This method checks if the username already exists in the database.
 * If it is available, the new user is inserted and redirected to the login page.
 * Otherwise, an error message is returned to the client.
 * </p>
 * @param request the {@link HttpServletRequest} containing form data 
 * @param response the{@link HttpServletResponse} used to send output
 * @throws ServletException if a servlet-specific error occured
 * @throws IOException if an input or output error occcurs
 */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection conn = DBConnection.getConnection()) {

            // Step 1: Check if username already exists
            String checkSql = "SELECT id FROM users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Username exists
                response.getWriter().write("❌ Username already taken. Please choose another.");
                return;
            }

            // Step 2: If not taken, insert new user
            String insertSql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setString(1, username);
            insertStmt.setString(2, password);

            int rows = insertStmt.executeUpdate();
            if (rows > 0) {
                response.sendRedirect("login.jsp"); // successful signup
            } else {
                response.getWriter().write("❌ Signup failed. Please try again.");
            }

        } catch (Exception e) {
            response.getWriter().write("❌ Error: " + e.getMessage());
        }
    }
}
