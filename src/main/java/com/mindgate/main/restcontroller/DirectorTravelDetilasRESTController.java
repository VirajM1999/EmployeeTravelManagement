package com.mindgate.main.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.service.DirectorTravelDetailsServiceInterface;

@RestController
@RequestMapping("restapi/employeetraveldetails")
public class DirectorTravelDetilasRESTController {

	@Autowired
	private DirectorTravelDetailsServiceInterface directorServiceServiceInterface;

	// http://localhost:8080/restapi/employeetraveldetails/directorapproved/{travelRequestId=TR123}
	
	@PutMapping("directorapproved/{travelRequestId}")
	public boolean approvedRequest(@PathVariable("travelRequestId") String travelRequestId) {
		boolean result = directorServiceServiceInterface.acceptStatus(travelRequestId);
		if (result) {
			return true;
		}
		return false;

	}
	
	// http://localhost:8080/restapi/employeetraveldetails/directorrejected/{travelRequestId=TR123}

	@PutMapping("directorrejected/{travelRequestId}")
	public boolean rejectedRequest(@PathVariable("travelRequestId") String travelRequestId) {
		boolean result = directorServiceServiceInterface.rejectStatus(travelRequestId);
		if (result) {
			return true;
		}
		return false;

	}

}
