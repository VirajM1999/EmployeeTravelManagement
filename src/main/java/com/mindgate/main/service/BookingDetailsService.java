package com.mindgate.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.BookingDetails;
import com.mindgate.main.repository.BookingDetailsRepositoryInterface;

@Service
public class BookingDetailsService  implements BookingDetailsServiceInterface{

	@Autowired
	BookingDetailsRepositoryInterface bookingDetailsRepositoryInterface;
	
	@Override
	public BookingDetails viewTBookingDetails(String travelRequestId) {
		
		return bookingDetailsRepositoryInterface.viewTBookingDetails(travelRequestId);
	}

}
