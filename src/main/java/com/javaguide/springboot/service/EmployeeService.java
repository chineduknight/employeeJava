package com.javaguide.springboot.service;

import java.util.List;

import com.javaguide.springboot.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(long id);
	Employee updateEmpoyee(Employee employee, long id);

}
