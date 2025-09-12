package com.pet.petadoption.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pet.petadoption.dao.DAOPet;
import com.pet.petadoption.model.Pet;

/**
 * Servlet implementation class ListPetServlet
 */
@WebServlet("/list-pets")
public class ListPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
DAOPet dao= new DAOPet();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
List<Pet> pets;
try {
	pets=dao.listAllPets();
	request.setAttribute("petslist", pets);
	System.out.println("Pets fetched: " + pets.size());
	for (Pet pet : pets) {
	    System.out.println(pet.getName() + " - " + pet.getType());
	}

	request.getRequestDispatcher("/list-pets.jsp").forward(request, response);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}


}
