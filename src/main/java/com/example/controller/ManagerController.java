package com.example.controller;

import static com.example.constant.UrlMapping.BASE_URL;
import static com.example.constant.UrlMapping.LOGIN;
import static com.example.constant.UrlMapping.SIGNUP;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ManagerDto;
import com.example.model.UserCredential;
import com.example.security.AuthToken;
import com.example.service.ManagerService;
import com.example.util.ResponseMaker;
import com.example.util.SuccessResponse;

@RestController
@RequestMapping(BASE_URL)
public class ManagerController {

	@Autowired
	private ResponseMaker responseMaker;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private ManagerService managerService;

	@PostMapping(SIGNUP)
	public ResponseEntity<SuccessResponse<String>> saveManager(@RequestBody @Valid ManagerDto managerDto) {

		managerService.saveManager(managerDto);

		return responseMaker.successResponse("Manager added successfully", HttpStatus.CREATED);
	}

	@PostMapping(LOGIN)
	public ResponseEntity<SuccessResponse<AuthToken>> managerLogin(@RequestBody @Valid UserCredential credential) {

		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(credential.getEmail(), credential.getPassword()));

		AuthToken authToken = managerService.managerLogin(authentication);

		return responseMaker.successResponse(authToken, HttpStatus.OK);
	}

}
