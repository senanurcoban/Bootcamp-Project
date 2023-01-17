package com.kodlamaio.bootcamp.business.requests.instructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest {

	
	@NotEmpty
	@NotNull
	@Size(min=3)
	private String firstName;
	
	@NotEmpty
	@NotNull
	private String lastName;
	
	@Email(regexp=".+[@].+[\\.].+",message = "Incorrect email")
	private String email;
	
	@NotEmpty
	@NotNull
	private String password;
	
	@NotEmpty
	@NotNull
	private String companyName;
	
	@NotEmpty
	@NotNull
	@Size(min=11,max=11)
	private String nationalIdentity;
	
	@NotNull
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private String dateOfBirth;
	
}
