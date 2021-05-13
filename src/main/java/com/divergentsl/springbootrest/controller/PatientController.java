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

import com.divergentsl.springbootrest.entity.Patient;
import com.divergentsl.springbootrest.service.PatientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/patient", produces = "application/json")
@CrossOrigin(origins = "*")
public class PatientController {
	@Autowired
	private PatientService patientService;

	// Fetch All Data From Patient Table
	@GetMapping("/")
	private ResponseEntity<List<Patient>> getAllPatient() {
		log.info("Patient List ");
		List<Patient> list = patientService.read();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// Delete Data From The Patient Table
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private void deletePatient(@PathVariable long id) {
		patientService.delete(id);
	}

	// Insert Data into Patient Table
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private void insertPatient(@RequestBody Patient patient) {
		patientService.create(patient);
	}

	// Find Patient Data
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<Patient> findPatient(@PathVariable long id) {
		Patient patient = patientService.findById(id);

		if (patient != null) {
			return new ResponseEntity<>(patient, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(patient, HttpStatus.NOT_FOUND);

		}

	}

	// Update Patient
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	private void updatePatient(@RequestBody Patient patient) {
		patientService.update(patient);
	}

}
