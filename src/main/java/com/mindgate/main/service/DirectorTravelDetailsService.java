package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.TravelRequestDetails;
import com.mindgate.main.repository.DirectorTravelDetailsRepositoryInterface;
@Service
public class DirectorTravelDetailsService implements DirectorTravelDetailsServiceInterface{

	@Autowired
	private DirectorTravelDetailsRepositoryInterface directorTravelDetailsRepositoryInterface;
	
	@Override
	public List<TravelRequestDetails> showRequestRejectedByTravelAgent() {
		return directorTravelDetailsRepositoryInterface.showRequestRejectedByTravelAgent();
	}

	@Override
	public boolean acceptStatus(String travelRequestId) {
		return directorTravelDetailsRepositoryInterface.acceptStatus(travelRequestId);
	}

	@Override
	public boolean rejectStatus(String travelRequestId) {
		return directorTravelDetailsRepositoryInterface.rejectStatus(travelRequestId);
	}

	@Override
	public List<TravelRequestDetails> showPendingStatusOfDirector(String employeeId) {
		return directorTravelDetailsRepositoryInterface.showPendingStatusOfDirector(employeeId);
	}

	@Override
	public List<TravelRequestDetails> showHistoryOfDirector(String employeeId) {
		return directorTravelDetailsRepositoryInterface.showHistoryOfDirector(employeeId);
	}
	
	

}
