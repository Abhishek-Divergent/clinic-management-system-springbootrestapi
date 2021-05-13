package com.divergentsl.springbootrest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.springbootrest.dao.ApplicationDao;
import com.divergentsl.springbootrest.entity.Labtest;

@Service
public class LabTestImpl implements LabTestService {
	@Autowired
	private ApplicationDao<Labtest> applicationDao;

	@Transactional
	@Override
	public void create(Labtest Labtest) {
		applicationDao.create(Labtest);
	}

	@Transactional
	@Override
	public void update(Labtest labtest) {
		applicationDao.update(labtest);
	}

	@Override
	public List<Labtest> read() {
		return applicationDao.read();
	}

	@Transactional
	@Override
	public boolean delete(int deleteid) {
		Labtest labtest = findById(deleteid);
		if (labtest != null) {
			applicationDao.delete(labtest);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Labtest findById(long id) {
		return applicationDao.findById(id);
	}

}
