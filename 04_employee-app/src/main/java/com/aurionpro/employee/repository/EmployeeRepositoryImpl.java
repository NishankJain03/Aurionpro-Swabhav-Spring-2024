package com.aurionpro.employee.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.employee.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
	
	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Employee> getAllEmployee() {
		TypedQuery<Employee>query = manager.createQuery("SELECT s from Employee s", Employee.class);
		return query.getResultList();
	}

	@Override
	@Transactional
    public Employee insertEmployeeData(Employee employee) {
        manager.persist(employee);
        return employee;
    }

}
