package com.kodlamaio.bootcamp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kodlamaio.bootcamp.entities.Bootcamp;


public interface BootcampRepository extends JpaRepository<Bootcamp, Integer> {

}
