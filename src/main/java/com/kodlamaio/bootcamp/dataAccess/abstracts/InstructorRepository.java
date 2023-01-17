package com.kodlamaio.bootcamp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kodlamaio.bootcamp.entities.users.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

	 Instructor findByNationalIdentity(String nationalId);

}
