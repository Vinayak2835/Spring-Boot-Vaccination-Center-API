package com.eureka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eureka.entity.VaccinationCenter;
import com.eureka.model.Citizen;
import com.eureka.model.RequiredResponse;
import com.eureka.repository.CenterRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
@RequestMapping("/vaccination")
public class VaccinationCenterController {

	@Autowired
	private CenterRepository centerRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addVaccinationcenter(@RequestBody VaccinationCenter vaccinationCenter) {

		try {
			centerRepository.save(vaccinationCenter);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	@GetMapping("/id/{id}")
	@HystrixCommand(fallbackMethod="handleCitizenDownTime")
	public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(@PathVariable("id") int id){
		
		RequiredResponse requiredResponse = new RequiredResponse();
		VaccinationCenter center = centerRepository.findById(id).get();
		requiredResponse.setVaccinationCenter(center);
		
		List<Citizen> ListOfcitizens = restTemplate.getForObject("http://localhost:8181/citizen/id/"+id, List.class);
		
		requiredResponse.setCitizens(ListOfcitizens);
		
		return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
		
	}
	
	public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable int id){
		
		RequiredResponse requiredResponse = new RequiredResponse();
		VaccinationCenter center = centerRepository.findById(id).get();
		requiredResponse.setVaccinationCenter(center);
		return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
	}
}
