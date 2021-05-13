package com.divergentsl.springbootrest.service;

import java.util.List;

import com.divergentsl.springbootrest.entity.Patient;

public interface PatientService {
	void create(Patient patient);

	List<Patient> read();

	boolean delete(long id);

	Patient findById(long id);

	void update(Patient patient);
}
