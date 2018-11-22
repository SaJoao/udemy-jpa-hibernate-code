package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(SpringJpaDemoApplication.class);

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("User 10001 -> {}", repository.findById(10001));

		repository.deleteById(10002);

		Person person = new Person("Mariquinhas", "Tasca da Mariquinhas", new Date());
		logger.info("Inserting person {}", repository.insert(person));

		person = new Person(1, "Maria Mariquinhas", "Tasca da Mariquinhas", new Date());
		logger.info("Updating person {}", repository.update(person));

		logger.info("Users -> {}", repository.findAll());

	}
}
