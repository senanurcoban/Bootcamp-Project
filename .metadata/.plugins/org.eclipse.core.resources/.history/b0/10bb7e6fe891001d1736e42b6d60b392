package com.kodlamaio.bootcamp.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootcamp.business.abstracts.BlackListService;
import com.kodlamaio.bootcamp.business.requests.blackList.CreateBlackListRequest;
import com.kodlamaio.bootcamp.business.requests.blackList.UpdateBlackListRequest;
import com.kodlamaio.bootcamp.business.responses.blackList.CreateBlackListResponse;
import com.kodlamaio.bootcamp.business.responses.blackList.GetAllBlackListsResponse;
import com.kodlamaio.bootcamp.business.responses.blackList.GetBlackListResponse;
import com.kodlamaio.bootcamp.business.responses.blackList.UpdateBlackListResponse;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;
import com.kodlamaio.bootcamp.dataAccess.abstracts.BlackListRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/blacklists")
@AllArgsConstructor
public class BlackListController {
  
	private BlackListService blackListService;
	@GetMapping("/{id}")
	public DataResult<GetBlackListResponse> getById(@PathVariable int id){
		return this.blackListService.getById(id);
	}
	@GetMapping("/getall")
	public  DataResult<List<GetAllBlackListsResponse>> getall(){
		return this.blackListService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<CreateBlackListResponse> add(@Valid @RequestBody CreateBlackListRequest createBlackListRequest){
		return this.blackListService.add(createBlackListRequest);
	}
	
	@PutMapping()
	public DataResult<UpdateBlackListResponse> update(@Valid @RequestBody UpdateBlackListRequest updateBlackListRequest){
		return this.blackListService.update(updateBlackListRequest);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.blackListService.delete(id);
	}
}
