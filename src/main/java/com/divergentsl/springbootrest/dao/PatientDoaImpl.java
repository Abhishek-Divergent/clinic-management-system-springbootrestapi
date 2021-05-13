package com.divergentsl.springbootrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergentsl.springbootrest.entity.Patient;

/**
 * this patient DAO will contain method which will perfrom all CRUD operation
 * 
 * @author JAI MAHAKAL
 *
 */
@Repository
public class PatientDoaImpl implements ApplicationDao<Patient> {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Patient patient) {
		em.persist(patient);
	}

	@Override
	public List<Patient> read() {
		CriteriaQuery<Patient> criteriaQuery = em.getCriteriaBuilder().createQuery(Patient.class);
		@SuppressWarnings("unused")
		Root<Patient> root = criteriaQuery.from(Patient.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public void delete(Patient patient) {
		em.remove(patient);
	}

	@Override
	public void update(Patient patient) {
		em.merge(patient);
	}

	@Override
	public Patient findById(long id) {
		Patient patient = em.find(Patient.class, id);
		return patient;
	}

}
