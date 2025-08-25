package com.swaiba.student.model;

import java.time.LocalDate;

public class Student {
	private int id; private String name;
	private String email;
	private LocalDate dob;
	private double gpa;
	private String section;
	private String program;
	public Student(){}
	    public Student(String name,String email,LocalDate dob,double gpa,String section,String program){
	    this.name=name;
	    this.email=email;
	    this.dob=dob;
	    this.gpa=gpa;
	    this.section=section;
	    this.program=program;
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

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public LocalDate getDob() {
	        return dob;
	    }

	    public void setDob(LocalDate dob) {
	        this.dob = dob;
	    }

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
