package com.kodlamaio.bootcamp.business.requests.employee;

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
public class UpdateEmployeeRequest {
	
	@NotNull
	@Min(1)
	private int id;
	
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
	
	@NotNull
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String dateOfBirth;
	
	@NotNull
	@NotEmpty
	private String position;
	
	@Size(min = 11, max = 11)
	@NotNull
	@NotEmpty
	private String nationalIdentity;
	
}
