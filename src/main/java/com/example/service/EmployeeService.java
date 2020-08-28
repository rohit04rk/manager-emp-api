package com.example.service;

import java.util.List;

import javax.validation.Valid;

import com.example.dto.EmployeeDto;
import com.example.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(EmployeeDto employeeDto);

	List<Employee> allEmployees();

	Employee updateEmployee(String employeeUuid, @Valid EmployeeDto employeeDto);

	void deleteEmployee(String employeeUuid);

	Employee employeeByUuid(String employeeUuid);
}
