package com.kodlamaio.bootcamp.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.kodlamaio.bootcamp.business.abstracts.InstructorService;
import com.kodlamaio.bootcamp.business.constants.Messages;
import com.kodlamaio.bootcamp.business.requests.instructor.CreateInstructorRequest;
import com.kodlamaio.bootcamp.business.requests.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootcamp.business.responses.instructor.CreateInstructorResponse;
import com.kodlamaio.bootcamp.business.responses.instructor.GetAllInstructorsResponse;
import com.kodlamaio.bootcamp.business.responses.instructor.GetInstructorResponse;
import com.kodlamaio.bootcamp.business.responses.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootcamp.core.mapping.ModelMapperService;
import com.kodlamaio.bootcamp.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;
import com.kodlamaio.bootcamp.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcamp.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcamp.dataAccess.abstracts.InstructorRepository;
import com.kodlamaio.bootcamp.entities.users.Instructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InstructorManager  implements InstructorService{
    private InstructorRepository instructorRepository;
	private ModelMapperService modelMapperService;
	

	@Override
	public Result delete(int id) {
		Instructor instructor=checkIfInstructorExitsById(id);
		this.instructorRepository.delete(instructor);
		return new SuccessResult(Messages.InstructorDeleted);
	}

	@Override
	public DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest) {
		
		LocalDate dateOfBirth=dateParse(createInstructorRequest.getDateOfBirth());
		
		checkIfInstructorExitsByNationalIdentity(createInstructorRequest.getNationalIdentity());
		Instructor instructor=this.modelMapperService.forRequest().map(createInstructorRequest,Instructor.class);
		instructor.setDateOfBirth(dateOfBirth);
		this.instructorRepository.save(instructor);
		 CreateInstructorResponse createInstructorResponse=this.modelMapperService.forResponse().map(instructor,CreateInstructorResponse.class);
		 
		return  new SuccessDataResult<CreateInstructorResponse>(createInstructorResponse,Messages.InstructorCreated);
	}

	@Override
	public DataResult<List<GetAllInstructorsResponse>> getAll() {
		List<Instructor> instructors=this.instructorRepository.findAll();
		List<GetAllInstructorsResponse> response=instructors.stream().
				map(instructor->this.modelMapperService.forResponse().map(instructor,GetAllInstructorsResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllInstructorsResponse>>(response,Messages.InstructorGetAll);
	}

	@Override
	public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest) {
		LocalDate dateOfBirth=dateParse(updateInstructorRequest.getDateOfBirth());
		
		checkIfInstructorExitsById(updateInstructorRequest.getId());
		Instructor instructor=this.modelMapperService.forRequest().map(updateInstructorRequest,Instructor.class);
		instructor.setDateOfBirth(dateOfBirth);
		this.instructorRepository.save(instructor);
		UpdateInstructorResponse response=this.modelMapperService.forResponse().map(instructor,UpdateInstructorResponse.class);
		return new SuccessDataResult<UpdateInstructorResponse>(response,Messages.InstructorUpdated);
		
	}

	@Override
	public DataResult<GetInstructorResponse> getById(int id) {
		checkIfInstructorExitsById(id);
		Instructor instructor=this.instructorRepository.findById(id).get();
		GetInstructorResponse response=this.modelMapperService.forResponse().map(instructor,GetInstructorResponse.class);
		
		return new SuccessDataResult<GetInstructorResponse>(response,Messages.InstructorById);
	}

	private void checkIfInstructorExitsByNationalIdentity(String nationalIdentity) {
		Instructor result=this.instructorRepository.findByNationalIdentity(nationalIdentity);
		if(result!=null) {
			throw new BusinessException(Messages.InstructorNationalIdentity);
		}
	} 
	private Instructor checkIfInstructorExitsById(int id) {
		Instructor instructor=this.instructorRepository.findById(id).orElse(null);
		if(instructor!=null) {
			return instructor;
		}throw new BusinessException(Messages.InstructorNoById);
	}

	private LocalDate dateParse(String date) {
		return LocalDate.parse(date);
	}
}
