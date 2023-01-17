package com.kodlamaio.bootcamp.api;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kodlamaio.bootcamp.business.abstracts.ApplicantService;
import com.kodlamaio.bootcamp.business.requests.applicant.CreateApplicantRequest;
import com.kodlamaio.bootcamp.business.requests.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootcamp.business.responses.applicant.CreateApplicantResponse;
import com.kodlamaio.bootcamp.business.responses.applicant.GetAllApplicantsResponse;
import com.kodlamaio.bootcamp.business.responses.applicant.GetApplicantResponse;
import com.kodlamaio.bootcamp.business.responses.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/applicants")
public class ApplicantController {

	private ApplicantService applicantService;
	@GetMapping("/{id}")
	public DataResult<GetApplicantResponse> getById(@PathVariable int id){
		return this.applicantService.getById(id);
	}
	@GetMapping("/getall")
	public DataResult<List<GetAllApplicantsResponse>> getAll(){
		return this.applicantService.getAll();
	}
	@PostMapping()
	public DataResult<CreateApplicantResponse> add(@Valid @RequestBody CreateApplicantRequest createApplicantRequest){
		return this.applicantService.add(createApplicantRequest);
	}
	
	
	@PutMapping()
	public DataResult<UpdateApplicantResponse> update(@Valid @RequestBody UpdateApplicantRequest updateApplicantRequest){
		return this.applicantService.update(updateApplicantRequest);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.applicantService.delete(id);
	}
}
