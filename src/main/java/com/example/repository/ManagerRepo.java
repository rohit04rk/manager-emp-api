package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Long> {

	boolean existsByEmail(String email);

	Manager findByEmail(String email);
}
