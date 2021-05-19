package com.accenture.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.demo.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	//abstract method for searching by firstname
	User findByFirstName(String firstName);
}
