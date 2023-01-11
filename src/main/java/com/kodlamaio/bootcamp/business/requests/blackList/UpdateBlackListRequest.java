package com.kodlamaio.bootcamp.business.requests.blackList;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlackListRequest {
	@NotNull
	@Min(1)
    private int id;
	
	@NotNull
	@Min(1)
	private int applicantId;
	
	@NotNull
	@NotEmpty
	private String date;
	
	@NotNull
	@NotEmpty
	private String reason;
}
