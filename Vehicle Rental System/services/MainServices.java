package com.linkcode.services;

import java.util.List;
import java.util.Scanner;

import com.linkcode.model.Admin;
import com.linkcode.model.Bike;
import com.linkcode.model.Bus;
import com.linkcode.model.Car;
import com.linkcode.model.Customer;
import com.linkcode.model.Vehicle;

public class MainServices {


	private static Scanner sc = new Scanner(System.in);

	private static vehicleInventory inventory=new vehicleInventory();
	private static Customer customer;
	public static void main(String[] args) {

		intializeVehicles();		

		boolean flag=true;
		System.out.println("-----WELCOME TO VEHICLE RENTAL SYSTEM-----");
		while(flag) {
			showMenu();

			int ch=sc.nextInt();
			switch(ch) {
			case 1-> handleAdminLogin();
			case 2-> handleCustomerLogin();
			case 3-> flag=false;
			default->System.out.println("Invalid choice....");
			}

		}
		System.out.println("Thank you for visiting.......");


	}


	public static void intializeVehicles() {
		inventory.addVehicle(new Car("C001",1200,6));
		inventory.addVehicle(new Car("C002",1000,8));
		inventory.addVehicle(new Bus("BS01",5000,25));
		inventory.addVehicle(new Bus("BS02",1200,45));
		inventory.addVehicle(new Bike("B001",200,true));
		inventory.addVehicle(new Bike("B002",100,false));
	}

	public static void showMenu() {
		System.out.println("1.Admin\n2.Customer\n3.Exit");
		System.out.println("Enter your choice :");

	}


	public static void handleAdminLogin() {
		System.out.println("Enter username");
		String user=sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		if(Admin.authenticate(user, password)) {
			AdminMenu();
		}else {
			System.out.println("Incorrect username and password");
		}
	}

	public static void AdminMenu() {
		System.out.println("---------Options-----------");
		System.out.println("1.Add vehicle");
		System.out.println("2.Remove vehicle");
		System.out.println("3.Send vehicle for maintanace");
		System.out.println("4.Complete vehicle maintance");
		System.out.println("5.view customer details with rented vehicles");
		System.out.println("6.view all vehicle info");

		System.out.println("Enter your Choice :");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1->{System.out.println("1.Bike\n2.Car\n3.Bus");
			System.out.println("Enter your Choice");
			int ch=sc.nextInt();
			System.out.println("Enter Vehicle ID :");
			String id=sc.next();
			System.out.println("Enter Rental Rate :");
			double rate=sc.nextDouble();
		
				switch(ch) {
				case 1->{
					System.out.println("Helmet Available ? yes/no");
					String ha=sc.next();
					boolean b=ha.equalsIgnoreCase("yes");
					inventory.addVehicle(new Bike(id,rate,b));
					System.out.println("Vehicle Added Successfully");
				}
				case 2->{
	
					System.out.println("Enter number of Seats:");
					int seats = sc.nextInt();
		
					inventory.addVehicle(new Car(id, rate, seats));
					System.out.println("Car Added Successfully");
				}
				case 3->{
					System.out.println("Enter number of Seats:");
					int seats = sc.nextInt();
		
					inventory.addVehicle(new Bus(id, rate, seats));
					System.out.println("Bus Added Successfully");
				}

				}
			}
		case 2->{ 
			System.out.println("Enter Vehicle ID to remove");
			String id=sc.next();
			boolean remove=inventory.removeVehicle(id);
			if(remove) {
				System.out.println("Vehicle Remove Successfully");
			}else {
				System.out.println("Vehicle Not Available");
			}
		}
		case 3->{
			System.out.println("Enter a vehicle ID :");
			String vid=sc.next();
			Vehicle vehicle=getVehicleID(vid);
			if(vehicle!=null) {
				vehicle.sendforMaintance();
			}else {
				System.out.println("Vehicle Not available");
			}
			
			
			
		}
		case 4->{
			System.out.println("Enter a vehicle ID :");
			String vid=sc.next();
			Vehicle vehicle=getVehicleID(vid);
			if(vehicle.isUnderMaintance()) {
				vehicle.completeMaintance();
			}else {
				System.out.println("Vehicle Not under available");
			}
			
			
		}
		case 5->{
			for(Customer customer:inventory.getAllCustomers()) {
				System.out.println("Name :"+customer.getName());
				System.out.println("Mobile :"+customer.getMobileno());
				System.out.println("Licence :"+(customer.isIslicenseAvailable()?"YES":"NO"));
				System.out.print("Rented Vehicle IDs :");
				customer.getVehicles().forEach(val->System.out.println(" "+val.getVehicleId()));
			}
			
		}
		case 6->{
			for (Vehicle v : inventory.getAllVehicles()) {
				    System.out.println( "Vehicle ID :" + (v.getVehicleId())+"  Rate :"+v.getRentalRate()+"	Days :"+v.getRentalDays()+"	UnderMaintanace :"+(v.isUnderMaintance()?"Yes":"No")+"	Vehicle Availability: "+(v.isAvailable()?"Yes":"No"));
				
			}
		}
		
		default->System.out.println("Invalid Choice");
		
		}


	}

	public static  void handleCustomerLogin() {
		System.out.println("-------Registration Form------------");
		System.out.println("Enter your Name :");
		String name=sc.next();
		System.out.println("Enter your Mobile No :");
		long mobile=sc.nextLong();
		System.out.println("License Availale (yes/no)");
		String available=sc.next();
		boolean isl=available.equalsIgnoreCase("yes");
		customer=new Customer(name, mobile, isl);
		inventory.addCustomers(customer);
		if(customer!=null) {
			System.out.println("Registration Successfull...");
			customerMenu();
		}else {
			System.out.println("registration failed ......please try again");
		}

	}

	public static void customerMenu() {
		boolean flag=true;
		while(flag) {
			System.out.println("-------MENU--------");
			System.out.println("1.Show Available Bike");
			System.out.println("2.Show Available Cars");
			System.out.println("3.Show Available Buses");
			System.out.println("4.Rent vehicle");
			System.out.println("5.Return all rented vehicles ");
			System.out.println("6.view rented vehicles");
			System.out.println("7.Exit");
			System.out.println("------------------------------");


			int choice=sc.nextInt();
			switch(choice) {
			case 1->inventory.showAvailableVehicles(Bike.class);
			case 2->inventory.showAvailableVehicles(Car.class);
			case 3->inventory.showAvailableVehicles(Bus.class);
			case 4->{
				System.out.println("Enter Vehicle ID :");
				String id=sc.next();
				Vehicle vehicle=getVehicleID(id);
				System.out.println("Enter no of days");
				int days=sc.nextInt();
				if(vehicle!=null) {
					customer.rentVehicle(vehicle,days);
				}else{
					System.out.println("Vehicle Not Found");
				}
			}
			case 5->customer.returnAllvehicles();
			case 6->customer.viewRentalvehicle();

			case 7->flag=false;
			default->System.out.println("Invalid choice");

			}

		}
	}


	private static Vehicle getVehicleID(String id) {
		List<Vehicle> vehicles=inventory.getAllVehicles();
		for(Vehicle vehicle:vehicles) {
			if(vehicle.getVehicleId().equalsIgnoreCase(id)) {
				return vehicle;
			}
		}

		return null;
	}

}






