package Contact_Services;

public class Contact{
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;
	
	public Contact(String contactID, String firstName, String lastName, String phoneNum, String address) {
		verifyID(contactID);
		verifyFirstName(firstName);
		verifyLastName(lastName);
		verifyPhoneNumber(phoneNum);
		verifyAddress(address);
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.address = address;
		
	}
	//Verification Methods.
	public String verifyID(String contactID) {
		if (contactID == null || contactID.length() > 10 ) {
			throw new IllegalArgumentException("Invalid ID: ");
		}
		if (contactID.isEmpty() || contactID.isBlank()) {
			throw new IllegalArgumentException("ID can't be empty");
		}
		
		return contactID;
	}
	
	public String verifyFirstName(String firstName) {
		if ( firstName == null || firstName.length() > 10 ) {
			throw new IllegalArgumentException("Invalid Name");
		}
		if (firstName.isEmpty() || firstName.isBlank()) {
			throw new IllegalArgumentException("Name can't be empty");
		}
		return firstName;
	}
	
	public String verifyLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if (lastName.isEmpty() || lastName.isBlank()) {
			throw new IllegalArgumentException("Name can't be empty");
		}
		return lastName;
	}

	public String verifyPhoneNumber(String phoneNum) {
		if (phoneNum == null || phoneNum.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if (!phoneNum.matches("\\d+")) {
			throw new IllegalArgumentException("Number must contain only Numbers");
		}
		return null;
	}

	public String verifyAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		if (address.isEmpty() || address.isBlank()) {
			throw new IllegalArgumentException("Empty Address");
		}
		return address;
	}

	//Setters. 
	//Check to see that the updated variables are verified?
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public void setAddress (String address) {
		this.address = address;
	}

	//Getters
	public String getID() {
		return contactID;
	}
	
	public String getFirstName(){ 
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public String getAddress() {
		return address;
	}


}