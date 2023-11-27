package com.spring.employeeservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.employeeservice.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
