package com.linkcode.model;


public class receiptGenerator {

	public static void generatereceipt(String name, long mobileno, Vehicle vehicle, double bill) {
		
		System.out.println("-------------Bill Receipt-----------------");
		System.out.println("Customer Name :"+name);
		System.out.println("Mobile No :"+mobileno);
		System.out.println("Vehicle ID :"+vehicle.getVehicleId());
		System.out.println("Vehicle Rented Rate :"+vehicle.getRentalRate());
		System.out.println("Vehicle Rented Days :"+vehicle.getRentalDays());
		System.out.println("Total Bill :"+"Rs"+bill);
		System.out.println("---------------------------------------------");
		
		
	}


}
