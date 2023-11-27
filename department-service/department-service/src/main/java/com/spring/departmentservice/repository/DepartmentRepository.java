package com.spring.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);
}
