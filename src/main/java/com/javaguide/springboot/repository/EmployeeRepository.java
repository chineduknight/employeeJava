package com.javaguide.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguide.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
