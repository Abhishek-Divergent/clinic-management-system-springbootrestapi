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
import com.divergentsl.springbootrest.entity.Drugs;
import com.divergentsl.springbootrest.service.DrugsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/drugs", produces = "application/json")
@CrossOrigin(origins = "*")
public class DrugsController {
	@Autowired
	private DrugsService drugsService;

	// Fetch All Data From Drugs Table
	@GetMapping("/")
	private ResponseEntity<List<Drugs>> getAllDrugs() {
		log.info("Drugs List ");
		List<Drugs> list = drugsService.read();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// Delete Data From The Drugs Table
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private void deleteDrugs(@PathVariable int id) {
		drugsService.delete(id);
	}

	// Insert Data into DrugsTable
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private void insertDrugs(@RequestBody Drugs drugs) {
		drugsService.create(drugs);
	}

	// Find Patient Data
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<Drugs> findDrugs(@PathVariable long id) {
		Drugs drugs = drugsService.findById(id);

		if (drugs != null) {
			return new ResponseEntity<>(drugs, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(drugs, HttpStatus.NOT_FOUND);

		}

	}

	// Update Drugs
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	private void updateDrugs(@RequestBody Drugs drugs) {
		drugsService.update(drugs);
	}

}
