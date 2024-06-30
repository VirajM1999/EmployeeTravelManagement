package com.mindgate.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.EmployeeTravelDetails;
import com.mindgate.main.repository.EmployeeTravelDetailsRepositoryInterface;

@Service
public class EmployeeTravelDetailsService implements EmployeeTravelDetailsServiceInterface {
	@Autowired
	private EmployeeTravelDetailsRepositoryInterface employeeTravelDetailsRepositoryInterface;

	@Override
	public Object validateEmployeeLogin(String employeeId, String password, String role) {
		if (role.equals("Travel Agent")) {
			return employeeTravelDetailsRepositoryInterface.validateTravelLogin(employeeId, password);
		} else {
			return employeeTravelDetailsRepositoryInterface.validateEmployeeLogin(employeeId, password,role);
		}

	}

	@Override
	public EmployeeTravelDetails getOneEmployeeTravelDetail(String employeeId) {
		return employeeTravelDetailsRepositoryInterface.getOneEmployeeTravelDetail(employeeId);
	}



}
