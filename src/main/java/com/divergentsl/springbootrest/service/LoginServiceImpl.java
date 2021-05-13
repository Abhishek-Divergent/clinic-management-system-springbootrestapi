package com.divergentsl.springbootrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.springbootrest.dao.LogInDao;
import com.divergentsl.springbootrest.entity.Admin;
import com.divergentsl.springbootrest.entity.Doctor;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LogInDao logInDao;

	@Override
	public List<Admin> adminRead() {
		return logInDao.adminRead();
	}

	@Override
	public List<Doctor> doctorRead() {
		return logInDao.doctorRead();
	}

}
