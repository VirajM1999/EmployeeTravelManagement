package com.mindgate.main.service;

import com.mindgate.main.domain.BookingDetails;
import com.mindgate.main.domain.TravelRequestDetails;

public interface TravelAgentDetailsServiceInterface {

	public TravelRequestDetails getOneTravelRequestDetail(String travelRequestId);

	public boolean checkSlab(TravelRequestDetails travelRequestDetails, double amount);

	public boolean bookTicket(BookingDetails bookingDetails);

	public boolean contactDirector(String travelRequestId);

}
