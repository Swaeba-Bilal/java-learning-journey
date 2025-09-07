package com.pet.petadoption.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.pet.petadoption.dao.DAOPet;
import com.pet.petadoption.model.Pet;

/**
 * Servlet to handle adding new pets to the adoption system.
 */
@WebServlet("/add-pet")
public class AddPetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String breed = request.getParameter("breed");
        int age = Integer.parseInt(request.getParameter("age"));
        String description = request.getParameter("description");
        String status = "available";
        String photo_url = request.getParameter("photo_url");

        Pet p = new Pet(name, type, breed, age, description, status, photo_url);
        DAOPet dao = new DAOPet();

        try {
            dao.addPet(p);
            response.sendRedirect(request.getContextPath() + "/list-pets");
        } catch (SQLException e) {
            throw new ServletException("Error adding Pet", e);
        }
    }
}
