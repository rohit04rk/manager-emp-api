package com.example.dao;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeDao {

	void saveEmployee(Employee employee);

	boolean isEmployeeExistsByMobile(String mobile);

	List<Employee> allEmployees();

	Employee findByEmployeeUuid(String employeeUuid);

	void deleteEmployee(Employee employee);
}
