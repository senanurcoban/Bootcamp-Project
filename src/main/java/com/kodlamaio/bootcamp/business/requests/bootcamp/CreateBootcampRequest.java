package com.kodlamaio.bootcamp.business.requests.bootcamp;


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
public class CreateBootcampRequest {

	@NotEmpty
	@NotNull
	private String name;

	@NotNull
//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String dateStart;

	@NotNull
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String dateEnd;

	
	@Min(value = 1, message = "State cannot be less than 1")
	@Max(value = 2, message = "State cannot be more than 2")
	private int state;

	@NotNull
	@Min(1)
	private int instructorId;
}
