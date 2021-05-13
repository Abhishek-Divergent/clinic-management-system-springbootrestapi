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
@Table(name = "priscription")
public class Priscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = " priscription")
	private String priscription;
	@Column(name = "note")
	private String note;
	@Column(name = "patient_id")
	private long patient_id;
	@Column(name = "doctor_id")
	private long doctor_id;

	public Priscription() {
		super();
	}

}
