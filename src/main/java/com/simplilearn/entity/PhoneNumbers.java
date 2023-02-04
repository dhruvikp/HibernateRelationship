package com.simplilearn.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone_number")
public class PhoneNumbers {

	@Id
	@GeneratedValue
	@Column(name = "phone_id")
	private int phoneid;
	
	public int getPhoneid() {
		return phoneid;
	}

	public void setPhoneid(int phoneid) {
		this.phoneid = phoneid;
	}

	public String getPhonetype() {
		return phonetype;
	}

	public void setPhonetype(String phonetype) {
		this.phonetype = phonetype;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public JavaStudent getStudent() {
		return student;
	}

	public void setStudent(JavaStudent student) {
		this.student = student;
	}

	@Column(name = "phone_type")
	private String phonetype;
	
	@Column(name = "phone_number")
	private String phonenumber;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	JavaStudent student;
	
}
