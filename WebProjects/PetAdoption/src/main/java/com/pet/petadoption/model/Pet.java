package com.pet.petadoption.model;

import java.time.LocalDateTime;

/**
 * Model class representing a Pet in the adoption system.
 * <p>
 * This class maps to the {@code pets} table in the database.
 * Each Pet has attributes such as name, type, breed, age,
 * description, status, and photo URL.
 * </p>
 * 
 * @author Swaeba
 * @version 1.0
 */
public class Pet {
	/**Unique Id of the pet */
private int id;
/**Name of the pet */
private String name;
/**Type of the pet(dog,cat,bird, other)*/
private String type;
/**Breed of the pet*/
private String breed;
/** Age of the pet in years*/
private int age;
/** Description of the pet (characteristics, notes, etc.). */
private String description;
/** Status of the pet (available/adopted). */
private String status;
/** URL of the pet's photo. */
private String photo_url;
/** Timestamp when the pet entry was created. */
private LocalDateTime createdAt;
public Pet() {}
public Pet(int id, String name, String type, String breed,int age,String description,
		String status,String photo_url,LocalDateTime createdAt) {
	this.id=id;
	this.name=name;
	this.type=type;
	this.breed=breed;
	this.age=age;
	this.description=description;
	this.status=status;
	this.photo_url=photo_url;
	this.createdAt=createdAt;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getBreed() {
	return breed;
}
public void setBreed(String breed) {
	this.breed = breed;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getPhoto_url() {
	return photo_url;
}
public void setPhoto_url(String photo_url) {
	this.photo_url = photo_url;
}
public LocalDateTime getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}

}
