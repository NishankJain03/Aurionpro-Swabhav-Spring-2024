package com.aurionpro.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emlpoyees")
public class Employee {
	@Column(name="employeeId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EmployeeId;
	@Column(name="name")
	private String name;
	@Column(name="salary")
	private double salary;
	
	public Employee() {
		
	}

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(int employeeId, String name, double salary) {
		super();
		EmployeeId = employeeId;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
