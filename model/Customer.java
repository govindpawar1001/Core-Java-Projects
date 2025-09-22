package com.linkcode.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
	
	private String name;
	private long mobileno;
	private boolean islicenseAvailable;
	private List<Vehicle> Vehicles;
	
	static Scanner sc=new Scanner(System.in);
	
	public Customer(String name, long mobileno, boolean islicenseAvailable) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.islicenseAvailable = islicenseAvailable;
		Vehicles=new ArrayList<Vehicle>();
	}

	public void rentVehicle(Vehicle vehicle, int days) {
		if(vehicle.rent(days, this.name,this.mobileno)) {
			Vehicles.add(vehicle);
		}
		
		
	}
	
	public void returnAllvehicles() {
		
		for(Vehicle vehicle :Vehicles) {
			vehicle.returnvehicle();
			
		}
		Vehicles.clear();
		
	}
	
	
	
	public void viewRentalvehicle() {
		if (Vehicles.isEmpty()) {
	        System.out.println("No rented vehicles available.");	
	        
		}else{
			System.out.println("List of all rented vehicle");
		}
		
		Vehicles.forEach(val->System.out.println("Vehicle ID :"+val.getVehicleId()+"\nRented Days: "+val.getRentalDays()));

	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public boolean isIslicenseAvailable() {
		return islicenseAvailable;
	}

	public void setIslicenseAvailable(boolean islicenseAvailable) {
		this.islicenseAvailable = islicenseAvailable;
	}

	public List<Vehicle> getVehicles() {
		return Vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		Vehicles = vehicles;
	}

	



	
	

	

	
	


}
