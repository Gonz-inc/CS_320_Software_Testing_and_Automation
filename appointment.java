/*
 * Appointment class that contains an appointment ID, and appointment date field and 
 * appointment descriptions. All of these are methods. 
 * Institution: SNHU 
 * Class: CS-320 
 * Created by Gerardo Gonzalez. 
 * Date: 2023-27-7 5:54 AM EST
 * 5-1 Milestone: Appointment Service
 * */
//package appointmentService;
import java.util.*;
import java.Date;

public class appointment{
	
	private String aptID;
	private String aptDate;
	private String aptDescr;
	
	//Default Constructor. 
	public appointment() {
		
	}
	
	public String verAptID(String idInput) {
		if (idInput < 10 || idInput == null) {
			throw new IllegalArgumentException();
		} else {
			return idInput;
		}
	}

	public String veraptDate(){

	}


	

	//Completed: add appointment ID verifications. ??
	//FIXME: add appointment date and its verifications. 
	//FIXME: add appointment descriptions. 

	//FIXME: add setters and getters.
	//FIXME: add validations methods.
}
