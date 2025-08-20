package com.swaiba.student.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.swaiba.student.db.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/db-test")
public class DBTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = DBConnection.getConnection()) {
            response.getWriter().println("✅ Connected to DB: " + conn);
        } catch (SQLException e) {
            response.getWriter().println("❌ DB Connection failed: " + e.getMessage());
        }
    }
}
