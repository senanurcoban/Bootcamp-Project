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

import com.kodlamaio.bootcamp.business.abstracts.BootcampService;
import com.kodlamaio.bootcamp.business.requests.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootcamp.business.requests.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootcamp.business.responses.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootcamp.business.responses.bootcamp.GetAllBootcampResponse;
import com.kodlamaio.bootcamp.business.responses.bootcamp.GetBootcampResponse;
import com.kodlamaio.bootcamp.business.responses.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/api/bootcamps")
@AllArgsConstructor
public class BootcampsController {

	private BootcampService bootcampService;
	@GetMapping("/{id}")
	public DataResult<GetBootcampResponse> getById(@PathVariable int id){
		return this.bootcampService.getById(id);
	}
	@GetMapping("/getall")
	public DataResult<List<GetAllBootcampResponse>> getAll(){
		return this.bootcampService.getAll();
	}
	@PostMapping("/add")
	public DataResult<CreateBootcampResponse> add(@Valid @RequestBody CreateBootcampRequest createBootcampRequest){
		return this.bootcampService.add(createBootcampRequest);
	}
	
	
	@PutMapping()
	public DataResult<UpdateBootcampResponse> update(@Valid @RequestBody UpdateBootcampRequest updateBootcampRequest){
		return this.bootcampService.update(updateBootcampRequest);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.bootcampService.delete(id);
	}
	
}
