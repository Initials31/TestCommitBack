package com.apside.prono.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.apside.prono.model.Contest;



@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String label;
	private Date eventDate;
	private Date openDate;
	private Date closeDate;
	private double coeff;
	
	@ManyToOne
	private Contest contest;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public double getCoeff() {
		return coeff;
	}
	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}
	public Contest getContest() {
		return contest;
	}
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	
	

}
