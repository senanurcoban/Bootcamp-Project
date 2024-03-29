package com.kodlamaio.bootcamp.entities.applications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.kodlamaio.bootcamp.entities.Bootcamp;
import com.kodlamaio.bootcamp.entities.users.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="applications")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="applicant_id")
	private Applicant applicant;

	@ManyToOne
	@JoinColumn(name="bootcamp_id")
	private Bootcamp bootcamp;
	
	@Column(name="state") 
	private int state;
	
}
