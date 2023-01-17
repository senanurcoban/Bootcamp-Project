package com.kodlamaio.bootcamp.dataAccess.applications;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kodlamaio.bootcamp.entities.applications.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer>{
	Application findByApplicantId(int id);

	//boolean existsByNationalIdentity(String nationalIdentity);
}