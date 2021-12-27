package com.eureka.model;

import java.util.List;

import com.eureka.entity.VaccinationCenter;

public class RequiredResponse {
	
	private VaccinationCenter vaccinationCenter;
	
	private List<Citizen> citizens;

	public RequiredResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequiredResponse(VaccinationCenter vaccinationCenter, List<Citizen> citizens) {
		super();
		this.vaccinationCenter = vaccinationCenter;
		this.citizens = citizens;
	}

	public VaccinationCenter getVaccinationCenter() {
		return vaccinationCenter;
	}

	public List<Citizen> getCitizens() {
		return citizens;
	}

	public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}

	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
}
