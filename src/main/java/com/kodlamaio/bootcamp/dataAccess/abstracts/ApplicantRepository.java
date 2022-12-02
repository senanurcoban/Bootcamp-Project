package com.kodlamaio.bootcamp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcamp.entities.users.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{

	Applicant findByNationalIdentity(String nationalId);
}
