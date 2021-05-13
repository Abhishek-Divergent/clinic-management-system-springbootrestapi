package com.divergentsl.springbootrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "contact")
	private String contact;

	@Column(name = "speciality")
	private String speciality;

	@Column(name = "fees")
	private long fees;

	public Doctor() {
		super();
	}

	public Doctor(String username, String password, String name, String contact, String speciality, long fees) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.contact = contact;
		this.speciality = speciality;
		this.fees = fees;
	}
}
