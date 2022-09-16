package com.javaguide.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaguide.springboot.exception.ResourceNotFoundException;
import com.javaguide.springboot.model.Employee;
import com.javaguide.springboot.repository.EmployeeRepository;
import com.javaguide.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if (employee.isPresent()) {
//			return employee.get();
//		} else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		
		return employeeRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Employee", "Id", id));
				
	}

	@Override
	public Employee updateEmpoyee(Employee employee, long id) {
	
		// check if the employee exists
		Employee existingEmployee =  employeeRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		// save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

};