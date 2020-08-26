package com.example.controller;

import static com.example.constant.UrlMapping.BASE_URL;
import static com.example.constant.UrlMapping.EMPLOYEE;
import static com.example.constant.UrlMapping.SINGLE_EMPLOYEE;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.Role;
import com.example.dto.EmployeeDto;
import com.example.entity.Employee;
import com.example.service.EmployeeService;
import com.example.util.ResponseMaker;
import com.example.util.SuccessResponse;

@RestController
@RequestMapping(BASE_URL)
public class EmployeeController {

	@Autowired
	private ResponseMaker responseMaker;

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(EMPLOYEE)
	@PreAuthorize(Role.MANAGER)
	public ResponseEntity<SuccessResponse<String>> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto) {

		employeeService.saveEmployee(employeeDto);

		return responseMaker.successResponse("Employee added successfully", HttpStatus.OK);
	}

	@GetMapping(EMPLOYEE)
	@PreAuthorize(Role.MANAGER)
	public ResponseEntity<SuccessResponse<List<Employee>>> allEmployees() {

		List<Employee> employees = employeeService.allEmployees();

		return responseMaker.successResponse(employees, HttpStatus.OK);
	}

	@PutMapping(SINGLE_EMPLOYEE)
	@PreAuthorize(Role.MANAGER)
	public ResponseEntity<SuccessResponse<String>> updateEmployee(@PathVariable String employeeUuid,
			@RequestBody @Valid EmployeeDto employeeDto) {

		employeeService.updateEmployee(employeeUuid, employeeDto);

		return responseMaker.successResponse("Employee details updated successfully", HttpStatus.OK);
	}

	@DeleteMapping(SINGLE_EMPLOYEE)
	@PreAuthorize(Role.MANAGER)
	public ResponseEntity<SuccessResponse<String>> deleteEmployee(@PathVariable String employeeUuid) {

		employeeService.deleteEmployee(employeeUuid);

		return responseMaker.successResponse("Employee deleted successfully", HttpStatus.OK);
	}
}
