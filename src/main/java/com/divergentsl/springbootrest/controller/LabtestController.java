package com.divergentsl.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.springbootrest.entity.Labtest;
import com.divergentsl.springbootrest.service.LabTestService;

@RestController
@RequestMapping(path = "/api/labtest", produces = "application/json")
@CrossOrigin(origins = "*")
public class LabtestController {
	@Autowired
	private LabTestService labTestService;

	// fetch all data of Labtest Table
	@GetMapping("/")
	private ResponseEntity<List<Labtest>> getLabtest() {
		List<Labtest> list = labTestService.read();
		return new ResponseEntity<List<Labtest>>(list, HttpStatus.OK);
	}

	// Delete Data From The Labtest Table
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private void deleteLabtest(@PathVariable int id) {
		labTestService.delete(id);
	}

	// Insert Data into Labtest Table
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private void insertPatient(@RequestBody Labtest labtest) {
		labTestService.create(labtest);
	}

	// Find Labtest Data
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<Labtest> findPatient(@PathVariable long id) {
		Labtest labtest = labTestService.findById(id);

		if (labtest != null) {
			return new ResponseEntity<>(labtest, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(labtest, HttpStatus.NOT_FOUND);

		}

	}

	// Update Labtest
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	private void updatePatient(@RequestBody Labtest labtest) {
		labTestService.update(labtest);
	}

}
