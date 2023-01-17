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
import com.kodlamaio.bootcamp.business.abstracts.ApplicationService;
import com.kodlamaio.bootcamp.business.requests.application.CreateApplicationRequest;
import com.kodlamaio.bootcamp.business.requests.application.UpdateApplicationRequest;
import com.kodlamaio.bootcamp.business.responses.application.CreateApplicationResponse;
import com.kodlamaio.bootcamp.business.responses.application.GetAllApplicationsResponse;
import com.kodlamaio.bootcamp.business.responses.application.GetApplicationResponse;
import com.kodlamaio.bootcamp.business.responses.application.UpdateApplicationResponse;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationsController {

	private ApplicationService applicationService;

	@GetMapping("/{id}")
	public DataResult<GetApplicationResponse> getById(@PathVariable int id) {
		return this.applicationService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllApplicationsResponse>> getAll() {
		return this.applicationService.getAll();
	}

	@PostMapping("/add")
	public DataResult<CreateApplicationResponse> add(@Valid @RequestBody CreateApplicationRequest createApplicationRequest) {
		return this.applicationService.add(createApplicationRequest);
	} 

	@PutMapping()
	public DataResult<UpdateApplicationResponse> update(@Valid @RequestBody UpdateApplicationRequest updateApplicationRequest) {
		return this.applicationService.update(updateApplicationRequest);
	}

	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.applicationService.delete(id);
	}

	

}
