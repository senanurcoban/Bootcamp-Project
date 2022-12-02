package com.kodlamaio.bootcamp.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcamp.business.requests.applicant.CreateApplicantRequest;
import com.kodlamaio.bootcamp.business.requests.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootcamp.business.responses.applicant.CreateApplicantResponse;
import com.kodlamaio.bootcamp.business.responses.applicant.GetAllApplicantsResponse;
import com.kodlamaio.bootcamp.business.responses.applicant.GetApplicantResponse;
import com.kodlamaio.bootcamp.business.responses.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;

public interface ApplicantService {
	Result delete(int id);
	DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest);
	DataResult<List<GetAllApplicantsResponse>> getAll();
	DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest);
	DataResult<GetApplicantResponse> getById(int id);
	
}
