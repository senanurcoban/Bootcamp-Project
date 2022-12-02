package com.kodlamaio.bootcamp.entities.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlamaio.bootcamp.entities.applications.Application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="applicants")
public class Applicant extends User {

	
	
	@Column(name="about")
	private String about;
	
	@OneToMany(mappedBy="applicant")
	private List<Application> applications;

	
}
