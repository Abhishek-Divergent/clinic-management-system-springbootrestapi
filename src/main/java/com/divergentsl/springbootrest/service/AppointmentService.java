package com.divergentsl.springbootrest.service;

import java.util.List;

import com.divergentsl.springbootrest.entity.Appointment;

public interface AppointmentService {
	
	void create(Appointment appointment);

	List<Appointment> read();

	boolean remove(int id);

	void  update(Appointment appointment);

	Appointment findById(long id);
}
