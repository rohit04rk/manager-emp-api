package com.example.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDao;
import com.example.dto.EmployeeDto;
import com.example.entity.Employee;
import com.example.exception.CustomException;
import com.example.exception.ErrorCode;
import com.example.mapper.Mapper;
import com.example.util.CustomGenerator;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private Mapper mapper;

	@Autowired
	private CustomGenerator generator;

	/**
	 * Adds new employee
	 * 
	 * @param employeeDto details of employee
	 * @exception CustomException If employee with same mobile number already exist
	 * 
	 */
	@Override
	public Employee saveEmployee(EmployeeDto employeeDto) {

		if (employeeDao.isEmployeeExistsByMobile(employeeDto.getMobile())) {
			throw new CustomException("Employee with mobile number " + employeeDto.getMobile() + " already exist",
					ErrorCode.USER_ALREADY_EXIST);
		}

		Employee employee = mapper.convert(employeeDto, Employee.class);

		employee.setEmployeeUuid(generator.generateUUID());

		return employeeDao.saveEmployee(employee);
	}

	/**
	 * All employees details
	 * 
	 * @return list of employees
	 * 
	 */
	@Override
	public List<Employee> allEmployees() {

		return employeeDao.allEmployees();
	}

	/**
	 * All employees details
	 * 
	 * @param employeeUuid Id of employee whose record want to get
	 * @return employee object
	 * 
	 */
	@Override
	public Employee employeeByUuid(String employeeUuid) {

		return employeeDao.findByEmployeeUuid(employeeUuid);
	}

	/**
	 * Update employee details
	 * 
	 * @param employeeUuid Id of employee whose details want to update
	 * @param employeeDto  updated details of employee
	 * @exception CustomException If employee not found for employeeUuid
	 * 
	 */
	@Override
	public Employee updateEmployee(String employeeUuid, @Valid EmployeeDto employeeDto) {

		Employee oldEmployee = employeeDao.findByEmployeeUuid(employeeUuid);

		Employee updatedEmployee = mapper.convert(employeeDto, Employee.class);
		updatedEmployee.setEmployeeId(oldEmployee.getEmployeeId());
		updatedEmployee.setEmployeeUuid(employeeUuid);

		return employeeDao.saveEmployee(updatedEmployee);
	}

	/**
	 * Delete employee
	 * 
	 * @param employeeUuid Id of employee
	 * @exception CustomException If employee not found for employeeUuid
	 * 
	 */
	@Override
	public void deleteEmployee(String employeeUuid) {
		Employee employee = employeeDao.findByEmployeeUuid(employeeUuid);

		employeeDao.deleteEmployee(employee);
	}

}
