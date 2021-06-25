package com.cognizant.drools.cep.demo.model;

import java.io.Serializable;



public enum Location implements Serializable {

	CHECK_IN("check-in"), SORTING("sorting"), STAGING("staging"), LOADING("loading");
	
	private String location;
	
	private Location(String location) {
		this.setLocation(location);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
