package com.in28minutes.jpa.hibernate.demo;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PerformanceTunningTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;

	@Test
	@Transactional
	public void creatingNPlusOneProblem() {

		List<Course> resultList = em.createNamedQuery("query_get_all_courses", Course.class).getResultList();

		for (Course course : resultList) {
			logger.info("Course:{} Students:{}", course, course.getStudents());
		}
	}

	@Test
	@Transactional
	public void solvingNPlusOneProblem_EntityGraph() {
		// HINT !
		EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
		entityGraph.addSubgraph("students");

		List<Course> resultList = em.createNamedQuery("query_get_all_courses", Course.class)
				.setHint("javax.persistence.loadgraph", entityGraph).getResultList();

		for (Course course : resultList) {
			logger.info("Course:{} Students:{}", course, course.getStudents());
		}
	}

	@Test
	@Transactional
	public void solvingNPlusOneProblem_JoinFecth() {
		// JOIN FECT - implies creating a specific named query
		List<Course> resultList = em.createNamedQuery("query_get_all_courses_join_fetch", Course.class).getResultList();

		for (Course course : resultList) {
			logger.info("Course:{} Students:{}", course, course.getStudents());
		}
	}

}
