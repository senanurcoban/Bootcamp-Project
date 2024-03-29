package com.kodlamaio.bootcamp.business.responses.bootcamp;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampResponse {
	private int id;
	private String name;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	private int state;
	private int instructorId;
}
