package com.kodlamaio.bootcamp.business.responses.blackList;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBlackListResponse {
	private int id;
	private int applicantId;
	private LocalDate date;
	private String reason;
}
