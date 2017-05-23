package com.amirbhujel.DemoHib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	
	@Id
	private int lId;
	private String lName;
	
	@ManyToOne
	private Student student;
	
	@ManyToMany
	private List<Student> students = new ArrayList<Student>();
	
	
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	@Override
	public String toString() {
		return "Laptop [lId=" + lId + ", lName=" + lName + "]";
	}

}
