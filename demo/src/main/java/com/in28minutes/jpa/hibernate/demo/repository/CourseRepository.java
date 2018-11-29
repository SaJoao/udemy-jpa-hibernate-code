package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplicationTests;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	public Course findById(Long id) {

		return em.find(Course.class, id);
	}

	public void save (Course course) {
		if(course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
	}
	
	public void deleteById(Long id) {

		Course course = findById(id);
		em.remove(course);
	}
	
	public void playWithEntityManager() {
		
		logger.info("play with entity manager  - start");
		
		Course course1 = new Course("Web services in 100 steps");
		Course course2 = new Course("Angular JS in 100 steps");
		
		em.persist(course1);
		em.persist(course2);
		em.flush();
		
		course1.setName("Web services in 100 steps - updated");
		course2.setName("Angular JS in 100 steps - updated");
		
		em.refresh(course1);
		
		em.flush();
	}
}
