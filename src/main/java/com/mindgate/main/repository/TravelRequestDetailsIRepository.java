package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.TravelRequestDetails;
import com.mindgate.main.rowmapper.TravelRequestDetailsRowMapper;

@Repository
public class TravelRequestDetailsIRepository implements TravelRequestDetailsIRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
/////////////////////////////////////Employee Query////////////////////////////////////////////////////////////////
	private static final String PENDING_REQUEST_DETAILS = "select * from travel_request_details where employee_id=? AND status='Pending'";
	private static final String SHOW_ALL_REQUEST_DETAILS = "select * from travel_request_details where employee_id=? AND status='Approved by Travel Agent'";
	private static final String RAISE_A_REQUEST = "Insert into travel_request_details(travel_request_id,reason,from_date,to_date,destination,region,travel_mode,status,employee_id,name) Values('TR'||travel_request_id_sequence.NEXTVAL,?,?,?,?,?,?,?,?,?)";
	private static final String APPROVEL_REQUEST_DETAILS = "select * from travel_request_details where employee_id=? AND status in('Approved by Manager' , 'Approved by Director')";
	private static final String REJECTED_REQUEST_DETAILS = "select * from travel_request_details where employee_id=? AND  status in('Rejected by Manager' ,'Rejected by Director' ,'Rejected by Travel Agent')";
	
	/////////////////////////////////////Manager Query////////////////////////////////////////////////////////////////
	private static final String ALL_PENDING_REQUEST = "SELECT * FROM travel_request_details WHERE employee_id=? AND status IN('Pending (Manager)')";
	private static final String ALL_MANAGER_REQUESTS = "SELECT * FROM travel_request_details t INNER JOIN employee_travel_details e ON t.employee_id=e.employee_id WHERE report_to=? AND status='Pending'";
	private static final String ALL_APPROVE_REQUEST = "SELECT * FROM travel_request_details WHERE employee_id=? AND status IN('Approved by Director')";
	private static final String REJECTED_REQUESTS="SELECT * FROM travel_request_details WHERE employee_id=? AND  STATUS IN('Rejected by Travel Agent','Rejected by Director')";
	private static final String All_Previous_Request ="SELECT * FROM travel_request_details WHERE employee_id=? AND  STATUS IN('Approved by Travel Agent')";
	
	private static final String MANAGER_NOTIFICATIONS = "SELECT * FROM travel_request_details where STATUS='Rejected by Travel Agent' ";
	
	

////////////////////////////////////////Travel Agent///////////////////////////////////////////////////////
	
	private static final String ALL_TRAVEL_AGENT_PENDING_REQUEST = "SELECT * FROM travel_request_details t INNER JOIN employee_travel_details e ON t.employee_id=e.employee_id WHERE status='Approved by Manager' OR (e.role='Manager' AND status='Pending (Manager)')";
	private static final String ALL_TRAVEL_AGENT_DIRECTOR_REQUEST = "SELECT * FROM travel_request_details WHERE status IN('Approved by Director')";
	
///////////////////////////////////////////Employee Repository Method///////////////////////////////////////////////////////////////
	
	@Override
	public List<TravelRequestDetails> pendingRequestDetails(String employeeId) {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> travelRequestDetails = jdbcTemplate.query(PENDING_REQUEST_DETAILS,
					travelRequestDetailsRowMapper, employeeId);
			if (travelRequestDetails != null) {
				return travelRequestDetails;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<TravelRequestDetails> showAllRequest(String employeeId) {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> travelRequestDetails1 = jdbcTemplate.query(SHOW_ALL_REQUEST_DETAILS,
					travelRequestDetailsRowMapper, employeeId);
			if (travelRequestDetails1 != null) {
				return travelRequestDetails1;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public TravelRequestDetails raiseTicket(TravelRequestDetails travelRequestDetails) {
		try {
			Object[] parament = {  travelRequestDetails.getReason(),
					travelRequestDetails.getFromDate(), travelRequestDetails.getToDate(),
					travelRequestDetails.getDestination(), travelRequestDetails.getRegion(),
					travelRequestDetails.getTravelMode(), travelRequestDetails.getStatus(),
					travelRequestDetails.getEmployeeTravelDetails().getEmployeeId(),travelRequestDetails.getEmployeeTravelDetails().getName() };
			int resultcount = jdbcTemplate.update(RAISE_A_REQUEST, parament);
			if (resultcount > 0)
				System.out.println(travelRequestDetails);
			return null;
		} catch (DataAccessException e) {
			System.out.println(e);
			return null;

		}

	}

	@Override
	public List<TravelRequestDetails> approveRequestDetails(String employeeId) {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> travelRequestDetails = jdbcTemplate.query(APPROVEL_REQUEST_DETAILS,
					travelRequestDetailsRowMapper, employeeId);
			if (travelRequestDetails != null) {
				return travelRequestDetails;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<TravelRequestDetails> RejectedRequestDetails(String employeeId) {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> travelRequestDetails = jdbcTemplate.query(REJECTED_REQUEST_DETAILS,
					travelRequestDetailsRowMapper, employeeId);
			if (travelRequestDetails != null) {
				return travelRequestDetails;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

///////////////////////////////////////////Manager Repository Method///////////////////////////////////////////////////////////////

	@Override
	public List<TravelRequestDetails> showAllPreviousRequest(String employeeId) {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> allPreviousRequest = jdbcTemplate.query(All_Previous_Request,
					travelRequestDetailsRowMapper, employeeId);
			return allPreviousRequest;
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public List<TravelRequestDetails> showAllPendingRequest(String employeeId) {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> allPendingRequest = jdbcTemplate.query(ALL_PENDING_REQUEST,
					travelRequestDetailsRowMapper, employeeId);
			return allPendingRequest;
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public List<TravelRequestDetails> showAllManagerPendingRequest(String employeeId) {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> allManagerRequest = jdbcTemplate.query(ALL_MANAGER_REQUESTS,
					travelRequestDetailsRowMapper, employeeId);
			return allManagerRequest;
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public List<TravelRequestDetails> getAllTravelRequestDetails() {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> allTravelRequestDetails = jdbcTemplate.query(MANAGER_NOTIFICATIONS,
					travelRequestDetailsRowMapper);
			return allTravelRequestDetails;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<TravelRequestDetails> showManagerRejectedRequest(String employeeId) {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper=new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> allRejectedRequest=jdbcTemplate.query(REJECTED_REQUESTS, travelRequestDetailsRowMapper,employeeId);
		
		return allRejectedRequest;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public List<TravelRequestDetails> allManagerApproveRequest(String employeeId) {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper=new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> allPreviousRequest=jdbcTemplate.query(ALL_APPROVE_REQUEST, travelRequestDetailsRowMapper,employeeId);
		
		return allPreviousRequest;
		}
		catch (Exception e)
		{
			return null;
		}

}
////////////////////////////////////////Travel Agent///////////////////////////////////////////////////////
	@Override
	public List<TravelRequestDetails> showAllTravelAgentPendingRequest() {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> allTravelAgentRequest = jdbcTemplate.query(ALL_TRAVEL_AGENT_PENDING_REQUEST, travelRequestDetailsRowMapper);
			return allTravelAgentRequest;
		}
		catch(DataAccessException e) {
			return null;
		}
	}

	@Override
	public List<TravelRequestDetails> showAllTravelAgentDirectorRequest() {
		TravelRequestDetailsRowMapper travelRequestDetailsRowMapper = new TravelRequestDetailsRowMapper();
		try {
			List<TravelRequestDetails> allTravelAgentRequest = jdbcTemplate.query(ALL_TRAVEL_AGENT_DIRECTOR_REQUEST, travelRequestDetailsRowMapper);
			return allTravelAgentRequest;
		}
		catch(DataAccessException e) {
			return null;
		}
	}
}