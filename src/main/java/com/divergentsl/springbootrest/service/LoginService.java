package com.divergentsl.springbootrest.service;

import java.util.List;

import com.divergentsl.springbootrest.entity.Admin;
import com.divergentsl.springbootrest.entity.Doctor;

public interface LoginService {
	List<Admin> adminRead();

	List<Doctor> doctorRead();
}
