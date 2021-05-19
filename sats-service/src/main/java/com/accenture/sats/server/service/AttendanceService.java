package com.accenture.sats.server.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.accenture.sats.server.entity.Learner;
import com.accenture.sats.server.repository.LearnerRepository;

@Service
public class AttendanceService {
	
	private LearnerRepository learnerRepository;
	
	@Autowired
	public AttendanceService(LearnerRepository theLearnerRepository) {
		learnerRepository = theLearnerRepository;
	}
	
	public List<Learner> getLearners(){
		return learnerRepository.findAll();
	}
	
	public Learner timeIn(Learner learner){
		LocalDateTime now = LocalDateTime.now();
		learner.setTimeIn(now);
		learnerRepository.save(learner);
		return learner;
	}
	
//	public Learner timeOut(Learner learner){
//		LocalDateTime now = LocalDateTime.now();
//		Learner theLearner = learnerRepository.findByEid(learner.getEid());
//		theLearner.setEid(theLearner.getEid());
//		theLearner.setTimeIn(theLearner.getTimeIn());
//		theLearner.setTimeOut(now);
//		learner = learnerRepository.save(theLearner);
//		return learner;
//	}
	
	public Learner timeOut(Learner learner){
		LocalDateTime now = LocalDateTime.now();
		Learner theLearner = learnerRepository.findByEid(learner.getEid());
		theLearner.setId(theLearner.getId());
		theLearner.setEid(theLearner.getEid());
		theLearner.setTimeIn(theLearner.getTimeIn());
		theLearner.setTimeOut(now);
//		learner = learnerRepository.save(theLearner);
		return learnerRepository.save(theLearner);
	}
	

	
}
