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

	@Override
	public void saveEmployee(EmployeeDto employeeDto) {

		if (employeeDao.isEmployeeExistsByMobile(employeeDto.getMobile())) {
			throw new CustomException("Employee with mobile number " + employeeDto.getMobile() + " already exist",
					ErrorCode.USER_ALREADY_EXIST);
		}

		Employee employee = mapper.convert(employeeDto, Employee.class);

		employee.setEmployeeUuid(generator.generateUUID());

		employeeDao.saveEmployee(employee);
	}

	@Override
	public List<Employee> allEmployees() {

		return null;
	}

	@Override
	public void updateEmployee(String employeeUuid, @Valid EmployeeDto employeeDto) {

	}

	@Override
	public void deleteEmployee(String employeeUuid) {

	}
}
