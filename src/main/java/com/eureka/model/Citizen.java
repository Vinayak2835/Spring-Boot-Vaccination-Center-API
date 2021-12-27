package com.eureka.model;

public class Citizen {

	private int id;

	private String name;

	private int vaccinationCenterId;

	public Citizen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Citizen(int id, String name, int vaccinationCenterId) {
		super();
		this.id = id;
		this.name = name;
		this.vaccinationCenterId = vaccinationCenterId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getVaccinationCenterId() {
		return vaccinationCenterId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVaccinationCenterId(int vaccinationCenterId) {
		this.vaccinationCenterId = vaccinationCenterId;
	}

}
