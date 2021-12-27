package com.eureka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eureka.entity.VaccinationCenter;

@Repository
public interface CenterRepository extends JpaRepository<VaccinationCenter,Integer> {

}
