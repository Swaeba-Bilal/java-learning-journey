package com.pet.petadoption.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pet.petadoption.db.DBConnection;
import com.pet.petadoption.model.User;

/**
 * Data Access Object (DAO) class for handling operations related to {@link User}.
 * <p>
 * This class provides methods to interact with the database for user authentication
 * and retrieval of user details.
 * </p>
 * 
 * @author Swaiba
 * @version 1.0
 */
public class DAOUser {

    /**
     * Validates user credentials and retrieves the corresponding {@link User} object.
     * <p>
     * If the username and password match a record in the database, a populated
     * {@code User} object is returned. Otherwise, {@code null} is returned.
     * </p>
     *
     * @param username the username entered by the user
     * @param password the password entered by the user
     * @return a {@link User} object if the credentials are valid, or {@code null} if invalid
     */
    public User validateUser(String username, String password) {
        String sql = "SELECT id, username, role FROM users WHERE username=? AND password=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("role")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
