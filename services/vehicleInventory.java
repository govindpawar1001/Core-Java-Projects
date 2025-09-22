package com.linkcode.services;

import java.util.ArrayList;
import java.util.List;

import com.linkcode.model.Bike;
import com.linkcode.model.Customer;
import com.linkcode.model.Vehicle;

public class vehicleInventory {

	private List<Vehicle> Vehicles;
	private List<Customer> customers;
	
	public vehicleInventory() {
		Vehicles=new ArrayList();
		customers=new ArrayList<Customer>();		
		
	}
	public void addVehicle(Vehicle vehicle) {
		Vehicles.add(vehicle);
		
	}
	
	public boolean removeVehicle(String id) {
	        for (Vehicle v : Vehicles) {
	            if (v.getVehicleId().equalsIgnoreCase(id)) {
	                Vehicles.remove(v);
	                return true;
	            }
	        }
	        return false;
	    }
		
		
	
	
	public List<Vehicle> getAllVehicles() {
	    for(Vehicle v : Vehicles) {
	    }
		return Vehicles;
		
	}
	
	public void showAvailableVehicles(Class<?> type) {
		System.out.println("Available"+type.getSimpleName()+"s");
		
		for(Vehicle vehicle : Vehicles) {
			if(type.isInstance(vehicle)&&vehicle.isAvailable()) {
				System.out.println("------------------------------");
				System.out.println(type.getSimpleName()+"ID:"+vehicle.getVehicleId());
				System.out.println("Rental Rate:"+vehicle.getRentalRate());
				System.out.println("------------------------------");
			}
		}
	}
	
	public void addCustomers(Customer customer){
		customers.add(customer);
	}
	
	public List<Customer> getAllCustomers() {
		
		return this.customers;
	}
}
