package com.hibernate.demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "student_name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="student_details_id")
	private StudentDetails studentDetails;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long id, String name, StudentDetails studentDetails) {
		super();
		this.id = id;
		this.name = name;
		this.studentDetails = studentDetails;
	}

	public Student(String name, StudentDetails studentDetails) {
		super();
		this.name = name;
		this.studentDetails = studentDetails;
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}
