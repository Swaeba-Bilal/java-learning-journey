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
 * Servlet implementation class UpdatePetServlet
 */
@WebServlet("/update-pet")
public class UpdatePetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
DAOPet dao=new DAOPet();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParam=request.getParameter("id");
		 System.out.println("DEBUG: Received id param = " + idParam); // Debug log
		 if(idParam==null || idParam.isEmpty()) {
			 response.getWriter().println("Error: No id is provided in request");
			 return;
		 }
		 try {
			 int id=Integer.parseInt(idParam);
			 Pet p =dao.getPetById(id);
			 if(p!=null) {
				 request.setAttribute("pet", p);
				 request.getRequestDispatcher("update-pet.jsp").forward(request, response);
			 }
			 else {
				 response.getWriter().println("No pet found");
			 }
		 }
		 catch(NumberFormatException e ) {
			 response.getWriter().println("Invalid ID format!");
		 }
		 catch(SQLException e) {
			 throw  new ServletException(e);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String type=request.getParameter("type");
			String breed=request.getParameter("breed");
			int age =Integer.parseInt(request.getParameter("age"));
			String description=request.getParameter("description");
			String status=request.getParameter("status");
			String photo_url=request.getParameter("photo_url");
			System.out.println("Updating student with ID = " + id);
			Pet p =new Pet( name,  type,  breed, age,
        description,  status,  photo_url);
			p.setId(id);
		}
	}

}
