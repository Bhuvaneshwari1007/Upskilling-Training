package com.spring.employeeservice.service.impl;



import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employeeservice.dto.APIResponseDto;
import com.spring.employeeservice.dto.DepartmentDto;
import com.spring.employeeservice.dto.EmployeeDto;
import com.spring.employeeservice.entity.Employee;
import com.spring.employeeservice.mapper.EmployeeMapper;
import com.spring.employeeservice.repository.EmployeeRepository;
import com.spring.employeeservice.service.APIClient;
import com.spring.employeeservice.service.EmployeeService;


@Service

public class EmployeeServiceImpl implements EmployeeService {
	

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;
@Autowired
    private APIClient apiClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);

        return savedEmployeeDto;
    }

    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
   // @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
 @Override
  public APIResponseDto getEmployeeById(Long employeeId) {

      Employee employee = employeeRepository.findById(employeeId).get();

   
   DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

    EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

       APIResponseDto apiResponseDto = new APIResponseDto();
      apiResponseDto.setEmployee(employeeDto);       
      apiResponseDto.setDepartment(departmentDto);

     return apiResponseDto;
   }



}
