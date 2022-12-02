package com.kodlamaio.bootcamp.business.requests.blackList;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlackListRequest {

	@NotNull
	@Min(1)
	private int applicantId;
	
	@NotNull
	@NotEmpty
	@CreationTimestamp
	private String date;
	
	@NotNull
	@NotEmpty
	private String reason;
}
