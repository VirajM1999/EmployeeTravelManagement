package com.mindgate.main.rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.EmployeeTravelDetails;
import com.mindgate.main.domain.TravelRequestDetails;

public class TravelRequestDetailsRowMapper implements RowMapper<TravelRequestDetails> {

	@Override
	public TravelRequestDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		String travelRequestId = rs.getString("travel_request_id");
		String name = rs.getString("name");
		String reason = rs.getString("reason");
		LocalDate fromDate = rs.getDate("from_date").toLocalDate();
		LocalDate toDate = rs.getDate("to_date").toLocalDate();
		String destination = rs.getString("destination");
		String region = rs.getString("region");
		String travelMode = rs.getString("travel_mode");
		String status = rs.getString("status");
		
		String employee_id = rs.getString("employee_id");
		EmployeeTravelDetails employeeTravelDetails = new EmployeeTravelDetails();
		employeeTravelDetails.setEmployeeId(employee_id);
		
		TravelRequestDetails travelRequestDetails = new TravelRequestDetails(travelRequestId, name, reason, fromDate, toDate, destination, region, travelMode, status, employeeTravelDetails);
		
		return travelRequestDetails;
	}


}
