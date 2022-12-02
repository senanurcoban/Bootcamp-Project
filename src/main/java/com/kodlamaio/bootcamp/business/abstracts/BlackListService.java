package com.kodlamaio.bootcamp.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcamp.business.requests.blackList.CreateBlackListRequest;
import com.kodlamaio.bootcamp.business.requests.blackList.UpdateBlackListRequest;
import com.kodlamaio.bootcamp.business.responses.blackList.CreateBlackListResponse;
import com.kodlamaio.bootcamp.business.responses.blackList.GetAllBlackListsResponse;
import com.kodlamaio.bootcamp.business.responses.blackList.GetBlackListResponse;
import com.kodlamaio.bootcamp.business.responses.blackList.UpdateBlackListResponse;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;

public interface BlackListService {

	Result delete(int id);
	DataResult<CreateBlackListResponse> add(CreateBlackListRequest createBlackListRequest);
	DataResult<List<GetAllBlackListsResponse>> getAll();
	DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest updateBlackListRequest);
	DataResult<GetBlackListResponse> getById(int id);
	DataResult<GetBlackListResponse> getApplicantId(int applicantId);
	
	
	
}
