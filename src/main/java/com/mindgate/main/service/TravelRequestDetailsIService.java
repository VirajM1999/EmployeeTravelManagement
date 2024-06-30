package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.TravelRequestDetails;
import com.mindgate.main.repository.TravelRequestDetailsIRepositoryInterface;

@Service
public class TravelRequestDetailsIService implements TravelRequestDetailsServiceInterface {
	@Autowired
	private TravelRequestDetailsIRepositoryInterface travelRequestDetailsIRepositoryInterface;

////////////////////////////////Employee Service Methods///////////////////////////////////////////////
	
	@Override
	public List<TravelRequestDetails> pendingRequestDetails(String employeeId) {
		return travelRequestDetailsIRepositoryInterface.pendingRequestDetails(employeeId);
	}

	@Override
	public List<TravelRequestDetails> showAllRequest(String employeeId) {
		return travelRequestDetailsIRepositoryInterface.showAllRequest(employeeId);
	}

	@Override
	public TravelRequestDetails raiseTicket(TravelRequestDetails travelRequestDetails) {
		return travelRequestDetailsIRepositoryInterface.raiseTicket(travelRequestDetails);
	}


	@Override
	public List<TravelRequestDetails> approveRequestDetails(String employeeId) {
		return travelRequestDetailsIRepositoryInterface.approveRequestDetails(employeeId);
	}

	@Override
	public List<TravelRequestDetails> RejectedRequestDetails(String employeeId) {
		return travelRequestDetailsIRepositoryInterface.RejectedRequestDetails(employeeId);
	}

////////////////////////////////Manager Service Method///////////////////////////////////////////////

	@Override
	public List<TravelRequestDetails> showAllPreviousRequest(String employeeId) {
		return travelRequestDetailsIRepositoryInterface.showAllPreviousRequest(employeeId);
	}

	@Override
	public List<TravelRequestDetails> showAllPendingRequest(String employeeId) {
		return travelRequestDetailsIRepositoryInterface.showAllPendingRequest(employeeId);
	}

	public List<TravelRequestDetails> showAllManagerPendingRequest(String employeeId) {
		return travelRequestDetailsIRepositoryInterface.showAllManagerPendingRequest(employeeId);
	}

	@Override
	public List<TravelRequestDetails> getAllTravelRequestDetails() {
		 return travelRequestDetailsIRepositoryInterface.getAllTravelRequestDetails();	}

	@Override
	public List<TravelRequestDetails> showManagerRejectedRequest(String employeeId) {
		return travelRequestDetailsIRepositoryInterface.showManagerRejectedRequest(employeeId);
	}

	@Override
	public List<TravelRequestDetails> allManagerApproveRequest(String employeeId) {
		return travelRequestDetailsIRepositoryInterface.allManagerApproveRequest(employeeId);
	}

////////////////////////////////TravelAgent Service Method///////////////////////////////////////////////	
	@Override
	public List<TravelRequestDetails> showAllTravelAgentPendingRequest() {
		return travelRequestDetailsIRepositoryInterface.showAllTravelAgentPendingRequest();
	}
	
	@Override
	public List<TravelRequestDetails> showAllTravelAgentDirectorRequest() {
		return travelRequestDetailsIRepositoryInterface.showAllTravelAgentDirectorRequest();
	}
}
