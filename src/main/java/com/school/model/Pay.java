package com.school.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pay")
public class Pay implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 902266361230049986L;

	public Pay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pay(int id, String student_identifier, String student_name, double amount) {
		super();
		this.id = id;
		this.student_identifier = student_identifier;
		this.student_name = student_name;
		this.amount = amount;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "student_id")
	public String student_identifier;
	
	@Column(name = "student_name")
	private String student_name;
	
	@Column(name = "amount")
	private double amount;

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

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	

}
