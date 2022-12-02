package com.kodlamaio.bootcamp.entities.users;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="employees")
public class Employee  extends User{

	
	
	@Column(name="position")
	private String position;
	
	

}
