package com.pet.petadoption.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pet.petadoption.db.DBConnection;
import com.pet.petadoption.model.Pet;

/**
 * Data Access Object (DAO) for handling database operations
 * related to {@link Pet} entities.
 * <p>
 * Provides methods for adding a new pet, retrieving all pets,
 * and mapping {@link ResultSet} rows into {@link Pet} objects.
 * </p>
 * 
 * @author Swaeba
 * @version 1.0
 */
public class DAOPet {

    /**
     * Inserts a new pet into the database.
     * 
     * @param p the {@link Pet} object containing pet details
     * @throws SQLException if a database access error occurs
     */
	public void addPet(Pet p) throws SQLException {
	    String query = "INSERT INTO pets(name, type, breed, age, description, status, photo_url) "
	                 + "VALUES (?, ?, ?, ?, ?, ?, ?)";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pst = con.prepareStatement(query)) {

	        pst.setString(1, p.getName());
	        pst.setString(2, p.getType());
	        pst.setString(3, p.getBreed());
	        pst.setInt(4, p.getAge());
	        pst.setString(5, p.getDescription());
	        pst.setString(6, p.getStatus());
	        pst.setString(7, p.getPhoto_url());

	        pst.executeUpdate();
	    }
	}

    /**
     * Retrieves all pets from the database.
     * 
     * @return a {@link List} of {@link Pet} objects
     * @throws SQLException if a database access error occurs
     */
    public List<Pet> listAllPets() throws SQLException {
        String query = "SELECT * FROM pets";
        List<Pet> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                list.add(mapResultToPet(rs));
            }
        }
        return list;
    }
    public Pet getPetById(int id) throws SQLException {
    	String query="SELECT * FROM PET WHERE id =?";
    	try(Connection con=DBConnection.getConnection();
    			PreparedStatement pst=con.prepareStatement(query)){
    		pst.setInt(1, id);
    		try(ResultSet rs= pst.executeQuery()){
    			if(rs.next()) {
    				return mapResultToPet(rs);
    			}
    		}
    	}
    	return null;
    }
    public boolean updatePet(Pet p) throws SQLException {
        String query = "UPDATE pets SET name=?, type=?, breed=?, age=?, description=?, status=?, photo_url=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, p.getName());
            pst.setString(2, p.getType());
            pst.setString(3, p.getBreed());
            pst.setInt(4, p.getAge());
            pst.setString(5, p.getDescription());
            pst.setString(6, p.getStatus());
            pst.setString(7, p.getPhoto_url());
            pst.setInt(8, p.getId());

            return pst.executeUpdate() > 0;
        }
    }


    /**
     * Maps a {@link ResultSet} row into a {@link Pet} object.
     * 
     * @param rs the {@link ResultSet} containing pet data
     * @return a populated {@link Pet} object
     * @throws SQLException if a database access error occurs
     */
    private Pet mapResultToPet(ResultSet rs) throws SQLException {
        Pet p = new Pet();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setType(rs.getString("type"));
        p.setBreed(rs.getString("breed"));
        p.setAge(rs.getInt("age"));
        p.setDescription(rs.getString("description"));
        p.setStatus(rs.getString("status"));
        p.setPhoto_url(rs.getString("photo_url"));
        p.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return p;
    }
}
