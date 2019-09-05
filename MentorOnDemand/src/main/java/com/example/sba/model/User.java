package com.example.sba.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//import sid from Technology.java  for registration of any course.
   
 
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Email
    @Column(name="email")
    private String email;

    @NotNull
    private String password;
    
    @Column(name = "contact_number")
    private Long contactNumber;

    @Column(name = "reg_datetime")
    private String regDatetime ;
    
    @NotNull
    @Column(name = "reg_code")
    private double regCode;
    
    @Column(name="address")
    private String address;
    
    public Long getId() {
		return id;
	}

	public User( @NotNull String firstName, String lastName, @NotNull @Email String email,
			@NotNull String password, Long contactNumber, String regDatetime, @NotNull @NotNull double regCode, String address) {
		super();
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
		this.regDatetime = regDatetime;
		this.regCode = regCode;
		this.address = address;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRegDatetime() {
		return regDatetime;
	}

	public void setRegDatetime(String regDatetime) {
		this.regDatetime = regDatetime;
	}

	public  double getRegCode() {
		return regCode;
	}

	public void setRegCode(double regCode) {
		this.regCode = regCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
