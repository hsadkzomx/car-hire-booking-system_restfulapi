package ie.nuig.cs.ct545;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class represents the booking
 * Booking details should include id, customer, vehicle, startDate and endDate
 * @author jiarongli
 *
 */

public class Booking {
	private static AtomicInteger at = new AtomicInteger(0);
	
	public int id;
	private Customer customer;
	private Vehicle vehicle;
	private String startDate = "";
	private String endDate = "";
	
	//constructor
	public Booking() {}

	public Booking(Customer customer, Vehicle vehicle, String startDate, String endDate) {
		this.id = at.incrementAndGet();
		this.customer = customer;
		this.vehicle = vehicle;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public boolean equals(Booking other) {
		return this.customer.equals(other.customer) &&
				this.vehicle.equals(other.vehicle) &&
				this.startDate.equals(other.startDate) &&
				this.endDate.equals(other.endDate);
	}
	
	
	public void print() {
		System.out.printf("id = %d\n", id);
		System.out.printf("customer = %s\n", customer.toString());
		System.out.printf("vehicle = %s\n", vehicle.toString());
		System.out.printf("startDate = %s\n", startDate);
		System.out.printf("endDate = %s\n", endDate);

	}
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	 @Override
	 public String toString() {
	    return "booking [id=" + id + ", customer=" + customer.getFirstName() + 
	    		" " + customer.getLastName() + " address: " + customer.getAddress() + 
	    		" vehicle= " + vehicle.getRegistration() + " " + vehicle.getManufacturer() + 
	    		" " +vehicle.getColour() +
	    		"]";
	 } 
	
}
