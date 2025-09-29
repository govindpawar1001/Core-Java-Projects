package com.linkcode.model;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailService {
	
	private final static String senderMail="govindpawar1001@gmail.com";
	private final static String senderPass="bhsf ojdg sowm vhye";
	
	static void sendBookingConformation(String name, int days, double rentalRate, double bill, String vehicleId, String email) {
		String subject="Vehicle Rental Confirrmation";
		String body="Hello "+name+", your vehicle booked successfully. \n Vehicle ID:"+vehicleId+"\n RentalRate :"+rentalRate+"\n No of Days:"+days+"\n Total Bill : "+bill;
		
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		
		 Session session=Session.getInstance(properties,new Authenticator() {
			 @Override
			 protected PasswordAuthentication getPasswordAuthentication() {

			 return new PasswordAuthentication(senderMail, senderPass);

			 }
			 });
		 
			 Message message =new MimeMessage(session);

			 try {

			 message.setFrom(new InternetAddress(senderMail));
			 message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			 message.setSubject(subject);
			 message.setText(body);
			 Transport.send(message);
			 System.out.println("mail sent to "+email+" .......");

			 } catch (MessagingException e) {
			 System.out.println("Some issues occured");
			 e.printStackTrace();
			 }
		
		System.out.println("Booking Mail send successfully");
		System.out.println("---------------------------------");
		
		
	}

}
