package com.in28minutes.jpa.hibernate.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
public class NativeQueryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;

	@Test
	public void nativeGetAllCourses() {

		Query namedQuery = em.createNativeQuery("SELECT * FROM COURSE");
		List<Course> resultList = namedQuery.getResultList();

		logger.info("Courses list: {}", resultList);
	}

	@Test
	public void nativeGetCourseById() {

		Query namedQuery = em.createNativeQuery("SELECT * FROM COURSE WHERE ID = ?");
		namedQuery.setParameter(1, 10001L);
		List<Course> resultList = namedQuery.getResultList();

		logger.info("Courses list: {}", resultList);
	}

	@Test
	public void nativeGetCourseById_usingNamedParameter() {

		Query namedQuery = em.createNativeQuery("SELECT * FROM COURSE WHERE ID = :id");
		namedQuery.setParameter("id", 10001L);
		List<Course> resultList = namedQuery.getResultList();

		logger.info("Courses list: {}", resultList);
	}

}
