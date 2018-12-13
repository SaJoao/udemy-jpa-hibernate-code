package com.in28minutes.jpa.hibernate.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

	private BigDecimal wage;

	protected PartTimeEmployee() {

	}

	public PartTimeEmployee(String name, BigDecimal wage) {
		super(name);
		this.wage = wage;
	}

	@Override
	public String toString() {
		String str = "Employee [name=" + getName() + ", hourly wage=" + wage + "]\n";
		return str;
	}

}
