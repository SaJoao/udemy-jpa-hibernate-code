package com.in28minutes.jpa.hibernate.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

	private BigDecimal hourlyWage;

	protected FullTimeEmployee() {

	}

	public FullTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	@Override
	public String toString() {
		String str = "Employee [name=" + getName() + ", hourly wage=" + hourlyWage + "]\n";
		return str;
	}

}
