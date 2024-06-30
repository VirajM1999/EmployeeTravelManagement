package com.mindgate.main.domain;

import java.time.LocalDate;

public class BookingDetails {
	private String bookingId;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String travelMode;
	private String destination;
	private String region;
	private String travelModeName;
	private String accomodation;
	private TravelRequestDetails travelRequestDetails;

	public BookingDetails() {
		// TODO Auto-generated constructor stub
	}

	public BookingDetails(String bookingId, LocalDate fromDate, LocalDate toDate, String travelMode, String destination,
			String region, String travelModeName, String accomodation, TravelRequestDetails travelRequestDetails) {
		super();
		this.bookingId = bookingId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.travelMode = travelMode;
		this.destination = destination;
		this.region = region;
		this.travelModeName = travelModeName;
		this.accomodation = accomodation;
		this.travelRequestDetails = travelRequestDetails;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getTravelMode() {
		return travelMode;
	}

	public void setTravelMode(String travelMode) {
		this.travelMode = travelMode;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTravelModeName() {
		return travelModeName;
	}

	public void setTravelModeName(String travelModeName) {
		this.travelModeName = travelModeName;
	}

	public String getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(String accomodation) {
		this.accomodation = accomodation;
	}

	public TravelRequestDetails getTravelRequestDetails() {
		return travelRequestDetails;
	}

	public void setTravelRequestDetails(TravelRequestDetails travelRequestDetails) {
		this.travelRequestDetails = travelRequestDetails;
	}

	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", travelMode=" + travelMode + ", destination=" + destination + ", region=" + region
				+ ", travelModeName=" + travelModeName + ", accomodation=" + accomodation + ", travelRequestDetails="
				+ travelRequestDetails + "]";
	}

}
