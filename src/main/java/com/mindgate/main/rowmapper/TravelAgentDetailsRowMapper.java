package com.mindgate.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.TravelAgentDetails;

public class TravelAgentDetailsRowMapper implements RowMapper<TravelAgentDetails>
{

	@Override
	public TravelAgentDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		 String username = rs.getString("username");
	        String password = rs.getString("password");

	        TravelAgentDetails travelAgentDetails = new TravelAgentDetails(username, password);

	        return travelAgentDetails;
	}

}
