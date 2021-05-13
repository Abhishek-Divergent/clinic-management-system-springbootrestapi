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

import com.divergentsl.springbootrest.entity.Appointment;
import com.divergentsl.springbootrest.service.AppointmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/appointment", produces = "application/json")
@CrossOrigin(origins = "*")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;

	// Fetch All Data From Appointment Table
	@GetMapping("/")
	private ResponseEntity<List<Appointment>> getAllAppointment() {
		log.info("Appoitment List ");
		List<Appointment> list = appointmentService.read();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// Delete Data From The Appointment Table
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private void deleteAppointment(@PathVariable int id) {
		appointmentService.remove(id);
	}

	// Insert Data into Appointment Table
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private void insertAppointment(@RequestBody Appointment appointment) {
		appointmentService.create(appointment);
	}

	// Find Appointment Data
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<Appointment> findAppointment(@PathVariable long id) {
		Appointment appointment = appointmentService.findById(id);

		if (appointment != null) {
			return new ResponseEntity<>(appointment, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(appointment, HttpStatus.NOT_FOUND);

		}

	}

	// Update Appointment
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	private void updateAppointment(@RequestBody Appointment appointment) {
		appointmentService.update(appointment);
	}

}
