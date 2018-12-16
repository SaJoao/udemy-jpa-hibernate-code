package com.in28minutes.jpa.hibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.repository.EmployeeRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	private CourseRepository courseRep;

	@Autowired
	private StudentRepository studentRep;

	@Autowired
	private EmployeeRepository employeeRep;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// studentRep.saveStudentWithPassport();

		// List<Review> reviews = new ArrayList<>();
		// reviews.add(new Review("5", "Great hands-on stuff"));
		// reviews.add(new Review("5", "Hatsoff"));
		// courseRep.addReviewsForCourse(10003L, reviews);

		// studentRep.insertStudentAndCourse(new Student("Jack"), new
		// Course("Microservices in 100 steps"));

		// employeeRep.insert(new FullTimeEmployee("Jack", new BigDecimal(10000)));
		// employeeRep.insert(new PartTimeEmployee("Jill", new BigDecimal(50)));
		//
		// logger.info("All employees: {}", employeeRep.retrieveAllEmployees());

	}
}
