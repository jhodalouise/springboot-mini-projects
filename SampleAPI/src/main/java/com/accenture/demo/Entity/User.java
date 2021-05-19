package com.accenture.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Prepare the User class to be mappable to JPA
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstname") //firstName == first_name
	private String firstName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="age")
	private int age;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	//excluded id because I want the API to auto increment ID
	public User(String firstName, String email, int age) {
		super();
		this.firstName = firstName;
		this.email = email;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
