package com.kodlamaio.bootcamp.business.responses.blackList;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBlackListsResponse {

	private int id;
	private int applicantId;
	private LocalDate date;
	private String reason;
}
