package com.example.service;

import java.util.List;

import javax.validation.Valid;

import com.example.dto.EmployeeDto;
import com.example.entity.Employee;

public interface EmployeeService {

	void saveEmployee(EmployeeDto employeeDto);

	List<Employee> allEmployees();

	void updateEmployee(String employeeUuid, @Valid EmployeeDto employeeDto);

	void deleteEmployee(String employeeUuid);
}
