package Appointment_Services;

import java.util.*;
import java.util.Date.*;

public class Appointment{
	
	private String aptID;
	private Date aptDate;
	private String aptDescr;
	
	//Default Constructor. 
	public Appointment(String aptID, Date aptDate, String aptDescr) {
		// calls verification methods for each corresponding parameter. 
		verAptID(aptID);
		verAptDate(aptDate);
		verAptDescr(aptDescr);
		
		this.aptID = aptID;
		this.aptDate = aptDate;
		this.aptDescr = aptDescr;
	}
	
	/*Getters*/
	public String getAptID() {
		return aptID;
	}
	
	public Date getAptDate() {
		return aptDate;
	}
	
	public String getAptDescr() {
		return aptDescr;
	}
	
	/*Verification methods for that is used in the default constructor.*/
	
	public String verAptID(String idInput) {
		if (idInput == null || idInput.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		} 
			return idInput;
	}

	public Date verAptDate(Date aptDate){
		if(aptDate == null || aptDate.before(new Date())){
			throw new IllegalArgumentException("Invalid Date");
		}
			return aptDate;
	}

	public String verAptDescr(String aptDescr) {
		if(aptDescr == null || aptDescr.length() > 50){
			throw new IllegalArgumentException("Invalid Discription");
		}
			return aptDescr;

	}

}
