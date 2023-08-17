package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import Contact_Services.Contact;

class ContactTest {
	
	public Contact contact;
	String contactID = "CT-1359870";
	String firstName = "Alexander";
	String lastName = "Willison";
	String phoneNum = "9775629999";
	String address = "1234 Newark St Tempa FL 512365";
	
	@Test 
	void contactGeneralTest() {
		contact = new Contact(contactID, firstName, lastName, phoneNum, address);
		assertTrue(contact.getID().equals("CT-1359870"));
		assertTrue(contact.getFirstName().equals("Alexander"));
		assertTrue(contact.getLastName().equals("Willison"));
		assertTrue(contact.getPhoneNum().equals("9775629999"));
		assertTrue(contact.getAddress().equals("1234 Newark St Tempa FL 512365"));
	}
	
	/****************HERE ARE TESTS TO CHECK IF CONTACT VARIABLES ARE THEN LESS SPECIFED LENGTH*************/
	
	//TESTS THE ID LENGTH THAT IS LESS THEN 10.
	@Test 
	void contactIDSmallSizeTest() {
		//Based on the Rubric this should pass as it doesn't exceed ten characters.
		//THIS IS NOT TEN CHARACTERS LONG
		String smallContactID = "CT-1";
		contact = new Contact(smallContactID, firstName, lastName, phoneNum, address);
		
		//HERE IT SHOWS THAT THE LENGHT IS LESS THEN 10 CHARACTERS LONG.
		assertTrue(contact.getID().length() < 10);
		
		//Checks to make that the no EXCEPTIONS was thrown.
		Assertions.assertDoesNotThrow(() -> {
			new Contact(smallContactID, firstName, lastName, phoneNum, address);} );
	}
	
	// THIS TESTS THE FIRST NAME LENGTH THAT VERIFES THE OUTCOME IF IT IS LESS THEN 10 CHARACTERS LONG.
	@Test
	void contactFirstNameSmallSizeTest() {
		
		//THIS IS NOT TEN CHARACTERS LONG
		String smallFirstName = "Alex";
		contact = new Contact(contactID, smallFirstName, lastName, phoneNum, address);
		
		//HERE IT SHOWS THAT THE FIRST NAME IS LESS THEN 10 CHARACTERS LONG. 
		assertTrue(contact.getFirstName().length() <10);
		
		//Verifies that no EXCEPTIONS was thrown.
		Assertions.assertDoesNotThrow(() -> {
			new Contact(contactID, smallFirstName, lastName, phoneNum, address);
		});
		
	}
	

	// THIS TESTS THE LAST NAME LENGTH THAT VERIFES THE OUTCOME IF IT IS LESS THEN 10 CHARACTERS LONG.
	@Test
	void contactLastNameSmallSizeTest() {
		
		//THIS IS NOT TEN CHARACTERS LONG
		String smallLastName = "Will";
		contact = new Contact(contactID, firstName, smallLastName, phoneNum, address);
		
		//HERE IT SHOWS THAT THE FIRST NAME IS LESS THEN 10 CHARACTERS LONG. 
		assertTrue(contact.getFirstName().length() <10);
		
		//Verifies that no EXCEPTIONS was thrown.
		Assertions.assertDoesNotThrow(() -> {
			new Contact(contactID, firstName, smallLastName, phoneNum, address);
		});
		
	}
	

	//THIS TEST THAT THE NUMBER IS NOT EQUAL TO 10 CHARACATERS LONG.
	@Test 
	void contactNumberSmallSizeTest() {
		//HERE THE PHONE NUMBER IS LESS THEN TEN.
		String smallNumber = "8455264";
		
		//SINCE ITS LESS THEN THEN AND NOT EQUAL TO TEN AN ARGUMENT EXCEPTION IS THROWN.
		Assertions.assertThrows(IllegalArgumentException.class,() ->{		
			new Contact(contactID, firstName,lastName,smallNumber, address);});
	}
	
	
	//THIS TESTS THE ADDRESS 
	@Test
	void contactAddressSmallSizeTest() {
		
		//THIS IS NOT TEN CHARACTERS LONG
		String smallAddress = "1234 Newark";
		contact = new Contact(contactID, firstName, lastName, phoneNum, smallAddress);
		
		//HERE IT SHOWS THAT THE ADDRESS IS LESS THEN 30 CHARACTERS LONG.
		assertTrue(contact.getAddress().length() < 30);
		
		//AND HERE IT SHOWS THAT THE NO EXCEPTIONS WERE THROWN.
		Assertions.assertDoesNotThrow(() -> {
			new Contact(contactID, firstName, lastName,phoneNum,smallAddress);
		});
	}
	
	
	/****************HERE ARE TESTS TO CHECK IF CONTACT VARIABLES ARE IN THE SPECIFED LENGTH*************/
	
	@Test
	
	//HERE A VALID CONTACT ID WITH THE SPECIFIED LENTH IS TESTED.
	void validContactIDSizeTest() {
		
		//THIS IS NOT TEN CHARACTERS LONG
		String validContactID = "CT-1359870";
		contact = new Contact (validContactID,firstName, lastName, phoneNum, address);
		
		//Verifies that its is equal to ten characters long.
		assertEquals(10, contact.getID().length());
		
		//Validates that no exceptions are thrown.
		Assertions.assertDoesNotThrow(() -> {
			new Contact(validContactID, firstName, lastName, phoneNum, address);});
		
	}
	
	@Test
	// Here a valid first name is tested with the specified length test.
	void validFirstNameSizeTest() {
		
		//THIS IS TEN CHARACTERS LONG
		String validFirstName = "Alexsander";
		contact = new Contact(contactID, validFirstName, lastName, phoneNum, address);
		
		//verifies that it is equal to ten characters long.
		assertEquals(10, contact.getFirstName().length());
		
		//Confirms no exception are thrown.
		Assertions.assertDoesNotThrow(() -> {
			new Contact(contactID, validFirstName, lastName,phoneNum, address);
		});
	}
	
	@Test
	// Here a valid last name is tested with the specified length test.
	void validLastNameSizeTest() {
		//THIS IS TEN CHARACTERS LONG
		String validLastName = "Willissone";
		contact = new Contact(contactID, firstName, validLastName, phoneNum, address);
		
		//verifies that it is equal to ten characters long.
		assertEquals(10, contact.getLastName().length());
		
		//Confirms no exception are thrown.
		Assertions.assertDoesNotThrow(() -> {
			new Contact(contactID, firstName, validLastName,phoneNum, address);
		});
	}
	
	@Test 
	// Here a test is created to verify that the phone number is equal to ten characters.
	void validPhoneNumSizeTest() {
		//THIS IS TEN CHARACTERS LONG
		String validPhoneNum = "9775629999";
		contact = new Contact(contactID, firstName, lastName, validPhoneNum, address);
		
		//size test
		assertEquals(contact.getPhoneNum().length(), 10);
		
		//Not exceptions are thrown during test.
		Assertions.assertDoesNotThrow(() -> {
			new Contact(contactID, firstName, lastName, validPhoneNum, address);
		});
	}
	
	@Test
	//Here a test is created to check the size of charters in a java String.
	//Note that using the length is neccasary to get the size because the rubric calls for all variables to 
	//BE STRING FIELDS, AND STRING FIELDS DO NOT HAVE SIZE() METHODS.
	void contactValidAddressSizeTest() {
		String validAddress = "1234 Newark St Tempa FL 512365";
		contact = new Contact(contactID, firstName, lastName, phoneNum, validAddress);
		
		//SIZE TEST 30 CHARACTERS.
		assertEquals(contact.getAddress().length(), 30);
		
		//No exceptions are thrown during test.
		Assertions.assertDoesNotThrow(() -> {
			new Contact(contactID, firstName, lastName, phoneNum, validAddress);
		});
	}
	
	
	
	/*******HERE ARE TESTS TO CHECK IF CONTACT VARIABLES ARE GREATER THEN THE SPECIFED LENGTH***********/
	
	
	@Test
	//Here we test the size of the contact ID is larger then 10 charters.
	void contactIDBigSizeTest() {
		//This size is more then 10 characters.
		String largeContactID = "CT_13598701";
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact (largeContactID, firstName, lastName, phoneNum, address);
			});
	}
	
	@Test
	//Here the tests a first name that is greater then 10 charters long. 
	void firstNameLargeSizeTest() {
		//NOTE that the size of this String is to large more then 10 charters.
		String largeFirstName = "Alexsanderr";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact (contactID, largeFirstName, lastName, phoneNum, address);
			});
	}
	
	@Test
	//This  test tests the last name where the size of the last name is to past 10 characters.
	void lastNameLargeSizeTest() {
		
		// Size of string is to large.
		String largeLastName = "Willissonee";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact (contactID, firstName, largeLastName, phoneNum, address);
			});
	}
	
	@Test
	//TEST CHECK THE SIZE OF THE PHONE NUMBER GREATER THEN 10.
	void phoneNumlargePhoneNumTest() {
		
		//HERE THE INPUT OF THE PHONE NUMBER IS TO LARGE.
		String phoneNumToLong = "19775629999";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact (contactID, firstName, lastName, phoneNumToLong, address);
			});
	}
	
	@Test
	//HERE THE TEST OF AN ADDRESS THAT IS GREATER THEN 30 CHARACTERS.
	void largeAddressTest() {
		
		//TO large of an address.
		String addressToLong = "1234 Newark St Tempa FL P.O 512365";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact (contactID, firstName, lastName, phoneNum, addressToLong);
			});
		
	}
	

	//************PHONE NUMBER***********
	//THIS TEST THAT THE NUMBER IS ONLY NUMBERS OTHERWISE IT THROWS AND EXCPETIONS.
	@Test
	void notaPhoneNumberTest() {
		
		//HERE IT SHOWS THAT THE NUMBER CONTAINTS A LETTER AND IT SHOULD THROW AN EXCEPTTION.
		String invalidPhoneNum = "97756e9999";
		
		//VERIFIES THAT AN EXCEPTION IS THROWN.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact (contactID, firstName, lastName, invalidPhoneNum, address);
		});
		
	}
	
	@Test
	void nullContactTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact (null, firstName, lastName, phoneNum, address);
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact (contactID, null, lastName, phoneNum, address);
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact (contactID, firstName, null, phoneNum, address);
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact (contactID, firstName, lastName, null, address);
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact (contactID, firstName, lastName, phoneNum, null);
			});
		}
	
	@Test
	void emptyContactTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact ("", firstName, lastName, phoneNum, address);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact (contactID, "", lastName, phoneNum, address);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact (contactID, firstName, "", phoneNum, address);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact (contactID, firstName, lastName, "", address);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact (contactID, firstName, lastName, phoneNum, "");});
		}
	
	@Test
	void blankContactTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact (" ", firstName, lastName, phoneNum, address);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact (contactID, " ", lastName, phoneNum, address);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact (contactID, firstName, " ", phoneNum, address);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact (contactID, firstName, lastName, " ", address);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact (contactID, firstName, lastName, phoneNum, " ");});
		}

	@Test
	void setContactTest() {		
		String newFirstName = "Larry";
		String newLastName = "Agustu";
		String newPhoneNum = "9504568879";
		String newAddress = "2154 FalseStreet DR Orlando FL 123555";
	
		contact = new Contact(contactID, firstName, lastName, phoneNum, address);
		contact.setFirstName(newFirstName);
		contact.setLastName(newLastName);
		contact.setPhoneNum(newPhoneNum);
		contact.setAddress(newAddress);
		
		assertTrue(contact.getID().equals("CT-1359870"));
		assertTrue(contact.getFirstName().equals("Larry"));
		assertTrue(contact.getLastName().equals("Agustu"));
		assertTrue(contact.getPhoneNum().equals("9504568879"));
		assertTrue(contact.getAddress().equals("2154 FalseStreet DR Orlando FL 123555"));
	}
	
}