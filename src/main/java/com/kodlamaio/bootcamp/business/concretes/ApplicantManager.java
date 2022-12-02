package com.kodlamaio.bootcamp.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.kodlamaio.bootcamp.business.abstracts.ApplicantService;
import com.kodlamaio.bootcamp.business.constants.Messages;
import com.kodlamaio.bootcamp.business.requests.applicant.CreateApplicantRequest;
import com.kodlamaio.bootcamp.business.requests.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootcamp.business.responses.applicant.CreateApplicantResponse;
import com.kodlamaio.bootcamp.business.responses.applicant.GetAllApplicantsResponse;
import com.kodlamaio.bootcamp.business.responses.applicant.GetApplicantResponse;
import com.kodlamaio.bootcamp.business.responses.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootcamp.core.mapping.ModelMapperService;
import com.kodlamaio.bootcamp.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;
import com.kodlamaio.bootcamp.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcamp.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcamp.dataAccess.abstracts.ApplicantRepository;
import com.kodlamaio.bootcamp.entities.users.Applicant;


import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ApplicantManager implements ApplicantService {
	private ApplicantRepository applicantRepository;
	private ModelMapperService modelMapperService;
	
	
	@Override
	public Result delete(int id) {
		Applicant applicant=checkIfApplicantExitsById(id);
		applicantRepository.deleteById(id);
		return new SuccessResult(Messages.ApplicantDelete);
	}
 
	@Override
	public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest) {
		LocalDate dateOfBirth=dateParse(createApplicantRequest.getDateOfBirth());
		checkIfApplicantExitsByNationalIdentity(createApplicantRequest.getNationalIdentity());
		Applicant applicant=this.modelMapperService.forRequest().map(createApplicantRequest,Applicant.class);
		checkIfApplicantExitsByNationalIdentity(applicant.getNationalIdentity());
		//createApplicantRequest.setId(0);
		applicant.setDateOfBirth(dateOfBirth);
		this.applicantRepository.save(applicant);
		CreateApplicantResponse createApplicantResponse=this.modelMapperService.forResponse().map(applicant,CreateApplicantResponse.class);
		
		return new SuccessDataResult<CreateApplicantResponse>(createApplicantResponse,Messages.ApplicantCreated);
	}

	@Override
	public DataResult<List<GetAllApplicantsResponse>> getAll() {
		List<Applicant> applicants=this.applicantRepository.findAll();
		List<GetAllApplicantsResponse> response=applicants.stream().
				map(applicant->this.modelMapperService.forResponse().map(applicant,GetAllApplicantsResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllApplicantsResponse>>(response,Messages.ApplicantGetAll);
		
	}

	@Override
	public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest) {
		LocalDate dateOfBirth=dateParse(updateApplicantRequest.getDateOfBirth());
		checkIfApplicantExitsById(updateApplicantRequest.getId());
		Applicant applicant=this.modelMapperService.forRequest().map(updateApplicantRequest,Applicant.class);
		applicant.setDateOfBirth(dateOfBirth);
		this.applicantRepository.save(applicant);
		UpdateApplicantResponse response=this.modelMapperService.forResponse().map(applicant,UpdateApplicantResponse.class);
		return new SuccessDataResult<UpdateApplicantResponse>(response,Messages.ApplicantUpdated);
		
	}

	@Override
	public DataResult<GetApplicantResponse> getById(int id) {
		checkIfApplicantExitsById(id);
		Applicant applicant=this.applicantRepository.findById(id).get();
		GetApplicantResponse response=this.modelMapperService.forResponse().map(applicant,GetApplicantResponse.class);
		
		return new SuccessDataResult<GetApplicantResponse>(response,Messages.ApplicantById);
		
	}
	
	private void checkIfApplicantExitsByNationalIdentity(String nationalIdentity) {
		Applicant result=this.applicantRepository.findByNationalIdentity(nationalIdentity);
		if(result!=null) {
			throw new BusinessException(Messages.ApplicantNationalIdentity);
		}	
	}
	
	private Applicant checkIfApplicantExitsById(int id) {
		Applicant applicant=this.applicantRepository.findById(id).orElse(null);
		if(applicant!=null) {
			return applicant;
		}
		throw new BusinessException(Messages.ApplicantNoById);
	}
	private LocalDate dateParse(String date) {
		return LocalDate.parse(date);
	}
	
	
	
		
	

	

}
