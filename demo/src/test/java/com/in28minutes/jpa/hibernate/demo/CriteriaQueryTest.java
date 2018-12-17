package com.in28minutes.jpa.hibernate.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
public class CriteriaQueryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;

	@Test
	public void all_courses() {

		// 1. Use criteria builder to create a Criteria Query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define predicates using Criteria Builder

		// 4. Add predicates to the Criteria Query

		// 5. Build the typed query from the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();

		logger.info("Courses list: {}", resultList);
	}

	@Test
	public void all_courses_having_100steps() {

		// 1. Use criteria builder to create a Criteria Query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define predicates using Criteria Builder
		Predicate like = cb.like(courseRoot.get("name"), "%100 Steps");

		// 4. Add predicates to the Criteria Query
		cq.where(like);

		// 5. Build the typed query from the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();

		logger.info("Courses list: {}", resultList);
	}

	@Test
	public void all_courses_without_students() {
		// Select c from Course c where c.students is empty

		// 1. Use criteria builder to create a Criteria Query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define predicates using Criteria Builder
		Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));

		// 4. Add predicates to the Criteria Query
		cq.where(studentsIsEmpty);

		// 5. Build the typed query from the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();

		logger.info("Courses list: {}", resultList);
	}

	@Test
	public void join() {
		// Select c from Course c join c.students

		// 1. Use criteria builder to create a Criteria Query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define predicates using Criteria Builder
		Join<Object, Object> join = courseRoot.join("students");

		// 4. Add predicates to the Criteria Query

		// 5. Build the typed query from the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();

		logger.info("Courses list: {}", resultList);
	}

	@Test
	public void left_join() {
		// Select c from Course c join c.students

		// 1. Use criteria builder to create a Criteria Query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define predicates using Criteria Builder
		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);

		// 4. Add predicates to the Criteria Query

		// 5. Build the typed query from the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();

		logger.info("Courses list: {}", resultList);
	}

}
