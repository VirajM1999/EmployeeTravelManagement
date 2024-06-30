package com.mindgate.main.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.mindgate.main.domain.BookingDetails;
import com.mindgate.main.domain.TravelRequestDetails;
import com.mindgate.main.rowmapper.TravelRequestDetailsRowMapper;

@Repository
public class TravelAgentDetailsRepository implements TravelAgentDetailsRepositoryInterface {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String CHECK_SLAB_TRAINEE = "SELECT * FROM travel_request_details t, employee_travel_details e, slab_details s WHERE t.employee_id=e.employee_id AND e.slab_id=s.slab_id AND t.travel_request_id=? AND t.region IN('Mumbai') AND s.amount>=? AND (s.travel_mode_1=? OR s.travel_mode_2=? OR s.travel_mode_3=? OR s.travel_mode_4=?)";
	private static final String CHECK_SLAB_DEVELOPER = "SELECT * FROM travel_request_details t, employee_travel_details e, slab_details s WHERE t.employee_id=e.employee_id AND e.slab_id=s.slab_id AND t.travel_request_id=? AND t.region IN('Mumbai','Maharashtra') AND s.amount>=? AND (s.travel_mode_1=? OR s.travel_mode_2=? OR s.travel_mode_3=? OR s.travel_mode_4=?)";
	private static final String CHECK_SLAB_MANAGER = "SELECT * FROM travel_request_details t, employee_travel_details e, slab_details s WHERE t.employee_id=e.employee_id AND e.slab_id=s.slab_id AND t.travel_request_id=? AND t.region IN('Mumbai','Maharashtra','India') AND s.amount>=? AND (s.travel_mode_1=? OR s.travel_mode_2=? OR s.travel_mode_3=? OR s.travel_mode_4=?)";
	
	private static final String SAVE_BOOKING_DETAILS = "INSERT INTO booking_details VALUES ('B'||booking_id_sequence.NEXTVAL,?,?,?,?,?,?,?,?)";
	private static final String TRAVEL_AGENT_APPROVE = "UPDATE travel_request_details SET status='Approved by Travel Agent' WHERE travel_request_id=?";
	private static final String TRAVEL_AGENT_REJECT = "UPDATE travel_request_details SET status='Rejected by Travel Agent' WHERE travel_request_id=?";
	private static final String ONE_TRAVEL_REQUEST = "SELECT * FROM travel_request_details WHERE travel_request_id=?";



	@Override
	public TravelRequestDetails getOneTravelRequestDetail(String travelRequestId) {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			TravelRequestDetails travelRequestDetails = jdbcTemplate.queryForObject(ONE_TRAVEL_REQUEST, travelRequestDetailsRowMapper, travelRequestId);
			if(travelRequestDetails != null) {
				return travelRequestDetails;
			}
		}
		catch (Exception e) {
			return null;
		}
		return null;
	}
	
	@Override
	public boolean checkSlab(TravelRequestDetails travelRequestDetails, double amount) {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		Object[] parameters = {travelRequestDetails.getTravelRequestId(), amount, travelRequestDetails.getTravelMode(), travelRequestDetails.getTravelMode(), travelRequestDetails.getTravelMode(), travelRequestDetails.getTravelMode()};
		String designation = travelRequestDetails.getEmployeeTravelDetails().getDesignation();
		
		try {
			if(designation.equals("Trainee")) {
				travelRequestDetails = jdbcTemplate.queryForObject(CHECK_SLAB_TRAINEE, travelRequestDetailsRowMapper, parameters);
			}
			else if(designation.equals("Developer")) {
				travelRequestDetails = jdbcTemplate.queryForObject(CHECK_SLAB_DEVELOPER, travelRequestDetailsRowMapper, parameters);
			}
			else {
				travelRequestDetails = jdbcTemplate.queryForObject(CHECK_SLAB_MANAGER, travelRequestDetailsRowMapper, parameters);
			}
			
			if(travelRequestDetails != null) {
				return true;
			}
		}
		catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean bookTicket(BookingDetails bookingDetails) {
		Object[] parameters = { bookingDetails.getFromDate(), bookingDetails.getToDate(),
				bookingDetails.getTravelMode(), bookingDetails.getDestination(), bookingDetails.getRegion(), bookingDetails.getTravelModeName(),
				bookingDetails.getAccomodation(), bookingDetails.getTravelRequestDetails().getTravelRequestId() };
		
		try {
			int resultCount = jdbcTemplate.update(SAVE_BOOKING_DETAILS, parameters);
			if (resultCount > 0) {
				int approve = jdbcTemplate.update(TRAVEL_AGENT_APPROVE, bookingDetails.getTravelRequestDetails().getTravelRequestId());
				if(approve > 0) {
					return true;
				}
			}
		} 
		catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean contactDirector(String travelRequestId) {
		try {
			int resultCount = jdbcTemplate.update(TRAVEL_AGENT_REJECT, travelRequestId);
			if (resultCount > 0) {
				return true;
			}
		} catch (DataAccessException e) {
			return false;
		}
		return false;
	}

}

