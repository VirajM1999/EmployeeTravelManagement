package com.mindgate.main.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.mindgate.main.domain.BookingDetails;
import com.mindgate.main.rowmapper.BookingDetailsRowMapper;

@Repository
public class BookingDetailsRepository implements BookingDetailsRepositoryInterface
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECT_BOOKING_REQUEST_DETAILS = "select * from booking_details where travel_request_id=?";


	@Override
	public BookingDetails viewTBookingDetails(String travelRequestId) {
		  BookingDetailsRowMapper bookingDetailsRowMapper = new BookingDetailsRowMapper();
	        try
	        {
	            BookingDetails bookingDetails=jdbcTemplate.queryForObject(SELECT_BOOKING_REQUEST_DETAILS, bookingDetailsRowMapper,  travelRequestId);
	            
	            return bookingDetails;
	        }catch (Exception e) {
	            System.out.println(e);
	        }
	        
	        
	        return null;
	}

	
	
}
