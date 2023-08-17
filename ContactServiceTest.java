package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import Contact_Services.Contact;
import Contact_Services.ContactService;

class ContactServiceTest{
	 
	private ContactService service;
	private Contact defaultContact;
	
	@BeforeEach
	public void setUP() {
		String defaultID = "CT-1359870";
		String defaultFirstName = "Alexander";
		String defaultLastName = "Willison";
		String defaultPhoneNum = "9775629999";
		String defaultAddress = "1234 Newark St Tempa FL 512365";
		
		service = new ContactService();
		defaultContact = new Contact(defaultID, defaultFirstName, defaultLastName, defaultPhoneNum, defaultAddress);
	}
	
	@Test
	void addContactTest() {
		service.addContact(defaultContact);
		assertEquals(1, service.getList().size());
		
		//Check to make sure the data is correct.
		assertTrue(service.getList().get(0).getID().equals("CT-1359870"));
	}
	
	//Finds and tests to make user an ID is unique.
	@Test 
	void uniqueIDTest() {
		String newID = "CT-1359870";
		String newFirstName = "Alexander";
		String newLastName = "Willison";
		String newPhoneNum = "9775629999";
		String newAddress = "1234 Newark St Tempa FL 512365";
		Contact newContact = new Contact(newID, newFirstName, newLastName, newPhoneNum, newAddress);
		service.addContact(defaultContact);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {service.addContact(newContact);});
	}
	
	@Test 
	void findIDTest() {
		service.addContact(defaultContact);
		assertTrue(defaultContact.getID().equals(service.findContact("CT-1359870").getID()));
	}
	
	@Test
	void findIDNullTest() {
		service.addContact(defaultContact);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {service.findContact("CT-1359871");});
	}
	
	@Test 
	void deleteContactTest(){
		
		String newID = "CT-1345170";
		String newFirstName = "Sarah";
		String newLastName = "Gonzalez";
		String newPhoneNum = "2165891101";
		String newAddress = "2107 Viking Dr Orlando NY 1251";
		Contact newContact = new Contact(newID, newFirstName, newLastName, newPhoneNum, newAddress);
		service.addContact(defaultContact);
		service.addContact(newContact);
		service.deleteContact(defaultContact);
		assertTrue(service.getList().get(0).getID().equals("CT-1345170"));
	}
	
	@Test 
	void deleteNoneIDTest(){
		String newID = "CT-1345170";
		String newFirstName = "Sarah";
		String newLastName = "Gonzalez";
		String newPhoneNum = "2165891101";
		String newAddress = "2107 Viking Dr Orlando NY 1251";
		Contact newContact = new Contact(newID, newFirstName, newLastName, newPhoneNum, newAddress);
		service.addContact(defaultContact);
		service.addContact(newContact);
		service.deleteContact(defaultContact);
		//Assertions.assertThrows(IllegalArgumentException.class, ()-> {service.deleteContact(service.findContact("CT-1235170"));});
	}
	
	@Test
	void updateContactTest() {
		String newID = "CT-1345170";
		String newFirstName = "Sarah";
		String newLastName = "Gonzalez";
		String newPhoneNum = "2165891101";
		String newAddress = "2107 Viking Dr Orlando NY 1251";
		Contact newContact = new Contact(newID, newFirstName, newLastName, newPhoneNum, newAddress);
		service.addContact(defaultContact);
		service.addContact(newContact);
		service.updateContact(newContact, "Garry", "Wright", "9201235155", "123 notVoid Ln Detroit AZ 5511");
		assertTrue(service.getList().get(1).getID().equals("CT-1345170"));
		assertTrue(service.getList().get(1).getFirstName().equals("Garry"));
		assertTrue(service.getList().get(1).getLastName().equals("Wright"));
		assertTrue(service.getList().get(1).getPhoneNum().equals("9201235155"));
		assertTrue(service.getList().get(1).getAddress().equals("123 notVoid Ln Detroit AZ 5511"));
	}
}