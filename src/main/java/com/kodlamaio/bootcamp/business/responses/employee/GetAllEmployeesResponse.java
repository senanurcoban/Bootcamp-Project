package com.kodlamaio.bootcamp.business.responses.employee;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeesResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String position;
	private String nationalIdentity;
	private LocalDate dateOfBirth;
}
