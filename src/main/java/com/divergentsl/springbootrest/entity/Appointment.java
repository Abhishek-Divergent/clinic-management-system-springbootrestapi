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
@Table(name = "appoinment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "doctor_name")
	private String doctor_name;

	@Column(name = "patient_name")
	private String patient_name;

	@Column(name = "problem")
	private String problem;
	@Column(name = "date")
	private String date;
	@Column(name = "time")
	private String time;
	@Column(name = "patient_id")
	private long patient_id;
	@Column(name = "doctor_id")
	private long doctor_id;

	public Appointment() {
		super();
	}

	public Appointment(String doctor_name, String patient_name, String problem, String date, String time,
			long patient_id, long doctor_id) {
		super();
		this.doctor_name = doctor_name;
		this.patient_name = patient_name;
		this.problem = problem;
		this.date = date;
		this.time = time;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
	}

}
