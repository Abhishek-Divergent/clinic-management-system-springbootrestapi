package com.divergentsl.springbootrest.dao;

import java.util.List;

import com.divergentsl.springbootrest.entity.Admin;
import com.divergentsl.springbootrest.entity.Doctor;



public interface LogInDao {
    List<Admin>  adminRead();
    List<Doctor> doctorRead();
}
