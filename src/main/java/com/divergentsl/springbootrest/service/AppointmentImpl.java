package com.divergentsl.springbootrest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.springbootrest.dao.ApplicationDao;
import com.divergentsl.springbootrest.entity.Appointment;

/**
 * in this is class admin will appoint a doctor to patient
 * 
 * @author JAI MAHAKAL
 *
 */
@Service
public class AppointmentImpl implements AppointmentService {

	@Autowired
	private ApplicationDao<Appointment> applicationDoa;

	@Transactional
	@Override
	public void create(Appointment appointment) {
		applicationDoa.create(appointment);
	}

	@Override
	public List<Appointment> read() {
		return applicationDoa.read();
	}

	@Transactional
	@Override
	public boolean remove(int id) {
		Appointment appointment = findById(id);
		if (appointment != null) {
			applicationDoa.delete(appointment);
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	@Override
	public void update(Appointment appointment) {
		applicationDoa.update(appointment);
	}

	@Override
	public Appointment findById(long id) {
		return applicationDoa.findById(id);
	}

}
