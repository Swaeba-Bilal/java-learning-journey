package com.pet.petadoption.model;
/**
 * This is the model class for the user.
 * <p>
 * It has datafields like id, username,role and getters and setters
 * of these attributes
 * </p>
 */
public class User {
	/** unique id of the user*/
private int id;
/** unique username of the user*/
private String username;
/** role of the student*/
private String role;
/**  Return the id of the user
 * 
 * @return the unique id of the user
 */
public int getId() {
	return id;
}
/**
 * Set the id of the user
 * @param id the unique id of the user
 */
public void setId(int id) {
	this.id = id;
}
/** Returns the unqiue username of the user
 * 
 * @return the unique username of the user
 */
public String getUsername() {
	return username;
}
/** Set the usernamr of the user
 * 
 * @param username the unique username of the user
 */
public void setUsername(String username) {
	this.username = username;
}
/** Returs the role(admin,user) of the student
 * 
 * @return the role of the user
 */
public String getRole() {
	return role;
}
/** Set the role of the user
 * 
 * @param role the role of the user(admin,user)
 */
public void setRole(String role) {
	this.role = role;
}

}
