package com.divergentsl.springbootrest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.springbootrest.dao.ApplicationDao;
import com.divergentsl.springbootrest.entity.Drugs;

@Service
public class DrugsImpl implements DrugsService {

	@Autowired
	private ApplicationDao<Drugs> applicationDao;

	@Transactional
	@Override
	public void create(Drugs drugs) {
		applicationDao.create(drugs);
	}

	@Override
	public List<Drugs> read() {
		return applicationDao.read();
	}

	@Transactional
	@Override
	public boolean delete(int id) {
		Drugs drugs = findById(id);
		if (drugs != null) {
			applicationDao.delete(drugs);
			return true;
		} else {
			return false;
		}

	}

	@Transactional
	@Override
	public void update(Drugs drugs) {
		applicationDao.update(drugs);
	}

	@Override
	public Drugs findById(long id) {
		return applicationDao.findById(id);
	}

}