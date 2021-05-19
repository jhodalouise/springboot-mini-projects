package com.accenture.sats.server.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="learner")
public class Learner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="eid")
	private String eid;
	
	@Column(name="time_in")
	private LocalDateTime timeIn;
	
	@Column(name="time_out")
	private LocalDateTime timeOut;

	public Learner() {
	}

	public Learner(String eid) {
		this.eid = eid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public LocalDateTime getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(LocalDateTime timeIn) {
		this.timeIn = timeIn;
	}

	public LocalDateTime getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(LocalDateTime timeOut) {
		this.timeOut = timeOut;
	}

	@Override
	public String toString() {
		return "Learner [id=" + id + ", eid=" + eid + ", timeIn=" + timeIn + ", timeOut=" + timeOut + "]";
	}
	
}
