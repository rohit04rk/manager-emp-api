package com.example.dao;

import com.example.entity.Manager;

public interface ManagerDao {

	void saveManager(Manager manager);

	boolean isManagerExistsByEmail(String email);

	Manager findByEmail(String email);
}
