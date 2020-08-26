package com.example.dao;

import com.example.entity.Employee;

public interface EmployeeDao {

	void saveEmployee(Employee employee);

	boolean isEmployeeExistsByMobile(String mobile);

}
