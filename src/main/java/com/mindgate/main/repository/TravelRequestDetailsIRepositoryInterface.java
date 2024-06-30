package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.TravelRequestDetails;

public interface TravelRequestDetailsIRepositoryInterface {
	
	//////////////////////////////Employee//////////////////////////////////////////////
	public List<TravelRequestDetails> pendingRequestDetails(String employeeId);

	public List<TravelRequestDetails> showAllRequest(String employeeId);//booking details

	public List<TravelRequestDetails> approveRequestDetails(String employeeId);

	public List<TravelRequestDetails> RejectedRequestDetails(String employeeId);

	public TravelRequestDetails raiseTicket(TravelRequestDetails travelRequestDetails);
	
	/////////////////////////////////Manager/////////////////////////////////////////////////

	public List<TravelRequestDetails> showAllPreviousRequest(String employeeId);

	public List<TravelRequestDetails> showAllPendingRequest(String employeeId);

	public List<TravelRequestDetails> showAllManagerPendingRequest(String employeeId);

	public List<TravelRequestDetails> showManagerRejectedRequest(String employeeId);
	
	public List<TravelRequestDetails> allManagerApproveRequest(String employeeId);
	
	public List<TravelRequestDetails> getAllTravelRequestDetails();
	
	//////////////////////////////////Travel Agent/////////////////////////////////////////
	
	public List<TravelRequestDetails> showAllTravelAgentPendingRequest();
	
	public List<TravelRequestDetails> showAllTravelAgentDirectorRequest();
}
