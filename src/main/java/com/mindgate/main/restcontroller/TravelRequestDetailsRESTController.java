package com.mindgate.main.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.TravelRequestDetails;
import com.mindgate.main.service.TravelRequestDetailsServiceInterface;

@RestController
@RequestMapping("restapi/employeetraveldetails")
public class TravelRequestDetailsRESTController {

	@Autowired
	private TravelRequestDetailsServiceInterface travelRequestDetailsServiceInterface;

	//http://localhost:8080/restapi/employeetraveldetails/raiseTicket
	
	@PostMapping("raiseTicket")
	public TravelRequestDetails raiseRequest(@RequestBody TravelRequestDetails travelRequestDetails) {
		return travelRequestDetailsServiceInterface.raiseTicket(travelRequestDetails);

	}

}
