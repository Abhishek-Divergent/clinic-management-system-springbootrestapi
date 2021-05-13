package com.divergentsl.springbootrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.springbootrest.dao.ApplicationDao;
import com.divergentsl.springbootrest.entity.Doctor;

@Service
public class DoctorImpl implements DoctorService {

	@Autowired
	private ApplicationDao<Doctor> applicationDoa;

	@Transactional
	@Override
	public void create(Doctor doctor) {
		applicationDoa.create(doctor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Doctor> read() {
		return applicationDoa.read();
	}

	@Transactional
	@Override
	public boolean delete(int id) {
		Doctor doctor = findById(id);
		if (doctor != null) {
			applicationDoa.delete(doctor);
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	@Override
	public void update(Doctor doctor) {
		applicationDoa.update(doctor);
	}

	@Transactional(readOnly = true)
	@Override
	public Doctor findById(long id) {
		return applicationDoa.findById(id);
	}

}
