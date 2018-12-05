package com.in28minutes.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	// ONE-TO-ONE relationships are EAGERLY fetched by default (retrieving the
	// student also retrieves the passport). Fetch type LAZY changes this behavior.
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;

	protected Student() {
		// Needed by JPA
	}

	public Student(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		String str = "Student [id=" + id + ", name=" + name + "]\n";
		return str;
	}

}
