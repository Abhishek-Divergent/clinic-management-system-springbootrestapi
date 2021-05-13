package com.divergentsl.springbootrest.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.divergentsl.springbootrest.entity.Admin;
import com.divergentsl.springbootrest.entity.Doctor;

@Repository
public class LoginDaoImpl implements LogInDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Admin> adminRead() {
		CriteriaQuery<Admin> criteriaQuery = em.getCriteriaBuilder().createQuery(Admin.class);
		@SuppressWarnings("unused")
		Root<Admin> root = criteriaQuery.from(Admin.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<Doctor> doctorRead() {
		CriteriaQuery<Doctor> criteriaQuery = em.getCriteriaBuilder().createQuery(Doctor.class);
		@SuppressWarnings("unused")
		Root<Doctor> root = criteriaQuery.from(Doctor.class);
		return em.createQuery(criteriaQuery).getResultList();
	}
}
