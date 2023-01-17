package com.kodlamaio.bootcamp.business.concretes;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.kodlamaio.bootcamp.business.abstracts.ApplicantService;
import com.kodlamaio.bootcamp.business.abstracts.ApplicationService;
import com.kodlamaio.bootcamp.business.abstracts.BlackListService;
import com.kodlamaio.bootcamp.business.abstracts.BootcampService;
import com.kodlamaio.bootcamp.business.constants.Messages;
import com.kodlamaio.bootcamp.business.requests.application.CreateApplicationRequest;
import com.kodlamaio.bootcamp.business.requests.application.UpdateApplicationRequest;
import com.kodlamaio.bootcamp.business.responses.application.CreateApplicationResponse;
import com.kodlamaio.bootcamp.business.responses.application.GetAllApplicationsResponse;
import com.kodlamaio.bootcamp.business.responses.application.GetApplicationResponse;
import com.kodlamaio.bootcamp.business.responses.application.UpdateApplicationResponse;
import com.kodlamaio.bootcamp.core.mapping.ModelMapperService;
import com.kodlamaio.bootcamp.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;
import com.kodlamaio.bootcamp.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcamp.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcamp.dataAccess.applications.ApplicationRepository;
import com.kodlamaio.bootcamp.entities.applications.Application;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
	private ApplicationRepository applicationRepository;
	private ModelMapperService modelMapperService;
	private BlackListService blackListService;
	private ApplicantService applicantService;
	private BootcampService bootcampService;

	@Override
	public Result delete(int id) {
		checkIfApplicationExitsById(id);
		applicationRepository.deleteById(id);
		return new SuccessResult(Messages.ApplicationDelete);

	}

	@Override
	public DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest) {
		//checkIfBlackListExistsByApplicationId(createApplicationRequest.getApplicantId());
		checkIfApplicantExists(createApplicationRequest.getApplicantId());
		checkIfApplicationExistsByApplicantId(createApplicationRequest.getApplicantId());
		 checkIfBootcampExists(createApplicationRequest.getBootcampId());
		 checkIfStateStatus(createApplicationRequest.getState());
		//System.out.println(createApplicationRequest.getBootcampId());
		Application application = modelMapperService.forRequest().map(createApplicationRequest, Application.class);
		applicationRepository.save(application);
		CreateApplicationResponse createApplicationResponse = modelMapperService.forResponse().map(application,
				CreateApplicationResponse.class);

		return new SuccessDataResult<CreateApplicationResponse>(createApplicationResponse, Messages.ApplicationCreated);

	}

	@Override
	public DataResult<List<GetAllApplicationsResponse>> getAll() {
		List<Application> applications = applicationRepository.findAll();
		List<GetAllApplicationsResponse> applicationResponses = applications.stream().map(
				application -> this.modelMapperService.forResponse().map(application, GetAllApplicationsResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicationsResponse>>(applicationResponses,
				Messages.ApplicationListed);

	}

	@Override
	public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest) {
		//checkIfBlackListExistsByApplicationId(updateApplicationRequest.getApplicantId());
		checkIfApplicantExists(updateApplicationRequest.getApplicantId());
		checkIfApplicationExistsByApplicantId(updateApplicationRequest.getApplicantId());
		//checkIfBootcampExists(updateApplicationRequest.getBootcampId());
		checkIfApplicationExitsById(updateApplicationRequest.getId());
		checkIfStateStatus(updateApplicationRequest.getState());
		Application application = modelMapperService.forRequest().map(updateApplicationRequest, Application.class);
		applicationRepository.save(application);
		UpdateApplicationResponse updateApplicationResponse = modelMapperService.forResponse().map(application,
				UpdateApplicationResponse.class);
		return new SuccessDataResult<UpdateApplicationResponse>(updateApplicationResponse, Messages.ApplicationUpdated);

	}

	@Override
	public DataResult<GetApplicationResponse> getById(int id) {
		checkIfApplicationExitsById(id);
		Application application = applicationRepository.findById(id).get();
		GetApplicationResponse applicationResponse = modelMapperService.forResponse().map(application,
				GetApplicationResponse.class);
		return new SuccessDataResult<GetApplicationResponse>(applicationResponse);

	}

	private void checkIfApplicationExitsById(int id) {
		Application application = this.applicationRepository.findById(id).orElse(null);
		if (application == null) {
			throw new BusinessException(Messages.ApplicantOnApplication);
		}
	}

/*private void checkIfBlackListExistsByApplicationId(int id) {
	Object result = blackListService.getApplicantId(id);
	if (result== null) {
	throw new BusinessException(Messages.ApplicantInBlackList); 
	}
}*/
	private void checkIfApplicationExistsByApplicantId(int applicantId) {
		Application application = applicationRepository.findByApplicantId(applicantId);
		if (application != null) {
			throw new BusinessException(Messages.ApplicantExists);
		}
	}

	private void checkIfApplicantExists(int applicantId) {
		Object applicant = applicantService.getById(applicantId);
		if (applicant == null) {
			throw new BusinessException(Messages.ApplicantNoExists);
		}
	}

	private void checkIfBootcampExists(int bootcampId) {
		Object bootcamp = bootcampService.getById(bootcampId);
		if (bootcamp == null) {
			throw new BusinessException(Messages.BootcampNoExists);
		}
	}
	private void checkIfStateStatus(int id) {
		if(bootcampService.getState(id)==2) {
			throw new BusinessException(Messages.BootcampClosed);
		}
	}
}
