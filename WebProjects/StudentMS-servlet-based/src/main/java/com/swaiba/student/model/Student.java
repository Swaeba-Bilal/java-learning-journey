package com.swaiba.student.model;

import java.time.LocalDate;
/**
 * The{@code Student} class represents a student entity in the system.
 * <p>
 * It contains student attributes such as ID, name, email, date of birth,
 * GPA, section, and program, along with constructors, getters, setters,
 * and a {@code toString()} method.
 * </p>
 * 
 * @author Swaeba
 * @version 1.0
 */
public class Student {
	/** The unique id of the student */
	private int id;
	/** The full name of the student*/
	private String name;
	/** The email address of the student */
	private String email;
	/** The date of birth of the student */
	private LocalDate dob;
	/** The grade point average (GPA) of the student */
	private double gpa;
	/** The section to which the student belongs. */
	private String section;
	/** The  academic program of the student in which the student is enrolled */
	private String program;
	/**
	 Default constructor that creates an empty {@code Student} object.
	 */
	public Student(){}
	/**
	 * Constructs a new {@code Student} with the specified details.
	 * @param name  the name of the student
	 * @param email  the email of the student
	 * @param dob  the date of birth of the student
	 * @param gpa  the gpa of the student
	 * @param section  the section of the student
	 * @param program  the program in which the student is enrolled
	 */
	    public Student(String name,String email,LocalDate dob,double gpa,String section,String program){
	    this.name=name;
	    this.email=email;
	    this.dob=dob;
	    this.gpa=gpa;
	    this.section=section;
	    this.program=program;
	    }
	    /** @return the student ID  */
	    public int getId() {
	        return id;
	    }
        /** @param id the unique ID to set */
	    public void setId(int id) {
	        this.id = id;
	    }
        /** @return the Student name */
	    public String getName() {
	        return name;
	    }
	    /** @param name the name to set*/

	    public void setName(String name) {
	        this.name = name;
	    }
	    /** @return the Student email */
	    public String getEmail() {
	        return email;
	    }
	    /** @param email the email to set*/
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    /** @return the Student date of birth */
	    public LocalDate getDob() {
	        return dob;
	    }
	    /** @param dob the Date of Birth to set*/
	    public void setDob(LocalDate dob) {
	        this.dob = dob;
	    }
	    /** @return the Student date of birth */
	    public double getGpa() {
	        return gpa;
	    }

	    public void setGpa(double gpa) {
	        this.gpa = gpa;
	    }
	    public String getSection() {
	    	return section;
	    }
	    public void setSection(String section) {
	    	this.section=section;
	    }
	    public String getProgram() {
	    	return program;
	    }
	    public void setProgram(String program) {
	    	this.program=program;
	    }
	    /**
	     *@return String the information of the student
	     */
	    public String toString(){
	        return "Student{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", email='" + email + '\'' +
	                ", dob=" + dob +
	                ", gpa=" + gpa +", section="+section+", program="+
	                program+
	                '}';
	    }
}
