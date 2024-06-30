package com.mindgate.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.SlabDetails;

public class SlabDetailsRowMapper implements RowMapper<SlabDetails> {

	@Override
	public SlabDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		String slabId = rs.getString("slab_id");
		String region = rs.getString("region");
		double amount = rs.getDouble("amount");
		String travelMode1 = rs.getString("travel_mode_1");
		String travelMode2 = rs.getString("travel_mode_2");
		String travelMode3 = rs.getString("travel_mode_3");
		String travelMode4 = rs.getString("travel_mode_4");
		
		SlabDetails slabDetails = new SlabDetails(slabId, region, amount, travelMode1, travelMode2, travelMode3, travelMode4);
		
		return slabDetails;

	}


}