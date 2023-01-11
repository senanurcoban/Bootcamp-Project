package com.kodlamaio.bootcamp.business.requests.application;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationRequest {

	@NotNull
	@Min(1)
	private int applicantId; 
	
	@Min(1)
	private int bootcampId;
	
	@NotNull
	@Min(value = 1, message = "State cannot be less than 1")
	@Max(value = 4, message = "State cannot be more than 4")
	private int state;
	
}
