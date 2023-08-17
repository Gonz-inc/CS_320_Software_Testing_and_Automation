package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Appointment_Services.Appointment;

import java.util.*;
import java.util.Date;

class AppointmentTest {

	public String defaultID = "A123456789";
	public String defaultDecr = "UPDATE: The Appointment is schuled for - 10:00 AM";
	public Date defaultDate = new Date(2023 - 1900, 9, 16);
	
	//*****************Test for appointment variables at a size less then the specified requirement.
	@Test 
	void testAptIDSmallSizeTest() {
		
		//Size of the ID is less then 10 characters.
		String smallID = "A-1100";
		
		Appointment apt1 = new Appointment(smallID, defaultDate, defaultDecr);
		
		//Confirms that it is less then 10 characters long.
		assertTrue(apt1.getAptID().length() < 10);
		
		//No exceptions Thrown.
		Assertions.assertDoesNotThrow(() ->apt1);
	}
	
	@Test 
	void testAptPastDate(){
		//Here the date is in the past.
		@SuppressWarnings("deprecation")
		Date oldDate = new Date(2023 - 1900, 7, 12);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(defaultID, oldDate, defaultDecr);
		});
	}
	
	@Test
	void testAptSmallDescr() {
		String smallDescr = "Is tommorow";
		
		Appointment apt1 = new Appointment(defaultID, defaultDate, smallDescr);
		
		assertTrue(apt1.getAptDescr().length() < 50);
		
		Assertions.assertDoesNotThrow(() -> apt1);
	}
	
	
	//*************Test to make sure the size of regions is at max value acceptance.
	
	@Test
	void testValidAptID() {
		
		//Here the size of the apt ID is 10 characters Long.
		String aptIdValid = "A123456789";
		Appointment apt1 = new Appointment(aptIdValid, defaultDate, defaultDecr);
		
		//Validates that it is ten characters Long.
		assertEquals(10, apt1.getAptID().length());
		
		//Shows that no assertions were thrown.
		Assertions.assertDoesNotThrow(() -> apt1);
	}
	
	@Test
	void testValidAptDecr() {
		
		//Here is a valid Description with 50 characters long.
		String aptDecrValid = "UPDATE: The Appointment is schuled for - 10:00 AM.";
		Appointment apt1 = new Appointment(defaultID, defaultDate, aptDecrValid);
		
		//Validates that it is 50 characters long.
		assertEquals(50, apt1.getAptDescr().length());
		
		//shows that now assertions were thrown.
		Assertions.assertDoesNotThrow(() -> apt1);
	}
	
	@Test
	void ValidDateTest(){
		
		//Here is a valid date as of august 14
		//The Date class is used for legacy code. 
		Date tomorrow = new Date(2023 - 1900, 7, 14);
		Date currentDate = new Date();
		Appointment apt1 = new Appointment(defaultID, tomorrow, defaultDecr);
		
		//Validated that the tomorrows date is after current Date
		assertTrue(apt1.getAptDate().after(currentDate));
		
		//Shows that no assertions were thrown.
		Assertions.assertDoesNotThrow(() -> apt1);
		
	}
	
	//****************Test regions size when they are greater then specified.*************
	
	@Test
	void aptLargeIDTest() {
		
		//Here the size of the string is larger the 10 characters.
		String aptIDToLong = "A-230526fdfds";
		
		//Validates that an exceptions is thrown because its ID has exceeded 10 characters.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(aptIDToLong, defaultDate, defaultDecr);
		});

	}
	
	@Test 
	void aptLargeDecrTest() {
		
		//Here the description is to long and is past 50 characters.
		String aptDecrToLong = "Locator can be used. Please feel free to share the way you use this tool, and we always welcome suggestions on how we ";
		
		//Validates that that an exception is thrown because it exceeds 50 characters. 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(defaultID, defaultDate, aptDecrToLong);
		});
	}
	
	
	//*********************NULL INPUT TESTING**************************
	@Test
	void aptNullIDTest() {
		String aptIDNull = null;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(aptIDNull, defaultDate, defaultDecr);
		});

	}
	
	@Test 
	void aptNullDecrTest() {
		String aptDecrNull = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(defaultID, defaultDate, aptDecrNull);
		});
	}
	
	@Test 
	void aptNullDate() {
		Date nullDate = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(defaultID, nullDate, defaultDecr);
		});
	}
	
}