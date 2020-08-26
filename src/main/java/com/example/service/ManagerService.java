package com.example.service;

import org.springframework.security.core.Authentication;

import com.example.dto.ManagerDto;
import com.example.security.AuthToken;

public interface ManagerService {

	void saveManager(ManagerDto managerDto);

	AuthToken managerLogin(Authentication authentication);
}
