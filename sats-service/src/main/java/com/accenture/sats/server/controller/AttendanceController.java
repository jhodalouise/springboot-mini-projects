package com.accenture.sats.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.sats.server.entity.Learner;
import com.accenture.sats.server.repository.LearnerRepository;
import com.accenture.sats.server.service.AttendanceService;

@RestController
@RequestMapping("/api")
public class AttendanceController {
	
	private AttendanceService attendanceService;
	
	@Autowired
	public AttendanceController(AttendanceService theAttendanceService) {
		attendanceService = theAttendanceService;
	}
	
	// expose "/attendance" and return list of employees
	@GetMapping("/attendance")
	public List<Learner> getLearners(){
		return attendanceService.getLearners();
	}
	
	// setting the timeIn
	@PostMapping("/attendance/timeIn")
	public Learner processTimeIn(@RequestBody Learner learner) {
		attendanceService.timeIn(learner);
		return learner;
		
	}
	
	// setting the timeOut
	@PostMapping("/attendance/timeOut")
	public Learner processTimeOut(@RequestBody Learner learner) {
		
		return attendanceService.timeOut(learner);
		
	}
	

}
