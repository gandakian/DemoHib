package com.amirbhujel.DemoHib.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="employee_table")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Employee {
	
	@Id
	private int empId;
	private String fName;
	private String lName;
	private String position;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fName=" + fName + ", lName=" + lName + ", position=" + position + "]";
	}
	
	
	

}
