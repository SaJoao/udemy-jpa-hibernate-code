package com.in28minutes.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//// SINGLE_TABLE strategy creates a single table with a discriminator column to
//// tell apart the elements from each different concrete classes.
//// Easy to insert and good performance but requires nullable colums because
//// concrete classes will have different sets of atributes
//// The @DiscriminatorColumn is not required, if not specifief the
//// discriminator
//// column is named DTYPE
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "employeeType")

//// TABLE_PER_CLASS strategy creates a table for each concrete class. Easy to
//// insert and good performance (uses UNION) but columns corresponding to
//// common attributes are in all tables
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//// JOINED strategy creates a table for the abstract class and one for each
//// concrete class. Fields that are specific to a subclass are mapped to a
//// separate table.
//// The retrieval requires joins but there are no repeated columns neither
//// nullable columns
//@Inheritance(strategy = InheritanceType.JOINED)

// @Entity

//@MappedSuperclass Designates a class whose mapping information is applied to the entities that inherit from it. 
// A MappedSuperclass has no separate table defined for it. 
// In this case, @Entity must be removed, the class is either Entity or MappedSuperclass.
// In this case two tables unrelated tables are created, to retrieve the employee from both tables a manual query 
// must be created 

@MappedSuperclass
public abstract class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	protected Employee() {
		// Needed by JPA
	}

	public Employee(String name) {
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

	@Override
	public String toString() {
		String str = "Employee [id=" + id + ", name=" + name + "]\n";
		return str;
	}

}
