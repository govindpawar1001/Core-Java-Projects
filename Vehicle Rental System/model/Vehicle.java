package com.linkcode.model;

import java.util.Scanner;

public class Vehicle {
	
	private String vehicleId;
	private double rentalRate;
	private boolean isAvailable;
	private int rentalDays;
	private boolean underMaintance;
	
	
	public Vehicle(String vehicleId, double rentalRate) {
		super();
		this.isAvailable=true;
		this.underMaintance=false;
		this.vehicleId = vehicleId;
		this.rentalRate = rentalRate;
		this.rentalDays = 0;
	}
	
	public boolean rent(int days,String name,long mobileno) {
		if(this.isAvailable) {
		double bill=this.rentalRate*days;
		System.out.println("Total Bill Amount :"+bill);
		boolean payment=PaymentGateway.processpayment(bill);
		if(payment) {
		isAvailable=false;
		rentalDays=days;
		receiptGenerator.generatereceipt(name,mobileno,this,bill);
		System.out.println("Sending bill to your mail......");
		System.out.println("Enter your mail id:");
		Scanner sc=new Scanner(System.in);
		String email=sc.next();
		EmailService.sendBookingConformation(name,days,rentalRate,bill,vehicleId,email);
		return true;
		}
		System.out.println("Payment not done....please try again ");
		return false;
	}
		System.out.println("Vehicle Not available");
		return false;
	}
	
	
	public void returnvehicle() {
		this.isAvailable=true;
		this.rentalDays=0;
		System.err.println(this.vehicleId +"  Return Succesufully");
	
		
	}
	
	public void sendforMaintance() {
		this.isAvailable=false;
		this.underMaintance=true;
		System.out.println(this.vehicleId+"  send for maintanance...");
		
	}
	
	public void completeMaintance() {
		this.isAvailable=true;
		this.underMaintance=false;
		System.out.println(this.vehicleId+" Mantainance Completed.....");
		
	}
	
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public int getRentalDays() {
		return rentalDays;
	}
	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}
	public boolean isUnderMaintance() {
		return underMaintance;
	}
	public void setUnderMaintance(boolean underMaintance) {
		this.underMaintance = underMaintance;
	}


	

}
