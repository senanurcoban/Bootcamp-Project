package com.kodlamaio.bootcamp.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcamp.business.requests.instructor.CreateInstructorRequest;
import com.kodlamaio.bootcamp.business.requests.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootcamp.business.responses.instructor.CreateInstructorResponse;
import com.kodlamaio.bootcamp.business.responses.instructor.GetAllInstructorsResponse;
import com.kodlamaio.bootcamp.business.responses.instructor.GetInstructorResponse;
import com.kodlamaio.bootcamp.business.responses.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;



public interface InstructorService {

	//List<GetAllInstructorsResponse> getAllInstructor();
	//CreateInstructorResponse add(CreateInstructorRequest createInstructorRequest);
	//UpdateInstructorResponse updateInstructor(UpdateInstructorRequest updateInstructorRequest);
	
	
	Result delete(int id);
	DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest);
	DataResult<List<GetAllInstructorsResponse>> getAll();
	DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest);
	DataResult<GetInstructorResponse> getById(int id);
}
