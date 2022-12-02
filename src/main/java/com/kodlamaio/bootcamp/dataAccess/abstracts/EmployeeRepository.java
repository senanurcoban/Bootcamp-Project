package com.kodlamaio.bootcamp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcamp.entities.users.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByNationalIdentity(String nationalIdentity);
}
