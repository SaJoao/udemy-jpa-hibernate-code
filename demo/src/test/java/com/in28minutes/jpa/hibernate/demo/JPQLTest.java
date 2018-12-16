package com.in28minutes.jpa.hibernate.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;

	@Test
	public void getAllCourses() {

		TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
		List<Course> resultList = query.getResultList();

		logger.info("Courses list: {}", resultList);
	}

	@Test
	public void get100StepsCourses() {

		TypedQuery<Course> query = em.createNamedQuery("query_get_100_steps_courses", Course.class);
		List<Course> resultList = query.getResultList();

		logger.info("Courses list: {}", resultList);
	}

	@Test
	public void jpql_courses_without_students() {

		TypedQuery<Course> query = em.createQuery("select c from Course c where c.students is empty", Course.class);
		List<Course> resultList = query.getResultList();

		logger.info("Courses without students: {}", resultList);
	}

	@Test
	public void jpql_courses_ordered_by_number_of_students() {

		TypedQuery<Course> query = em.createQuery("select c from Course c order by size(c.students)", Course.class);
		List<Course> resultList = query.getResultList();

		logger.info("Courses ordered by number of students: {}", resultList);
	}

	@Test
	public void jpql_students_with_passports_in_a_certain_pattern() {

		TypedQuery<Student> query = em.createQuery("select s from Student s where s.passport.number like '%1234%'",
				Student.class);
		List<Student> resultList = query.getResultList();

		logger.info("Student having passport numbers that include 1234: {}", resultList);
	}

	@Test
	public void join() {

		Query query = em.createQuery("select c, s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();

		logger.info("Number of results (inner) : {}", resultList.size());
		for (Object[] result : resultList) {
			logger.info("Course: {} Student: {}", result[0], result[1]);

		}
	}

	@Test
	public void left_join() {

		Query query = em.createQuery("select c, s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();

		logger.info("Number of results (left) : {}", resultList.size());
		for (Object[] result : resultList) {
			logger.info("Course: {} Student: {}", result[0], result[1]);

		}
	}

	@Test
	public void cross_join() {

		Query query = em.createQuery("select c, s from Course c, Student s");
		List<Object[]> resultList = query.getResultList();

		logger.info("Number of results (cross) : {}", resultList.size());
		for (Object[] result : resultList) {
			logger.info("Course: {} Student: {}", result[0], result[1]);

		}
	}
}
