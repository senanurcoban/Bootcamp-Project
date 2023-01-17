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
public class UpdateBootcampRequest {
	@NotNull
	@Min(1)
	private int id;
	
	@NotEmpty
	@NotNull
	private String name;
	
	
	@NotNull
	@NotEmpty
	private String dateStart;
	
	@NotNull
	@NotEmpty
	private String dateEnd;
	
	@Min(value = 1, message = "State cannot be less than 1")
    @Max(value = 2, message = "State cannot be more than 2")
	private int state;
	
	@NotNull
	@Min(1)
	private int instructorId;
}
