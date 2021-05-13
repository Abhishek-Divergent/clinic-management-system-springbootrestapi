package com.divergentsl.springbootrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.springbootrest.dao.ApplicationDao;
import com.divergentsl.springbootrest.entity.Patient;

@Service
public class PatientImpl implements PatientService {
	@Autowired
	private ApplicationDao<Patient> applicationDoa;

	@Transactional
	@Override
	public void create(Patient patient) {
		applicationDoa.create(patient);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Patient> read() {
		return applicationDoa.read();
	}

	@Transactional
	@Override
	public boolean delete(long Id) {
		Patient patient = findById(Id);
		if (patient != null) {
			applicationDoa.delete(patient);
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Patient findById(long id) {
		return applicationDoa.findById(id);
	}

	@Transactional
	@Override
	public void update(Patient patient) {
		applicationDoa.update(patient);

	}
}