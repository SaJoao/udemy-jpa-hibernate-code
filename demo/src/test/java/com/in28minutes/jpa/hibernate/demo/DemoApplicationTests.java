package com.in28minutes.jpa.hibernate.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);
	
	@Autowired
	private CourseRepository repository;
	
	@Test
	public void findById_basic() {
		
		Course course = repository.findById(10001L);
		
		assertEquals("JPA in 50 steps", course.getName());
	}

}
