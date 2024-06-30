package com.mindgate.main.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.EmployeeTravelDetails;
import com.mindgate.main.domain.TravelAgentDetails;
import com.mindgate.main.rowmapper.EmployeeTravelDetailsRowMapper;
import com.mindgate.main.rowmapper.TravelAgentDetailsRowMapper;

@Repository
public class EmployeeTravelDetailsRepository implements EmployeeTravelDetailsRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String VALIDATE_EMPLOYEE_LOGIN = "select * from employee_travel_details where employee_id=? AND password=? AND role=?";
	private static final String VALIDATE_TRAVEL_AGENT_LOGIN = "select * from travel_agent_details where username=? AND password=?";
	private static final String ONE_EMPLOYEE_DETAIL = "SELECT * FROM employee_travel_details WHERE employee_id=?";

	
	@Override
	public EmployeeTravelDetails validateEmployeeLogin(String employeeId, String password ,String role) {
		EmployeeTravelDetailsRowMapper employeeDetailsRowMapper = new EmployeeTravelDetailsRowMapper();
		try {
			EmployeeTravelDetails employeeTravelDetails = jdbcTemplate.queryForObject(VALIDATE_EMPLOYEE_LOGIN,
					employeeDetailsRowMapper, employeeId, password,role);
			return employeeTravelDetails;
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public TravelAgentDetails validateTravelLogin(String username, String password ) {
		TravelAgentDetailsRowMapper travelAgentDetailsRowMapper = new TravelAgentDetailsRowMapper();
		try {
			TravelAgentDetails travelAgentDetails = jdbcTemplate.queryForObject(VALIDATE_TRAVEL_AGENT_LOGIN,
					travelAgentDetailsRowMapper, username, password);
			return travelAgentDetails;
		} catch (DataAccessException e) {
			return null;
		}
	}

	
	////////////////////////////////////////Travel Agent////////////////////////////////////////////////
	@Override
	public EmployeeTravelDetails getOneEmployeeTravelDetail(String employeeId) {
		EmployeeTravelDetailsRowMapper employeeDetailsRowMapper = new EmployeeTravelDetailsRowMapper();
		try {
			EmployeeTravelDetails employeeTravelDetails = jdbcTemplate.queryForObject(ONE_EMPLOYEE_DETAIL, employeeDetailsRowMapper, employeeId);
			if(employeeTravelDetails != null) {
				return employeeTravelDetails;
			}
		}
		catch (Exception e) {
			return null;
		}
		return null;
	}

	
}
