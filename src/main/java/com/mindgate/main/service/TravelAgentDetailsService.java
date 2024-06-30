package com.mindgate.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.BookingDetails;
import com.mindgate.main.domain.TravelRequestDetails;
import com.mindgate.main.repository.TravelAgentDetailsRepositoryInterface;
@Service
public class TravelAgentDetailsService implements TravelAgentDetailsServiceInterface {

	@Autowired
	private TravelAgentDetailsRepositoryInterface travelAgentDetailsRepositoryInterface;

	@Override
	public TravelRequestDetails getOneTravelRequestDetail(String travelRequestId) {
		return travelAgentDetailsRepositoryInterface.getOneTravelRequestDetail(travelRequestId);
	}
	
	@Override
	public boolean checkSlab(TravelRequestDetails travelRequestDetails, double amount) {
		return travelAgentDetailsRepositoryInterface.checkSlab(travelRequestDetails, amount);
	}

	@Override
	public boolean bookTicket(BookingDetails bookingDetails) {
		return travelAgentDetailsRepositoryInterface.bookTicket(bookingDetails);
	}

	@Override
	public boolean contactDirector(String travelRequestId) {
		return travelAgentDetailsRepositoryInterface.contactDirector(travelRequestId);
	}

}