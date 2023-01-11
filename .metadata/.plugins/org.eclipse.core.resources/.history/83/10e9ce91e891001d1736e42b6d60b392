package com.kodlamaio.bootcamp.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcamp.business.abstracts.BootcampService;
import com.kodlamaio.bootcamp.business.abstracts.InstructorService;
import com.kodlamaio.bootcamp.business.constants.Messages;
import com.kodlamaio.bootcamp.business.requests.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootcamp.business.requests.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootcamp.business.responses.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootcamp.business.responses.bootcamp.GetAllBootcampResponse;
import com.kodlamaio.bootcamp.business.responses.bootcamp.GetBootcampResponse;
import com.kodlamaio.bootcamp.business.responses.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootcamp.core.mapping.ModelMapperService;
import com.kodlamaio.bootcamp.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;
import com.kodlamaio.bootcamp.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcamp.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcamp.dataAccess.abstracts.BootcampRepository;
import com.kodlamaio.bootcamp.entities.Bootcamp;
import com.kodlamaio.bootcamp.entities.users.Instructor;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {

	private BootcampRepository bootcampRepository;
	private ModelMapperService modelMapperService;
	private InstructorService instructorService;

	@Override
	public Result delete(int id) {
		checkIfBootcampExitsById(id);
		bootcampRepository.deleteById(id);

		return new SuccessResult(Messages.BootcampDeleted);
	}

	@Override
	public DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest) {
		LocalDate startDate = dateParse(createBootcampRequest.getDateStart());
		LocalDate endDate = dateParse(createBootcampRequest.getDateEnd());
		checkIfStartDateIsItBigEndDate(startDate, endDate);
		checkIfInstructorExists(createBootcampRequest.getInstructorId());
	    
		Bootcamp bootcamp = modelMapperService.forRequest().map(createBootcampRequest, Bootcamp.class);
		bootcamp.setDateEnd(endDate);
		bootcamp.setDateStart(startDate);
		bootcamp.setId(0);
		bootcampRepository.save(bootcamp);
		CreateBootcampResponse createBootcampResponse = modelMapperService.forResponse().map(bootcamp,
				CreateBootcampResponse.class);

		return new SuccessDataResult<CreateBootcampResponse>(createBootcampResponse, Messages.BootcampCreated);
	}

	@Override
	public DataResult<List<GetAllBootcampResponse>> getAll() {
		List<Bootcamp> bootcamps = bootcampRepository.findAll();
		List<GetAllBootcampResponse> bootcampResponses = bootcamps.stream()
				.map(bootcamp -> this.modelMapperService.forResponse().map(bootcamp, GetAllBootcampResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBootcampResponse>>(bootcampResponses, Messages.BootcampListed);
	}

	@Override
	public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest) {
		checkIfBootcampExitsById(updateBootcampRequest.getId());
		LocalDate startDate = dateParse(updateBootcampRequest.getDateStart());
		LocalDate endDate = dateParse(updateBootcampRequest.getDateEnd());
		checkIfStartDateIsItBigEndDate(startDate, endDate);
		// checkIfInstructorExists(updateBootcampRequest.getInstructorId());
		Bootcamp bootcamp = modelMapperService.forRequest().map(updateBootcampRequest, Bootcamp.class);
		bootcamp.setDateEnd(endDate);
		bootcamp.setDateStart(startDate);
		bootcampRepository.save(bootcamp);
		UpdateBootcampResponse updateBootcampResponse = modelMapperService.forResponse().map(bootcamp,
				UpdateBootcampResponse.class);
		return new SuccessDataResult<UpdateBootcampResponse>(updateBootcampResponse, Messages.BootcampUpdated);
	}

	@Override
	public DataResult<GetBootcampResponse> getById(int id) {
		checkIfBootcampExitsById(id);
		Bootcamp bootcamp = bootcampRepository.findById(id).get();
		GetBootcampResponse bootcampResponse = modelMapperService.forResponse().map(bootcamp,
				GetBootcampResponse.class);
		return new SuccessDataResult<GetBootcampResponse>(bootcampResponse);
	}

	private void checkIfBootcampExitsById(int id) {
		Bootcamp bootcamp = this.bootcampRepository.findById(id).orElse(null);
		if (bootcamp == null) {
			throw new BusinessException(Messages.BootcampNoExists);
		}
	}


	private void checkIfInstructorExists(int instructorId) {
		Object instructor = instructorService.getById(instructorId);
		if (instructor == null) {
			throw new BusinessException(Messages.InstructorNoExists);
		}
	}

	private LocalDate dateParse(String date) {
		return LocalDate.parse(date);
	}
	private void checkIfStartDateIsItBigEndDate(LocalDate startDate, LocalDate endDate) {

		if (startDate.isAfter(endDate)) {
			throw new BusinessException(Messages.BootcampStartDateIsItBigEndDate);
		}
	}

	@Override
	public int getState(int id) {
		Bootcamp bootcamp=bootcampRepository.findById(id).get();
		
		return bootcamp.getState();
	}
}
