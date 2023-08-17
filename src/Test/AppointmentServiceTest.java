package Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Appointment_Services.Appointment;
import Appointment_Services.AppointmentService;

class AppointmentServiceTest {
	
	// Declaring an appointment service class called aptServ.
	private AppointmentService aptServ;
	
	@BeforeEach
	// This is used to create and allocate the aptServ class object in memory for each test. 
	// Reasoning for this it to call this once in the code vs creating and initialize an 
	// appointment class object at every tests. Demonstrates the D.R.Y code practice.
	public void preTestSetUp() {
		aptServ = new AppointmentService();
	}
	
	
	//checks to see if the array list has items inside the list
	@Test 
	public void testAppointmentService() {
		String aptID = "A-250256";
		Date dateSet = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateSet);
		int amountOfDays = 3;
		cal.add(Calendar.DAY_OF_MONTH, amountOfDays);
		Date aptDate = cal.getTime();
		String aptDescr = "TEST Description: New client appointment added.";
		Appointment aptOne = new Appointment(aptID,aptDate,aptDescr);
		
		aptServ.addApt(aptOne);
		assertEquals(1,aptServ.getApt().size());
		assertEquals(aptOne, aptServ.getApt().get(0));
	}
	
	@Test 
	public void testAptDuplicate() {
		String aptID = "A-250256";
		Date dateSet = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateSet);
		int amountOfDays = 3;
		cal.add(Calendar.DAY_OF_MONTH, amountOfDays);
		Date aptDate = cal.getTime();
		String aptDescr = "TEST Description: New client appointment added.";
		Appointment aptOne = new Appointment(aptID,aptDate,aptDescr);
		Appointment aptTwo = new Appointment(aptID,aptDate,aptDescr);
		
		aptServ.addApt(aptOne);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {aptServ.addApt(aptTwo);});
		
	}
	
	@Test 
	public void testAptNull() {
		String aptID = "A-250256";
		Date dateSet = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateSet);
		int amountOfDays = 3;
		cal.add(Calendar.DAY_OF_MONTH, amountOfDays);
		Date aptDate = cal.getTime();
		String aptDescr = "TEST Description: New client appointment added.";
		Appointment aptOne = new Appointment(aptID,aptDate,aptDescr);
		Appointment aptTwo = new Appointment(aptID,aptDate,aptDescr);
		
		aptServ.addApt(aptOne);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {aptServ.addApt(aptOne);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {aptServ.addApt(aptTwo);});
	}
	@Test
	public void testAptServDelete() {
		String aptID = "A-250256";
		Date dateSet = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateSet);
		int amountOfDays = 3;
		cal.add(Calendar.DAY_OF_MONTH, amountOfDays);
		Date aptDate = cal.getTime();
		String aptDescr = "TEST Description: New client appointment added.";
		Appointment aptOne = new Appointment(aptID,aptDate,aptDescr);
		aptServ.addApt(aptOne);
		
		String aptID2 = "A-250244";
		Date dateSet2 = new Date();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(dateSet2);
		int amountOfDays2 = 4;
		cal2.add(Calendar.DAY_OF_MONTH, amountOfDays2);
		Date aptDate2 = cal.getTime();
		String aptDescr2 = "TEST Description: Clients Second appointment.";
		Appointment aptTwo = new Appointment(aptID2,aptDate2,aptDescr2);
		aptServ.addApt(aptTwo);
		
		aptServ.deleteApt(aptOne);
		assertEquals(1,aptServ.getApt().size());
		assertEquals(aptTwo, aptServ.getApt().get(0));
	}
	
	
	@Test
	public void testAptServDeleteNone() {
		String aptID = "";
		Date dateSet = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateSet);
		int amountOfDays = 3;
		cal.add(Calendar.DAY_OF_MONTH, amountOfDays);
		Date aptDate = cal.getTime();
		String aptDescr = "TEST Description: New client appointment added.";
		Appointment aptOne = new Appointment(aptID,aptDate,aptDescr);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {aptServ.deleteApt(aptOne);});
	}
	
	/*
	 *Based on the Feed back I have added this test the boundaries.  
	 *NOTE: this is the bad boundaries.
	 */
	@Test 
	public void boundesTest() {
		String toLongID = "apt121212321231321";
		//PAST Date.
		@SuppressWarnings("deprecation")
		Date datePastToday = new Date(2023 - 1900, 8,5);
		//Discription is 51 characters Long.
		String toLongDiscr = "Schedule your appointment today! Don't miss it";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(toLongID,datePastToday,toLongDiscr);
		});
	}
	
	/*
	 *Note This is good Boundaries.  
	 */
	@Test
	public void testGoodApt() {
		@SuppressWarnings("deprecation")
		Date dateGood = new Date (2023 - 1900, 8,15);
		String goodDiscr = "Appointment is on the 15";
		Appointment newApt = new Appointment("Apt051", dateGood,goodDiscr);
		AppointmentService checkApt = new AppointmentService();
		checkApt.addApt(newApt);
		Assertions.assertEquals(1,checkApt.getApt().size());
		Assertions.assertTrue(checkApt.getApt().contains(newApt));
	}
}
