package io.java.springbootapp.customer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Customer {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	@Column(nullable=false)
	String firstname;
	@Column(nullable=false)
	String lastname;
	@Column(nullable=false)
	@JsonFormat(pattern="dd-mm-yyyy")
	Date dob;
	@Column(unique=true,nullable=false)
	String email;
	@Column(nullable=false)
	String password;
	public Customer(){
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", email=" + email + ", password=" + password + "]";
	}
	
	
	

}
