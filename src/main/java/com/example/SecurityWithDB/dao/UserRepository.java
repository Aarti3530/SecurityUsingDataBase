package com.example.SecurityWithDB.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SecurityWithDB.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);

}
