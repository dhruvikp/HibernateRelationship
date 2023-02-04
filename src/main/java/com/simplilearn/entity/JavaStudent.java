package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "student_2")
public class JavaStudent {

	
	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private int id;
	
	@Column(name = "first_name")
	private String fname;
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Column(name = "last_name")
	private String lname;
	
	@OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
	List<PhoneNumbers> phonenumbers;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public List<PhoneNumbers> getPhonenumbers() {
		return phonenumbers;
	}

	public void setPhonenumbers(List<PhoneNumbers> phonenumbers) {
		this.phonenumbers = phonenumbers;
	}

	
	
}
