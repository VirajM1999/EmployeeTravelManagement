package com.mindgate.main.repository;

import com.mindgate.main.domain.BookingDetails;
import com.mindgate.main.domain.TravelAgentDetails;
import com.mindgate.main.domain.TravelRequestDetails;

public interface TravelAgentDetailsRepositoryInterface {
	
//	public TravelAgentDetails validateTravelLogin(String username, String password);

	public TravelRequestDetails getOneTravelRequestDetail(String travelRequestId);

	public boolean checkSlab(TravelRequestDetails travelRequestDetails, double amount);

	public boolean bookTicket(BookingDetails bookingDetails);

	public boolean contactDirector(String travelRequestId);

}
