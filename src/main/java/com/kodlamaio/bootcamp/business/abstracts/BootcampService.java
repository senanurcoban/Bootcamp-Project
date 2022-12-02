package com.kodlamaio.bootcamp.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcamp.business.requests.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootcamp.business.requests.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootcamp.business.responses.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootcamp.business.responses.bootcamp.GetAllBootcampResponse;
import com.kodlamaio.bootcamp.business.responses.bootcamp.GetBootcampResponse;
import com.kodlamaio.bootcamp.business.responses.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;

public interface BootcampService {
	Result delete(int id);
	DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest);
	DataResult<List<GetAllBootcampResponse>> getAll();
	DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest);
	DataResult<GetBootcampResponse> getById(int id);
	int getState(int id);
}
