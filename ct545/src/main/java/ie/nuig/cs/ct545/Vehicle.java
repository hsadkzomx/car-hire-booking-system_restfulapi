package ie.nuig.cs.ct545;

/**
 * This class represents vehicle.
 * Vehicle details should include registration, manufacturer, and colour.
 * @author jiarongli
 *
 */

public class Vehicle {
	private String registration = "";
	private String manufacturer = "";
	private String colour = "";
	
	//construvtor
	public Vehicle() {}
	
	public Vehicle(String registration, String manufacturer, String colour) {
		this.registration = registration;
		this.manufacturer = manufacturer;
		this.colour = colour;
	}
	
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public String toString() {
		return String.format("registration = %s, manufacturer = %s, colour = %s", 
				registration, manufacturer, colour);
	}
	
	public boolean equals(Vehicle other) {
		return this.registration.equals(other.registration) &&
				this.manufacturer.equals(other.manufacturer) &&
				this.colour.equals(other.colour);
	}
	
}
