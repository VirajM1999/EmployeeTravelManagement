package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.TravelRequestDetails;
import com.mindgate.main.rowmapper.TravelRequestDetailsRowMapper;
@Repository
public class DirectorTravelDetailsRepository  implements DirectorTravelDetailsRepositoryInterface{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String STATUS_DETAILS = "select * from travel_request_details where  status='Rejected by Travel Agent'";
	private static final String APPROVED_BY_DIRECTOR = "UPDATE travel_request_details SET status='Approved by Director' where travel_request_id=?";
	private static final String REJECTED_BY_DIRECTOR = "UPDATE travel_request_details SET status='Rejected by Director' where travel_request_id=?";
	private static final String PENDING_REQUEST_OF_DIRECTOR = "select * from travel_request_details where status='Pending' and employee_id=?";
	private static final String HISTORY_OF_DIRECTOR = "select * from travel_request_details where status='Approved by Travel Agent' and employee_id=?";

	
	
	@Override
	public List<TravelRequestDetails> showRequestRejectedByTravelAgent() {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> travelRequestDetails = jdbcTemplate.query(STATUS_DETAILS,
					travelRequestDetailsRowMapper);
			return travelRequestDetails;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@Override
	public boolean acceptStatus(String travelRequestId) {
		try 
		{
			int result = jdbcTemplate.update(APPROVED_BY_DIRECTOR, travelRequestId);
				if (result > 0)
				{
					return true;
				}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean rejectStatus(String travelRequestId) {
		try 
		{
			int result = jdbcTemplate.update(REJECTED_BY_DIRECTOR,travelRequestId);
				if (result > 0)
				{
					return true;
				}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return false;
	}

	@Override
	public List<TravelRequestDetails> showPendingStatusOfDirector(String employeeId) {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> travelRequestDetails = jdbcTemplate.query(PENDING_REQUEST_OF_DIRECTOR,
					travelRequestDetailsRowMapper,employeeId);
			return travelRequestDetails;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@Override
	public List<TravelRequestDetails> showHistoryOfDirector(String employeeId) {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> travelRequestDetails = jdbcTemplate.query(HISTORY_OF_DIRECTOR,
					travelRequestDetailsRowMapper,employeeId);
			return travelRequestDetails;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	
}
