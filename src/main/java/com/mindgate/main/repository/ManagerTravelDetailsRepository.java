package com.mindgate.main.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerTravelDetailsRepository implements ManagerTravelDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String MANAGER_APPROVED = "UPDATE travel_request_details SET status='Approved by Manager' WHERE travel_request_id=?";
	private static final String MANAGER_REJECTED = "UPDATE travel_request_details SET status='Rejected by Manager' WHERE travel_request_id=?";

	@Override
	public boolean managerApprovedTravelRequestDetails(String travelRequestId) {
		int resultCount = jdbcTemplate.update(MANAGER_APPROVED, travelRequestId);
		if (resultCount > 0) {
			return true;
		}

		return false;
	}

	public boolean managerRejectedTravelRequestDetails(String travelRequestId) {
		int resultCount = jdbcTemplate.update(MANAGER_REJECTED, travelRequestId);
		if (resultCount > 0) {
			return true;
		}

		return false;
	}

}
