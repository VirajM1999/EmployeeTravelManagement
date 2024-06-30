package com.mindgate.main.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.service.ManagerTravelDetailsServiceInterface;

@RestController
@RequestMapping("restapi/employeetraveldetails")
public class ManagerTravelDetailsRESTController {

	@Autowired

	private ManagerTravelDetailsServiceInterface managerTravelDetailsServiceInterface;

	// http://localhost:8080/restapi/employeetraveldetails/managerApproved/{travelRequestId=TR123}

	@PutMapping("managerApproved/{travelRequestId}")
	public boolean managerApprovedTravelRequestDetails(@PathVariable("travelRequestId") String travelRequestId,
			Model model) {
		boolean result = managerTravelDetailsServiceInterface.managerApprovedTravelRequestDetails(travelRequestId);
		if (result == true) {
			return true;
		} else {
			return false;
		}

	}

	
	//http://localhost:8080/restapi/employeetraveldetails/managerRejected/{travelRequestId=TR123}
	@PutMapping("managerRejected/{travelRequestId}")
	public boolean managerRejectedTravelRequestDetails(@PathVariable("travelRequestId") String travelRequestId,
			Model model) {
		boolean result = managerTravelDetailsServiceInterface.managerRejectedTravelRequestDetails(travelRequestId);
		if (result == true) {
			return true;
		} else {
			return false;
		}
	}
}
