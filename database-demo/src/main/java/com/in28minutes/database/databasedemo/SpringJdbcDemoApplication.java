package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(SpringJdbcDemoApplication.class);

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Users -> {}", dao.findAll());

		logger.info("User 10001 -> {}", dao.findById(10001));

		logger.info("Deleting 10002. Number of deleted rows -> {}", dao.deleteById(10002));

		Person person = new Person(10004, "Mariquinhas", "Tasca da Mariquinhas", new Date());
		logger.info("Inserting person {}", dao.insert(person));

		person = new Person(10004, "Maria Mariquinhas", "Tasca da Mariquinhas", new Date());
		logger.info("Updating person {}", dao.update(person));
	}
}
