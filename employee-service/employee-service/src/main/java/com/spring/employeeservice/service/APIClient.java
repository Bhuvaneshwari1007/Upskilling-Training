package com.spring.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.employeeservice.dto.DepartmentDto;
@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {
	//Build get department rest api
    @GetMapping("/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}
