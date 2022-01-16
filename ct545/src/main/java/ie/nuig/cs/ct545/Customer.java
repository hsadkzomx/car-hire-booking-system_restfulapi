package ie.nuig.cs.ct545;

/**
 * this class represents the customer with their firstName, lastName and address
 * @author jiarongli
 *
 */

public class Customer {
	private String firstName = "";
	private String lastName = "";
	private String address = "";
	
	//constructor
	public Customer() {}
	
	public Customer(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	public boolean equals(Customer other) {
		return this.firstName.equals(other.firstName) &&
				this.lastName.equals(other.lastName) &&
				this.address.equals(other.address);
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return String.format("firstName = %s, lastName = %s, address = %s", 
				firstName, lastName, address);
	}
}
