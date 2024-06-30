package com.mindgate.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.EmployeeTravelDetails;
import com.mindgate.main.domain.SlabDetails;

public class EmployeeTravelDetailsRowMapper implements RowMapper<EmployeeTravelDetails>
{

	@Override
	public EmployeeTravelDetails mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		 String employeeId = rs.getString("employee_id");
	        String name = rs.getString("employee_name");
	        String designation = rs.getString("designation");
	        long contactNumber = rs.getLong("contact_number");
	        String password = rs.getString("password");
	        String role = rs.getString("role");
	        String reportTo = rs.getString("report_to");
	        
	        String slabId = rs.getString("slab_id");
	        SlabDetails slabDetails = new SlabDetails();
	        slabDetails.setSlabId(slabId);
	        String emailId =rs.getString("email_id");

	        EmployeeTravelDetails employeeTravelDetails = new EmployeeTravelDetails(employeeId, name, designation,
	                contactNumber, password, role, reportTo, slabDetails,emailId);
	        
	        return employeeTravelDetails;
	    }

}
