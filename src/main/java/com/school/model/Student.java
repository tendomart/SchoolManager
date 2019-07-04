package com.school.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "student")
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3953682961744769243L;

	public Student(int id, String student_identifier, String name, String term, String gender, String contact,
			String class_level, boolean status) {
		super();
		this.id = id;
		this.student_identifier = student_identifier;
		this.name = name;
		this.term = term;
		this.gender = gender;
		this.contact = contact;
		this.class_level = class_level;
		this.status = status;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ColumnDefault(value = "1")
	private int id;
	
	@Column(name = "student_id", unique = true)
	public String student_identifier;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "term")
	private String term;
	
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "contact", unique = true)
	private String contact;
	
	@Column(name = "class_level")
	private String class_level;
	
	@Column(name = "status")
	private boolean status = true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudent_identifier() {
		return student_identifier;
	}

	public void setStudent_identifier(String student_identifier) {
		this.student_identifier = student_identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getClass_level() {
		return class_level;
	}

	public void setClass_level(String class_level) {
		this.class_level = class_level;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

		
}
