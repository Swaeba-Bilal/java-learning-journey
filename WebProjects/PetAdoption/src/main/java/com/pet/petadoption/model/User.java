package com.pet.petadoption.model;
/**
 * Model class representing a user of the Pet Adoption Portal.
 * <p>
 * A user has an {@code id}, {@code username}, and a {@code role}.
 * The role can be either {@code "admin"} or {@code "user"}.
 * This class provides getters and setters for these attributes.
 * </p>
 *
 * @author Swaiba
 * @version 1.0
 */
public class User {
	/**  The unique id of the user*/
private int id;
/** The unique username of the user*/
private String username;
/** The role of the user (either {@code "admin"} or {@code "user"}). */
private String role;
/**
 * Constructs a new {@code User} object with the specified details.
 *
 * @param id       the unique identifier of the user
 * @param username the username of the user
 * @param role     the role of the user (admin or user)
 */
public User(int id, String username, String role) {
    this.id = id;
    this.username = username;
    this.role = role;
}
/**
 * Returns the unique identifier of the user.
 *
 * @return the user ID
 */
public int getId() {
	return id;
}
/**
 * Sets the unique identifier of the user.
 *
 * @param id the user ID
 */
public void setId(int id) {
	this.id = id;
}
/**
 * Returns the username of the user.
 *
 * @return the username
 */
public String getUsername() {
	return username;
}
/** Sets the usernamr of the user
 * 
 * @param username the username to assign
 */
public void setUsername(String username) {
	this.username = username;
}
/**
 * Returns the role of the user.
 *
 * @return the user role (admin or user)
 */
public String getRole() {
	return role;
}
/**
 * Sets the role of the user.
 *
 * @param role the role to assign (admin or user)
 */
public void setRole(String role) {
	this.role = role;
}

}
