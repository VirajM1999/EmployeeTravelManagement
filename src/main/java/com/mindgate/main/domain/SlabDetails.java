package com.mindgate.main.domain;

public class SlabDetails 
{
	private String slabId;
	private String region;
	private double amount;
	private String travleMode1;
	private String travelMode2;
	private String travelMode3;
	private String travelMode4;

	public SlabDetails() {
		// TODO Auto-generated constructor stub
	}

	public SlabDetails(String slabId, String region, double amount, String travleMode1, String travelMode2,
			String travelMode3, String travelMode4) {
		super();
		this.slabId = slabId;
		this.region = region;
		this.amount = amount;
		this.travleMode1 = travleMode1;
		this.travelMode2 = travelMode2;
		this.travelMode3 = travelMode3;
		this.travelMode4 = travelMode4;
	}

	public String getSlabId() {
		return slabId;
	}

	public void setSlabId(String slabId) {
		this.slabId = slabId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTravleMode1() {
		return travleMode1;
	}

	public void setTravleMode1(String travleMode1) {
		this.travleMode1 = travleMode1;
	}

	public String getTravelMode2() {
		return travelMode2;
	}

	public void setTravelMode2(String travelMode2) {
		this.travelMode2 = travelMode2;
	}

	public String getTravelMode3() {
		return travelMode3;
	}

	public void setTravelMode3(String travelMode3) {
		this.travelMode3 = travelMode3;
	}

	public String getTravelMode4() {
		return travelMode4;
	}

	public void setTravelMode4(String travelMode4) {
		this.travelMode4 = travelMode4;
	}

	@Override
	public String toString() {
		return "slab [slabId=" + slabId + ", region=" + region + ", amount=" + amount + ", travleMode1="
				+ travleMode1 + ", travelMode2=" + travelMode2 + ", travelMode3=" + travelMode3
				+ ", travelMode4=" + travelMode4 + "]";
	}

	}
