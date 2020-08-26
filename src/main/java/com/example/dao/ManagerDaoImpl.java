package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Manager;
import com.example.exception.CustomException;
import com.example.exception.ErrorCode;
import com.example.repository.ManagerRepo;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	private ManagerRepo managerRepo;

	@Override
	public void saveManager(Manager manager) {

		try {
			managerRepo.save(manager);
		} catch (Exception e) {
			throw new CustomException("Error while saving manager", ErrorCode.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public boolean isManagerExistsByEmail(String email) {

		return managerRepo.existsByEmail(email);
	}

	@Override
	public Manager findByEmail(String email) {
		Manager manager = managerRepo.findByEmail(email);

		if (manager != null) {
			return manager;
		} else {
			throw new CustomException("Manager not exist by email id " + email, ErrorCode.MANAGER_NOT_FOUND);
		}

	}
}
