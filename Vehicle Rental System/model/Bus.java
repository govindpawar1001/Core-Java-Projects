package com.linkcode.model;

public class Bus extends Vehicle {

	private int noofSeeats;

	public Bus(String vehicleId, double rentalRate, int noofSeeats) {
		super(vehicleId, rentalRate);
		this.noofSeeats = noofSeeats;
	}
	
	public void displayInfo() {
		
	}

}
