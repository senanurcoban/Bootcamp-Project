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
import com.kodlamaio.bootcamp.business.abstracts.InstructorService;
import com.kodlamaio.bootcamp.business.requests.instructor.CreateInstructorRequest;
import com.kodlamaio.bootcamp.business.requests.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootcamp.business.responses.instructor.CreateInstructorResponse;
import com.kodlamaio.bootcamp.business.responses.instructor.GetAllInstructorsResponse;
import com.kodlamaio.bootcamp.business.responses.instructor.GetInstructorResponse;
import com.kodlamaio.bootcamp.business.responses.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/instructors")
public class InstructorController {

	private InstructorService instructorService;
	@GetMapping("/{id}")
	public DataResult<GetInstructorResponse> getById(@PathVariable int id){
		return this.instructorService.getById(id);
	}
	@GetMapping("/getall")
	public DataResult<List<GetAllInstructorsResponse>> getAll(){
		return this.instructorService.getAll();
	}
	@PostMapping()
	public DataResult<CreateInstructorResponse> add(@Valid @RequestBody CreateInstructorRequest createInstructorRequest){
		return this.instructorService.add(createInstructorRequest);
	}
	
	
	@PutMapping()
	public DataResult<UpdateInstructorResponse> update(@Valid @RequestBody UpdateInstructorRequest updateInstructorRequest){
		return this.instructorService.update(updateInstructorRequest);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.instructorService.delete(id);
	}
	
}
