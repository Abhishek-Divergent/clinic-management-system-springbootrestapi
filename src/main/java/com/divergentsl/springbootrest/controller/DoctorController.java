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

import com.divergentsl.springbootrest.entity.Doctor;
import com.divergentsl.springbootrest.service.DoctorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/doctor", produces = "application/json")
@CrossOrigin(origins = "*")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	// Fetch All Data FromDoctor Table
	@GetMapping("/")
	private ResponseEntity<List<Doctor>> getAllDoctor() {
		log.info("Doctor List ");
		List<Doctor> list = doctorService.read();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// Delete Data From The Doctor Table
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private void deleteDoctor(@PathVariable int id) {
		doctorService.delete(id);
	}

	// Insert Data into DoctorTable
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private void insertDoctor(@RequestBody Doctor doctor) {
		doctorService.create(doctor);
	}

	// Find Doctor Data
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<Doctor> findDoctor(@PathVariable long id) {
		Doctor doctor = doctorService.findById(id);

		if (doctor != null) {
			return new ResponseEntity<>(doctor, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(doctor, HttpStatus.NOT_FOUND);

		}

	}

	// Update Doctor
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	private void updateDoctor(@RequestBody Doctor doctor) {
		doctorService.update(doctor);
	}

}
