package com.in28minutes.jpa.hibernate.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;

	@Test
	public void getAllCourses() {

		TypedQuery<Course> namedQuery = em.createNamedQuery("query_get_all_courses", Course.class);
		List<Course> resultList = namedQuery.getResultList();

		logger.info("Courses list: {}", resultList);
	}

	@Test
	public void get100StepsCourses() {

		TypedQuery<Course> namedQuery = em.createNamedQuery("query_get_100_steps_courses", Course.class);
		List<Course> resultList = namedQuery.getResultList();

		logger.info("Courses list: {}", resultList);
	}

}
