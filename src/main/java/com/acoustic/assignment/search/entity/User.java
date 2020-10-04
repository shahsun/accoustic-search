package com.acoustic.assignment.search.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	
	public User() {
		super();
	}
	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	
	
	

}
