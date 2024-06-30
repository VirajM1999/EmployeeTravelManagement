package com.mindgate.main.domain;

import java.time.LocalDate;

public class TravelRequestDetails 
{
	private String travelRequestId;
	private String name;
	private String reason;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String destination;
	private String region;
	private String travelMode;
	private String status;
	private EmployeeTravelDetails employeeTravelDetails;
	
	
	public TravelRequestDetails() {
		// TODO Auto-generated constructor stub
	}

	public TravelRequestDetails(String travelRequestId, String name, String reason, LocalDate fromDate,
			LocalDate toDate, String destination, String region, String travelMode, String status,
			EmployeeTravelDetails employeeTravelDetails) {
		super();
		this.travelRequestId = travelRequestId;
		this.name = name;
		this.reason = reason;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.destination = destination;
		this.region = region;
		this.travelMode = travelMode;
		this.status = status;
		this.employeeTravelDetails = employeeTravelDetails;
	}

	public String getTravelRequestId() {
		return travelRequestId;
	}

	public void setTravelRequestId(String travelRequestId) {
		this.travelRequestId = travelRequestId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public String getTravelMode() {
		return travelMode;
	}

	public void setTravelMode(String travelMode) {
		this.travelMode = travelMode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EmployeeTravelDetails getEmployeeTravelDetails() {
		return employeeTravelDetails;
	}

	public void setEmployeeTravelDetails(EmployeeTravelDetails employeeTravelDetails) {
		this.employeeTravelDetails = employeeTravelDetails;
	}

	@Override
	public String toString() {
		return "TravelRequestDetails [travelRequestId=" + travelRequestId + ", name=" + name + ", reason=" + reason
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", destination=" + destination + ", region=" + region + ", travelMode="
				+ travelMode + ", status=" + status + ", employeeTravelDetails=" + employeeTravelDetails + "]";
	}


}
