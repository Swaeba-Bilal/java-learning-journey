package com.pet.petadoption.servlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import com.pet.petadoption.db.DBConnection;
@WebServlet("/dbtest")
public class DBTestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                resp.getWriter().write("✅ Database connection successful!");
            } else {
                resp.getWriter().write("❌ Failed to connect.");
            }
        } catch (Exception e) {
            resp.getWriter().write("❌ Error: " + e.getMessage());
        }
    }
}
