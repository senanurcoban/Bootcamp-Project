package com.kodlamaio.bootcamp.business.responses.instructor;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String nationalIdentity;
	private String companyName;
	private LocalDate dateOfBirth;
}
