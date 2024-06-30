package com.mindgate.main.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.EmployeeTravelDetails;
import com.mindgate.main.domain.TravelAgentDetails;
import com.mindgate.main.service.EmployeeTravelDetailsServiceInterface;

@RestController
@RequestMapping("restapi/employeetraveldetails")
public class EmployeeTravelDetailsRestController {
	@Autowired
	private EmployeeTravelDetailsServiceInterface employeeTravelDetailsServiceInterface;

	
	//http://localhost:8080/restapi/employeetraveldetails/validatelogin
	
	
	@PostMapping("validatelogin")
	public Object login(@RequestBody EmployeeTravelDetails employeeTravelDetails) {
		Object userObject = employeeTravelDetailsServiceInterface.validateEmployeeLogin(
				employeeTravelDetails.getEmployeeId(), employeeTravelDetails.getPassword(),
				employeeTravelDetails.getRole());
		if (userObject != null) {
			if (employeeTravelDetails.getRole().equals("Travel Agent")) {
				TravelAgentDetails travelAgentDetails = (TravelAgentDetails) userObject;
				travelAgentDetails.setPassword("*****");
				return travelAgentDetails;
			} else {
				EmployeeTravelDetails employeeTravelDetails2 = (EmployeeTravelDetails) userObject;
				employeeTravelDetails2.setPassword("*****");
				return employeeTravelDetails2;
			}
		}
		return null;
	}
	
	
}