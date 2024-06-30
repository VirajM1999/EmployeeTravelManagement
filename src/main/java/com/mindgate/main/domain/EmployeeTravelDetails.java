package com.mindgate.main.domain;

public class EmployeeTravelDetails {
	private String employeeId;
	private String name;
	private String designation;
	private long contactNumber;
	private String password;
	private String role;
	private String reportTo;

	private SlabDetails slabDetails;
	private String emailId;

	public EmployeeTravelDetails() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeTravelDetails(String employeeId, String name, String designation, long contactNumber,
			String password, String role, String reportTo, SlabDetails slabDetails, String emailId) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.designation = designation;
		this.contactNumber = contactNumber;
		this.password = password;
		this.role = role;
		this.reportTo = reportTo;
		this.slabDetails = slabDetails;
		this.emailId = emailId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getReportTo() {
		return reportTo;
	}

	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}

	public SlabDetails getSlabDetails() {
		return slabDetails;
	}

	public void setSlabDetails(SlabDetails slabDetails) {
		this.slabDetails = slabDetails;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "EmployeeTravelDetails [employeeId=" + employeeId + ", name=" + name + ", designation=" + designation
				+ ", contactNumber=" + contactNumber + ", password=" + password + ", role=" + role + ", reportTo="
				+ reportTo + ", slabDetails=" + slabDetails + ", emailId=" + emailId + "]";
	}

}
