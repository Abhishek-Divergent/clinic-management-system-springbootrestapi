package com.divergentsl.springbootrest.service;

import java.util.List;

import com.divergentsl.springbootrest.entity.Drugs;

public interface DrugsService {
	void create(Drugs drugs);

	List<Drugs> read();

	boolean delete(int id);

	void update(Drugs drugs);

	Drugs findById(long id);
}
