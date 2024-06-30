package com.mindgate.main.service;

import com.mindgate.main.domain.EmployeeTravelDetails;

public interface EmployeeTravelDetailsServiceInterface {

	public Object validateEmployeeLogin(String employeeId, String password, String role);
	
	public	EmployeeTravelDetails getOneEmployeeTravelDetail(String employeeId);

}
