package com.linkcode.model;

public class Car extends Vehicle{
	
	private int noofSeats;

	
	public Car(String vehicleId, double rentalRate,int noofSeats) {
		super(vehicleId, rentalRate);
		this.noofSeats=noofSeats;
		
	}
	

	public void displayInfo() {
		
	}

	
	
	

}
