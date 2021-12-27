package com.eureka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VaccinationCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String centerName;

	private String centerAddress;

	public VaccinationCenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VaccinationCenter(int id, String centerName, String centerAddress) {
		super();
		this.id = id;
		this.centerName = centerName;
		this.centerAddress = centerAddress;
	}

	public int getId() {
		return id;
	}

	public String getCenterName() {
		return centerName;
	}

	public String getCenterAddress() {
		return centerAddress;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}

}
