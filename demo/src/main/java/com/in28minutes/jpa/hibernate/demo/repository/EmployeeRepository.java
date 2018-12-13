package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import com.in28minutes.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.demo.entity.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public void insert(Employee employee) {

		em.persist(employee);
	}

	// For SINGLE_TABLE, TABLE_PER_CLASS, or JOINED strategies (see Employee class)
	public List<Employee> retrieveAllEmployees() {

		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}

	// For MappedSuperclass, the abstract class is no longer an @Entity so we can
	// not select from it. In that case we must build a separate method for each
	// concrete class

	public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {

		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}

	public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {

		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}

}
