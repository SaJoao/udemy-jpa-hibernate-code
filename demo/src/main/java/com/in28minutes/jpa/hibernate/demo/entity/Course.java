package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Course") // Can be omitted if table name matches the class name
@NamedQueries ( value = {
		@NamedQuery(name="query_get_all_courses", query="select c from Course c"),
		@NamedQuery(name="query_get_100_steps_courses", query="select c from Course c where c.name like '%100 Steps'")
})

public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name", nullable = false)  // Can be omitted if column name matches the field name
	private String name;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	protected Course() {
		// Needed by JPA
	}

	public Course(String name) {
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
		return "Course [id=" + id + ", name=" + name + "]";
	}

}
