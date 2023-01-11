package com.kodlamaio.bootcamp.business.responses.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteInstructorResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String companyName;
	private String nationalIdentity;
	private String dateOfBirth;
}
