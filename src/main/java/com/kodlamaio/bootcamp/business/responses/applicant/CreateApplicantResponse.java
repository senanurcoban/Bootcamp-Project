package com.kodlamaio.bootcamp.business.responses.applicant;



import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String about;
	private String nationalIdentity;
	private LocalDate dateOfBirth;
	private String password;
}
