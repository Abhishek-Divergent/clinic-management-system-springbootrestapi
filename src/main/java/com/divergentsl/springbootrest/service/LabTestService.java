package com.divergentsl.springbootrest.service;

import java.util.List;

import com.divergentsl.springbootrest.entity.Labtest;

public interface LabTestService {
	void create(Labtest Labtest);

	void update(Labtest labtest);

	List<Labtest> read();

	boolean delete(int deleteid);

	Labtest findById(long id);
}
