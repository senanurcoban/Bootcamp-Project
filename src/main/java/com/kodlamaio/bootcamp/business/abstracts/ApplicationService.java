package com.kodlamaio.bootcamp.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcamp.business.requests.application.CreateApplicationRequest;
import com.kodlamaio.bootcamp.business.requests.application.UpdateApplicationRequest;
import com.kodlamaio.bootcamp.business.responses.application.CreateApplicationResponse;
import com.kodlamaio.bootcamp.business.responses.application.GetAllApplicationsResponse;
import com.kodlamaio.bootcamp.business.responses.application.GetApplicationResponse;
import com.kodlamaio.bootcamp.business.responses.application.UpdateApplicationResponse;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;

public interface ApplicationService {
	Result delete(int id);
	DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest);
	DataResult<List<GetAllApplicationsResponse>> getAll();
	DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest);
	DataResult<GetApplicationResponse> getById(int id);
}
