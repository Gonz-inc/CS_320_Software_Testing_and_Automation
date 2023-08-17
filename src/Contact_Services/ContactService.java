package Contact_Services;

import java.util.*;

public class ContactService {
	
	// 
	private ArrayList<Contact> contactList = new ArrayList<>();
	
	//Default Constructor. 
	public ContactService() {
	}
	 
	// Return the List.
	public List<Contact> getList() {
		return Collections.unmodifiableList(contactList);
	}
	 
	//Checks to see if the Contact is unique.
	public boolean verUniqueID(String contactID) {
		boolean notUniqueID= false;
		for(Contact currContact: contactList) {
			if (currContact.getID().equals(contactID)) {
				notUniqueID = true;
			}
		}
		if (notUniqueID == true) {
			throw new IllegalArgumentException("ID already exists");
		}
		else {
			notUniqueID = false;
		}
		return notUniqueID;
	}
	
	//Add method.
	public void addContact(Contact newContact) {
		if (verUniqueID(newContact.getID()) == true) {
			throw new IllegalArgumentException("ID already exits.");
		}
		else {
			contactList.add(newContact);
		}
	}

	
	//Method to search for the contact id if not found return null.
	public Contact findContact(String contactID) throws IllegalArgumentException {
		for (Contact contactAt: contactList) {
			if(contactAt.getID().equals(contactID)) {
				return contactAt;
			}
		}
		throw new IllegalArgumentException("Contact not Found");
	}
	
	//Delete method that uses the find contact method.
	public void deleteContact(Contact contact) {
		if (findContact(contact.getID()) != null) {
			contactList.remove(contact);
		}
	}
	
	public void updateContact(Contact contact, String updatedFirst, String updatedLast, String updatedPhoneNum, String updatedAddress) {
		if (findContact(contact.getID()) != null) {
			contact.setFirstName(updatedFirst);
			contact.setLastName(updatedLast);
			contact.setPhoneNum(updatedPhoneNum);
			contact.setAddress(updatedAddress);
		}
		else {
			throw new IllegalArgumentException("ID not found.");
		}
	}
}