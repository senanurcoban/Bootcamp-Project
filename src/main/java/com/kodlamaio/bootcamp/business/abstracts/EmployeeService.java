package com.kodlamaio.bootcamp.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcamp.business.requests.employee.CreateEmployeeRequest;
import com.kodlamaio.bootcamp.business.requests.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootcamp.business.responses.employee.CreateEmployeeResponse;
import com.kodlamaio.bootcamp.business.responses.employee.GetAllEmployeesResponse;
import com.kodlamaio.bootcamp.business.responses.employee.GetEmployeeResponse;
import com.kodlamaio.bootcamp.business.responses.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;



public interface EmployeeService {

	Result delete(int id);
	DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);
	DataResult<List<GetAllEmployeesResponse>> getAll();
	DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest);
	DataResult<GetEmployeeResponse> getById(int id);
}
