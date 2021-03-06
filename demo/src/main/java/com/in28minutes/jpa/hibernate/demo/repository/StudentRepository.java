package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Student findById(Long id) {

		return em.find(Student.class, id);
	}

	public void save(Student student) {
		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
	}

	public void deleteById(Long id) {

		Student student = findById(id);
		em.remove(student);
	}

	public void saveStudentWithPassport() {

		Passport passport = new Passport("Z123456");
		em.persist(passport);

		Student student = new Student("Tino");
		student.setPassport(passport);
		em.persist(student);
	}

	public void insertStudentAndCourse(Student student, Course course) {

		student.addCourse(course);
		course.addStudent(student);

		// To ensure that the relation table is populated we must persist the owning
		// side of the relation
		em.persist(student);
		em.persist(course);
	}

}
