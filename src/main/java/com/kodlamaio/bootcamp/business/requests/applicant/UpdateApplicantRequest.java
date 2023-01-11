package com.kodlamaio.bootcamp.business.requests.applicant;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicantRequest {
	
	@NotNull
	@Min(1)
	private int id;
	
	@NotEmpty
	@NotNull
	@Size(min = 3)
	private String firstName;
	
	@NotEmpty
	@NotNull
	private String lastName;
	
	@Email(regexp=".+[@].+[\\.].+",message = "Incorrect email")
	private String email;
	
	@NotEmpty
	@NotNull
	private String password;
	
	@Size(min=20,max=500)
	@NotNull
	@NotEmpty
	private String about;
	
	@NotNull
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private String dateOfBirth;
	
	@Size(min = 11, max = 11)
	@NotNull
	@NotEmpty
	private String nationalIdentity;
	
	
}
