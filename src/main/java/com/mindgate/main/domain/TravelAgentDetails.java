package com.mindgate.main.domain;

public class TravelAgentDetails
{
	private String username;
	private String password;

	public TravelAgentDetails() {
		// TODO Auto-generated constructor stub
	}

	public TravelAgentDetails(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "travelAgentDetails [username=" + username + ", password=" + password + "]";
	}

}
