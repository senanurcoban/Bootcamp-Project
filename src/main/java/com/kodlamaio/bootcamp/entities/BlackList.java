package com.kodlamaio.bootcamp.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


import com.kodlamaio.bootcamp.entities.users.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="blacklists")
public class BlackList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="applicant_id")
	private Applicant applicant;
	
	@Column(name="date")
	private LocalDate date;
	@Column(name="reason")
	private String reason;
	
}
