package com.mindgate.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.BookingDetails;
import com.mindgate.main.domain.TravelRequestDetails;

public class BookingDetailsRowMapper implements RowMapper<BookingDetails> {

	@Override
	public BookingDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		String bookingId = rs.getString("booking_id");
		LocalDate fromDate = rs.getDate("from_date").toLocalDate();
		LocalDate toDate = rs.getDate("to_date").toLocalDate();
		String travelMode = rs.getString("travel_mode");
		String destination = rs.getString("destination");
		String region = rs.getString("region");
		String travelModeName = rs.getString("travel_mode_name");
		String accomodation = rs.getString("accomodation");
		
		String travelRequestId = rs.getString("travel_request_id");
		TravelRequestDetails travelRequestDetails = new TravelRequestDetails();
		travelRequestDetails.setTravelRequestId(travelRequestId);
		
		BookingDetails bookingDetails = new BookingDetails(bookingId, fromDate, toDate, travelMode, destination, region, travelModeName, accomodation, travelRequestDetails);

		return bookingDetails;
	}

}
