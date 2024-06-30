package com.mindgate.main.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.BookingDetails;
import com.mindgate.main.domain.EmployeeTravelDetails;
import com.mindgate.main.domain.TravelRequestDetails;
import com.mindgate.main.service.EmployeeTravelDetailsServiceInterface;
import com.mindgate.main.service.TravelAgentDetailsServiceInterface;

@RestController
@RequestMapping("restapi/employeetraveldetails")
public class TravelAgentRestController {

	@Autowired
	private TravelAgentDetailsServiceInterface travelAgentDetailsServiceInterface;
	
	@Autowired
	private EmployeeTravelDetailsServiceInterface employeeTravelDetailsServiceInterface;
	
	//http://localhost:8080/restapi/employeetraveldetails/travelagent/checkslabdetails
	
	@GetMapping("travelagent/checkslabdetails")
	public boolean checkSlab(@RequestBody TravelRequestDetails travelRequestDetails) {
		TravelRequestDetails travelRequest = travelAgentDetailsServiceInterface.getOneTravelRequestDetail(travelRequestDetails.getTravelRequestId());
		String employeeId = travelRequest.getEmployeeTravelDetails().getEmployeeId();
		EmployeeTravelDetails employeeTravelDetails = employeeTravelDetailsServiceInterface.getOneEmployeeTravelDetail(employeeId);
		travelRequest.setEmployeeTravelDetails(employeeTravelDetails);
		
		double amount = travelRequestDetails.getEmployeeTravelDetails().getSlabDetails().getAmount();
		
		return travelAgentDetailsServiceInterface.checkSlab(travelRequest, amount);
	}
	
	
//	---------- Testing checkSlab API ---------
//	URL - http://localhost/restapi/employeetraveldetails/travelagent/checkslabdetails
//	Method - POST
//	content-
//	{
//	    "travelRequestId": "TR276",
//	    "employeeTravelDetails" : {
//	        "slabDetails": {
//	            "amount": 30000
//	        }
//	    }
//	}
	
	
	
	//http://localhost:8080/restapi/employeetraveldetails/travelagent/addBookingDetails
	@PostMapping("travelagent/addBookingDetails")
	public boolean addBookingDetails(@RequestBody BookingDetails bookingDetails) {
		return travelAgentDetailsServiceInterface.bookTicket(bookingDetails);
	}
	
	
//	---------- Testing addBookingDetails API ---------
//	URL - http://localhost/restapi/employeetraveldetails/travelagent/addBookingDetails
//	Method - POST
//	content-
//	{
//	    "fromDate": "2024-07-16",
//	    "toDate": "2024-08-15",
//	    "travelMode": "Cab",
//	    "destination": "Thane",
//	    "region": "Mumbai",
//	    "travelModeName": "Ola",
//	    "travelRequestDetails": {
//	        "travelRequestId": "TR276"
//	    }
//	}
	
	
	//http://localhost:8080/restapi/employeetraveldetails/travelagent/contactdirector/{travelRequestId}
	@PutMapping("travelagent/contactdirector/{travelRequestId}")
	public boolean contactDirector(@PathVariable("travelRequestId") String travelRequestId) {
		return travelAgentDetailsServiceInterface.contactDirector(travelRequestId);
	}
	
}

//---------- Testing contactDirector API ---------
//URL - http://localhost:8080/restapi/travelagent/contactdirector/TR276
//Method - PUT
