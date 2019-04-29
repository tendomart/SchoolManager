package com.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "student")
public class Student {
	public Student(int id, String student_identifier, String name, String contact, String class_level, boolean status) {
		super();
		this.id = id;
		this.student_identifier = student_identifier;
		this.name = name;
		this.contact = contact;
		this.class_level = class_level;
		this.status = status;
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
	
	@Column(name = "contact", unique = true)
	private String contact;
	
	@Column(name = "class_level", unique = true)
	private String class_level;
	
	@Column(name = "status", unique = true)
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
