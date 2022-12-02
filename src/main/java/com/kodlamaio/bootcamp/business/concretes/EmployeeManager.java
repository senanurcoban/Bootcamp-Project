package com.kodlamaio.bootcamp.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcamp.business.abstracts.EmployeeService;
import com.kodlamaio.bootcamp.business.constants.Messages;
import com.kodlamaio.bootcamp.business.requests.employee.CreateEmployeeRequest;
import com.kodlamaio.bootcamp.business.requests.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootcamp.business.responses.employee.CreateEmployeeResponse;
import com.kodlamaio.bootcamp.business.responses.employee.GetAllEmployeesResponse;
import com.kodlamaio.bootcamp.business.responses.employee.GetEmployeeResponse;
import com.kodlamaio.bootcamp.business.responses.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootcamp.core.mapping.ModelMapperService;
import com.kodlamaio.bootcamp.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcamp.core.utilities.results.DataResult;
import com.kodlamaio.bootcamp.core.utilities.results.Result;
import com.kodlamaio.bootcamp.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcamp.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcamp.dataAccess.abstracts.EmployeeRepository;
import com.kodlamaio.bootcamp.entities.users.Employee;


import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;
	@Override
	public Result delete(int id) {
		Employee employee=checkIfEmployeeExitsById(id);
		this.employeeRepository.delete(employee);
		return new SuccessResult(Messages.EmployeeDeleted);
		
	}

	@Override
	public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
		LocalDate dateOfBirth=dateParse(createEmployeeRequest.getDateOfBirth());
		checkIfEmployeeExitsByNationalIdentity(createEmployeeRequest.getNationalIdentity());
		Employee employee=this.modelMapperService.forRequest().map(createEmployeeRequest,Employee.class);
		employee.setDateOfBirth(dateOfBirth);
		this.employeeRepository.save(employee);
		 CreateEmployeeResponse createEmployeeResponse=this.modelMapperService.forResponse().map(employee,CreateEmployeeResponse.class);
		 
		return  new SuccessDataResult<CreateEmployeeResponse>(createEmployeeResponse,Messages.EmployeeCreated);
		
	}

	@Override
	public DataResult<List<GetAllEmployeesResponse>> getAll() {
		List<Employee> employees=this.employeeRepository.findAll();
		List<GetAllEmployeesResponse> response=employees.stream().
				map(employee->this.modelMapperService.forResponse().map(employee,GetAllEmployeesResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllEmployeesResponse>>(response,Messages.EmployeeGetAll);
	
	}

	@Override
	public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
		checkIfEmployeeExitsById(updateEmployeeRequest.getId());
		Employee employee=this.modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);
		this.employeeRepository.save(employee);
		UpdateEmployeeResponse response=this.modelMapperService.forResponse().map(employee,UpdateEmployeeResponse.class);
		return new SuccessDataResult<UpdateEmployeeResponse>(response,Messages.EmployeeUpdated);
		
	}

	@Override
	public DataResult<GetEmployeeResponse> getById(int id) {
		Employee employee=this.employeeRepository.findById(id).get();
		GetEmployeeResponse response=this.modelMapperService.forResponse().map(employee,GetEmployeeResponse.class);
		
		return new SuccessDataResult<GetEmployeeResponse>(response,Messages.EmployeeById);
		
	}
	
	private void checkIfEmployeeExitsByNationalIdentity (String nationalIdentity) {
		Employee result=this.employeeRepository.findByNationalIdentity(nationalIdentity);
		if(result!=null) {
			throw new BusinessException(Messages.EmployeeNationalIddentity);
		}
	}
	
	private Employee checkIfEmployeeExitsById(int id) {
		Employee employee=this.employeeRepository.findById(id).orElse(null);
		if(employee!=null) {
			return employee;
		}throw new BusinessException(Messages.EmployeeNoById);
	}
	
	private LocalDate dateParse(String date) {
		return LocalDate.parse(date);
	}
}
