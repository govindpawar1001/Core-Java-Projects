package com.linkcode.model;

import java.util.Scanner;

public class PaymentGateway {

	static Scanner sc=new Scanner(System.in);
	public static boolean processpayment(double bill) {
		//		System.out.println("Amount to pay:"+bill);

				System.out.println("Enter amount to pay:");
		
				int amount=sc.nextInt();
				System.out.println("Processing payment");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Payment Done :"+amount);
				if(bill<=amount) {
					if(bill==amount)
						System.out.println("Process Done");
					
					if(bill<amount)
						System.out.println("Paid Extra :"+(amount-bill));
					
					System.out.println("Vehicle Rented Succesfully");
					return true;
				}
				else if(bill>amount){
					System.out.println("Pending Amount :"+(bill-amount));
					System.out.println("Vehicle NOt Allocated");
					return false;
				}
				return false;
				
			}
		
		}



//		System.out.println("Amount to pay :"+bill);
//
//		System.out.println("Processing payment");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Payment Done :"+bill);
//		if(bill<=bill) {
//			if(bill==bill)
//				System.out.println("Process Done");
//
//			System.out.println("Vehicle Rented Succesfully");
//			return true;
//		}
//
//			return false;
//		
//
//	}
//
//}
