package com.school.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "installment_payments")
public class InstallmentPayments {
	

	public InstallmentPayments(int id, String student_identifier, String name, double total_payments, double balance,
			Date date) {
		super();
		this.id = id;
		this.student_identifier = student_identifier;
		this.name = name;
		this.total_payments = total_payments;
		this.balance = balance;
		this.date = date;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "student_id")
	public String student_identifier;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "total_payments")
	private double total_payments;
	
	@Column(name = "balance")
	private double balance;
	
	@Column(name = "date")
	private Date date;

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

	public double getTotal_payments() {
		return total_payments;
	}

	public void setTotal_payments(double total_payments) {
		this.total_payments = total_payments;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
