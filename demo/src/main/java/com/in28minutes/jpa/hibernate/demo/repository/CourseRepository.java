package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Course findById(Long id) {

		return em.find(Course.class, id);
	}

	public void save(Course course) {
		if (course.getId() == null) {
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
		em.persist(course1);

		try {
			Thread.currentThread().sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Course course2 = findById(10002L);
		course2.setName("Angular JS in 100 steps - updated");

	}

	public void addReviewsForCourse(Long courseId, List<Review> reviews) {

		Course course = findById(courseId);
		logger.info("Reviews: {}", course.getReviews());

		for (Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}
	}
}
