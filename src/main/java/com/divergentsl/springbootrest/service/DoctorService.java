package com.divergentsl.springbootrest.service;

import java.util.List;

import com.divergentsl.springbootrest.entity.Doctor;

public interface DoctorService {

	void create(Doctor doctor);

	List<Doctor> read();

	boolean delete(int id);

	void update(Doctor doctor);

	Doctor findById(long id);
}
