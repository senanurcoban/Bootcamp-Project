package com.kodlamaio.bootcamp.business.responses.blackList;

import java.time.LocalDate;

import com.kodlamaio.bootcamp.entities.users.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlackListResponse {

	private int id;
	private int applicantId;
	private LocalDate date;
	private String reason;
}
