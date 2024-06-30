package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.TravelRequestDetails;

public interface DirectorTravelDetailsRepositoryInterface {

	public List<TravelRequestDetails> showRequestRejectedByTravelAgent();
	public boolean acceptStatus(String travelRequestId);
	public boolean rejectStatus(String travelRequestId);
	public List<TravelRequestDetails> showPendingStatusOfDirector(String employeeId);
	public List<TravelRequestDetails> showHistoryOfDirector(String employeeId);
	
}
