package com.kodlamaio.bootcamp.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcamp.business.abstracts.ApplicantService;
import com.kodlamaio.bootcamp.business.abstracts.BlackListService;
import com.kodlamaio.bootcamp.business.constants.Messages;
import com.kodlamaio.bootcamp.business.requests.blackList.CreateBlackListRequest;
import com.kodlamaio.bootcamp.business.requests.blackList.UpdateBlackListRequest;
import com.kodlamaio.bootcamp.business.responses.blackList.CreateBlackListResponse;
import com.kodlamaio.bootcamp.business.responses.blackList.GetAllBlackListsResponse;
import com.kodlamaio.bootcamp.business.responses.blackList.GetBlackListResponse;
import com.kodlamaio.bootcamp.business.responses.blackList.UpdateBlackListResponse;
import com.kodlamaio.bootcamp.core.mapping.ModelMapperService;
import com.kodlamaio.bootcamp.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;
import com.kodlamaio.bootcamp.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcamp.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcamp.dataAccess.abstracts.BlackListRepository;
import com.kodlamaio.bootcamp.entities.BlackList;
import com.kodlamaio.bootcamp.entities.applications.Application;
import com.kodlamaio.bootcamp.entities.users.Applicant;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class BlackListManager implements BlackListService{

	private BlackListRepository blackListRepository;
	private ModelMapperService modelMapperService;
	private ApplicantService applicantService;
	@Override
	public Result delete(int id) {
		checkIfBlackListExistsById(id);
		blackListRepository.deleteById(id);
		return new SuccessResult(Messages.BlackListDelete);
	}

	@Override
	public DataResult<CreateBlackListResponse> add(CreateBlackListRequest createBlackListRequest) {
		LocalDate date=dateParse(createBlackListRequest.getDate());
		checkIfApplicantExists(createBlackListRequest.getApplicantId());
		checkIfApplicationExistsByApplicantId(createBlackListRequest.getApplicantId());
		BlackList blackList=modelMapperService.forRequest().map(createBlackListRequest,BlackList.class);
		blackList.setDate(date);
		blackListRepository.save(blackList);
		
		CreateBlackListResponse createBlackListResponse=modelMapperService.forResponse().map(blackList,CreateBlackListResponse.class);
		return new SuccessDataResult<CreateBlackListResponse>(createBlackListResponse,Messages.BlackListCreated);
	}

	@Override
	public DataResult<List<GetAllBlackListsResponse>> getAll() {
		List<BlackList> blackLists=this.blackListRepository.findAll();
		List<GetAllBlackListsResponse> response=blackLists.stream().
				map(blackList->this.modelMapperService.forResponse().
						map(blackList,GetAllBlackListsResponse.class)).
				collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBlackListsResponse>>(response,Messages.BlackListGetAll);
		
	}

	@Override
	public DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest updateBlackListRequest) {
		LocalDate date=dateParse(updateBlackListRequest.getDate());
		checkIfBlackListExistsById(updateBlackListRequest.getId());
		checkIfApplicantExists(updateBlackListRequest.getApplicantId());
		BlackList blackListcontro=blackListRepository.findById(updateBlackListRequest.getId()).get();
		
		if(blackListcontro.getApplicant().getId()!=updateBlackListRequest.getApplicantId()) {
			checkIfApplicationExistsByApplicantId(updateBlackListRequest.getApplicantId());
		}
		
			
		BlackList blacklist=this.modelMapperService.forRequest().map(updateBlackListRequest,BlackList.class);
		blacklist.setDate(date);
        blackListRepository.save(blacklist);
		UpdateBlackListResponse response=this.modelMapperService.forResponse().map(blacklist,UpdateBlackListResponse.class);
		return new SuccessDataResult<UpdateBlackListResponse>(response,Messages.BlackListUpdated);
		
	}

	@Override
	public DataResult<GetBlackListResponse> getById(int id) {
		checkIfBlackListExistsById(id);
		BlackList blackList=this. blackListRepository.findById(id).get();
		GetBlackListResponse response=this.modelMapperService.forResponse().map(blackList,GetBlackListResponse.class);
		
		return new SuccessDataResult<GetBlackListResponse>(response,Messages.BlackListById);
		
	}

	private void checkIfBlackListExistsById(int id) {
		BlackList blacklist=this.blackListRepository.findById(id).orElse(null);
		if(blacklist==null) {
			throw new BusinessException(Messages.BlackListNoById);
		}
		
	}

	@Override
	public DataResult<GetBlackListResponse> getApplicantId(int applicantId) {
		BlackList blackList = blackListRepository.findByApplicantId(applicantId);
		GetBlackListResponse blackListResponse = modelMapperService.forResponse().map(blackList, GetBlackListResponse.class);
		return new SuccessDataResult<GetBlackListResponse>(blackListResponse);
	}
	
	private void checkIfApplicantExists(int applicantId) {
		Object applicant = applicantService.getById(applicantId);
		if (applicant == null) {
			throw new BusinessException(Messages.ApplicantNoExists);
		}
	}
	private void checkIfApplicationExistsByApplicantId(int applicantId) {
		BlackList blackList = blackListRepository.findByApplicantId(applicantId);
		if(blackListRepository.existsBlacklistByApplicantId(applicantId))
			throw new BusinessException(Messages.ApplicationExistsApplicant);
		
		/*if (blackList != null) {
			
			throw new BusinessException("tabloda bu kısı var zaten");
		}
		return blackList*/
	}
	
//	private void checkIfApplicantExists(int applicantId) {
//		//Applicant applicant  = blackListRepositoVry.findByApplicantId(applicantId);
//		if (applicant == null) {
//			throw new BusinessException(Messages.ApplicantNoExists);
//		}
//	}
	private LocalDate dateParse(String date) {
		return LocalDate.parse(date);
	}

}
