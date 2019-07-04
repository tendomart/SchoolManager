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
@Table(name = "accounts")
public class Accounts implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6179811725846089159L;

	public Accounts(int id, double totalStudentPayments, String totalStudentDebts, String contact) {
		super();
		this.id = id;
		this.totalStudentPayments = totalStudentPayments;
		this.totalStudentDebts = totalStudentDebts;
		this.contact = contact;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ColumnDefault(value = "1")
	private int id;
	
	@Column(name = "total_student_payments")
	public double totalStudentPayments;
	
	@Column(name = "name")
	private String totalStudentDebts;
	
	@Column(name = "contact", unique = true)
	private String contact;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalStudentPayments() {
		return totalStudentPayments;
	}

	public void setTotalStudentPayments(double totalStudentPayments) {
		this.totalStudentPayments = totalStudentPayments;
	}

	public String getTotalStudentDebts() {
		return totalStudentDebts;
	}

	public void setTotalStudentDebts(String totalStudentDebts) {
		this.totalStudentDebts = totalStudentDebts;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
