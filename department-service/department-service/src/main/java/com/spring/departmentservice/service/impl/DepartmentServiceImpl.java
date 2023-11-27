package com.spring.departmentservice.service.impl;

import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;

import com.spring.departmentservice.dto.DepartmentDto;
import com.spring.departmentservice.entity.Department;
import com.spring.departmentservice.mapper.DepartmentMapper;
import com.spring.departmentservice.repository.DepartmentRepository;
import com.spring.departmentservice.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }
}
