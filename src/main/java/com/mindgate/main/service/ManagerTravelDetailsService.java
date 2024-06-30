package com.mindgate.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.repository.ManagerTravelDetailsRepositoryInterface;

@Service
public class ManagerTravelDetailsService implements ManagerTravelDetailsServiceInterface {

	@Autowired
	private ManagerTravelDetailsRepositoryInterface managerTravelDetailsRepositoryInterface;

	@Override
	public boolean managerApprovedTravelRequestDetails(String travelRequestId) {
		return managerTravelDetailsRepositoryInterface.managerApprovedTravelRequestDetails(travelRequestId);
	}

	@Override
	public boolean managerRejectedTravelRequestDetails(String travelRequestId) {
		return managerTravelDetailsRepositoryInterface.managerRejectedTravelRequestDetails(travelRequestId);
	}
}
