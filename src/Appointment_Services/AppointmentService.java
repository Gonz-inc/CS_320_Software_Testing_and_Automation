package Appointment_Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppointmentService{
	private ArrayList<Appointment> aptList = new ArrayList<>();
	
	public Appointment findApt(String aptID) {
		// For each loop. 
		for (Appointment apt : aptList ) {
			//find the appointment id in array list
			if (apt.getAptID().equals(aptID)) {
				// returns the id. Note if at this point if it returns it will terminate the loop 
				// and the outer return will not execute. 
				return apt; 
			}
		}
		return null; // if the id is not found then the null is return for this method
	}
	
	
	/*
	 * ****************Unique ID check ***************** 
	 */
	public boolean verUniqueID(String aptID) {
		boolean notUniqueID = false;
		for (Appointment apt: aptList) {
			if (apt.getAptID().equals(aptID)) {
				notUniqueID = true;
			}
		}
		if (notUniqueID == true) {
			throw new IllegalArgumentException("ID already Taken");
		}
		else {
			notUniqueID = false;
		}
		return notUniqueID;
	}
	
	// returns the ArrayList named aptList and all its contents.
	public List<Appointment> getApt() {
		return Collections.unmodifiableList(aptList);
	}
	
	// add method. 
	public void addApt(Appointment newApt) {
		if (verUniqueID(newApt.getAptID()) == true) {
			throw new IllegalArgumentException("appoinment can not be empty.");
		}
		if (findApt(newApt.getAptID()) != null) {
			throw new IllegalArgumentException("ID already exists.");
		}
		aptList.add(newApt);
	}
	
	//Delete Method. 
	public void deleteApt(Appointment oldApt) {
		if(findApt(oldApt.getAptID()) != null) {
			aptList.remove(oldApt);
		}
		else {
			throw new IllegalArgumentException("ID not found.");
		}
	}
}