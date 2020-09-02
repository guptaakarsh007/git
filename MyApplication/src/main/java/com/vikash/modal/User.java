package com.vikash.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Customertable")
public class User {
	
	/*
	 * @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
	 */
	private String username;
	private String firstname;
	private String lastname;
	private int age;
	private String password;
	
	@Id
    //@Pattern(regexp = "[1-9][0-9]{9}", message = "Mobile Number Should be in 10 digits")
	private String contact;
	
	private String email;
	private String address;
	
	
	public User() {
		
	}
	
	
	/*
	 * public User(String username, String firstname, String lastname, int age,
	 * String password) { super(); this.username = username; this.firstname =
	 * firstname; this.lastname = lastname; this.age = age; this.password =
	 * password; }
	 */
	/*
	 * public int getId() { return id; }
	 */
	public User(String username, String firstname, String lastname, int age, String password, String contact,
			String email, String address) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.password = password;
		this.contact = contact;
		this.email = email;
		this.address = address;
	}


	/*
	 * public void setId(int id) { this.id = id; }
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	/*
	 * @Override public String toString() { return "User [id=" + id + ", username="
	 * + username + ", firstname=" + firstname + ", lastname=" + lastname + ", age="
	 * + age + ", password=" + password + "]"; }
	 */


	@Override
	public String toString() {
		return "User [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", age=" + age + ", password=" + password + ", contact=" + contact + ", email=" + email + ", address="
				+ address + "]";
	}
	
	
	
	

}
