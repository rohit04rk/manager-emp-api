package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;
import com.example.exception.CustomException;
import com.example.exception.ErrorCode;
import com.example.repository.EmployeeRepo;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public void saveEmployee(Employee employee) {

		try {
			employeeRepo.save(employee);
		} catch (Exception e) {
			throw new CustomException("Error while saving employee", ErrorCode.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public boolean isEmployeeExistsByMobile(String mobile) {

		return employeeRepo.existsByMobile(mobile);
	}

	@Override
	public List<Employee> allEmployees() {

		return employeeRepo.findAll();
	}

	@Override
	public Employee findByEmployeeUuid(String employeeUuid) {

		Employee employee = employeeRepo.findByEmployeeUuid(employeeUuid);

		if (employee != null) {
			return employee;
		} else {
			throw new CustomException("Employee not found with uuid " + employeeUuid, ErrorCode.NOT_FOUND);
		}
	}

	@Override
	public void deleteEmployee(Employee employee) {

		try {
			employeeRepo.delete(employee);
		} catch (Exception e) {
			throw new CustomException("Error while deleting employee", ErrorCode.INTERNAL_SERVER_ERROR);
		}

	}
}
