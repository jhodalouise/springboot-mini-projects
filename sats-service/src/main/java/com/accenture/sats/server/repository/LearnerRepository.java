package com.accenture.sats.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.sats.server.entity.Learner;

public interface LearnerRepository extends JpaRepository<Learner, Long> {
	
	public Learner findByEid(String theEid);
	
	

}
