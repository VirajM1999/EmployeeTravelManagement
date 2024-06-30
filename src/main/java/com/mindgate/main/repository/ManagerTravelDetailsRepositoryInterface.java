package com.mindgate.main.repository;

public interface ManagerTravelDetailsRepositoryInterface {
	
	public boolean managerApprovedTravelRequestDetails(String travelRequestId);

	public boolean managerRejectedTravelRequestDetails(String travelRequestId);

}
