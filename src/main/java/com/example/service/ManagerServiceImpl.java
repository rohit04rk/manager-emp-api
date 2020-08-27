package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.ManagerDao;
import com.example.dto.ManagerDto;
import com.example.entity.Manager;
import com.example.exception.CustomException;
import com.example.exception.ErrorCode;
import com.example.mapper.Mapper;
import com.example.security.AuthToken;
import com.example.security.JwtTokenUtil;
import com.example.util.CustomGenerator;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;

	@Autowired
	private Mapper mapper;

	@Autowired
	private CustomGenerator generator;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	/**
	 * Adds new manager
	 * 
	 * @param managerDto details of manager
	 * @exception CustomException If manager with same email id already exist
	 * 
	 * */
	@Override
	public void saveManager(ManagerDto managerDto) {

		if (managerDao.isManagerExistsByEmail(managerDto.getEmail())) {
			throw new CustomException("Manager with Email id " + managerDto.getEmail() + " already exist",
					ErrorCode.USER_ALREADY_EXIST);
		}

		Manager manager = mapper.convert(managerDto, Manager.class);

		manager.setManagerUuid(generator.generateUUID());
		manager.setPassword(passwordEncoder.encode(managerDto.getPassword()));

		managerDao.saveManager(manager);
	}

	/**
	 * Adds new manager
	 * 
	 * @param authentication spring security authentication object
	 * @return JWT token 
	 * 
	 * */
	@Override
	public AuthToken managerLogin(Authentication authentication) {

		String token = jwtTokenUtil.generateToken(authentication);

		return new AuthToken(token);
	}
}
