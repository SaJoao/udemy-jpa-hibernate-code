package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager em;

	@Test
	@Transactional // Cria um PersistenceContext.
	public void someTest() {

		//
		Student student = em.find(Student.class, 20001L);

		Passport passport = student.getPassport();

		passport.setNumber("E123456");

		student.setName("Joao Sa");
	} // Closes the PersistenceContext

	@Test
	@Transactional
	public void retrievStudentAndPassportDetails() {

		Student student = em.find(Student.class, 20001L);
		logger.info("Student: {}", student);
		logger.info("Passport: {}", student.getPassport());
	}

	@Test
	@Transactional
	public void retrievPassportAndAssociatedStudent() {

		Passport passport = em.find(Passport.class, 40001L);
		logger.info("Student: {}", passport);
		logger.info("Passport: {}", passport.getStudent());
	}

}
