package com.in28minutes.jpa.hibernate.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	@Test
	public void findById_basic() {
		
		Course course = repository.findById(10001L);
		
		assertEquals("JPA in 50 steps", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {
				
		Course course = repository.findById(10001L);
				course.setName("JPA in 50 steps - Updated");
		repository.save(course);
		course = repository.findById(10001L);

		assertEquals("JPA in 50 steps - Updated", course.getName());
	}
	
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		
		repository.deleteById(10002L);
		
		Course course = repository.findById(10002L);
		
		assertNull(course);
	}

	
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		
		repository.playWithEntityManager();
		
	}

}
