package com.kodlamaio.bootcamp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kodlamaio.bootcamp.entities.BlackList;

public interface BlackListRepository extends JpaRepository<BlackList,Integer>{

	BlackList findByApplicantId(int applicantId);
	
	boolean existsBlacklistByApplicantId(int id);
}
