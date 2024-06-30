package com.mindgate.main.repository;

import com.mindgate.main.domain.EmployeeTravelDetails;
import com.mindgate.main.domain.TravelAgentDetails;

public interface EmployeeTravelDetailsRepositoryInterface
{
	public EmployeeTravelDetails validateEmployeeLogin(String employeeId, String password, String role);
	
	 public TravelAgentDetails validateTravelLogin(String username, String password );
	 
	 public EmployeeTravelDetails getOneEmployeeTravelDetail(String employeeId);
	 

}
