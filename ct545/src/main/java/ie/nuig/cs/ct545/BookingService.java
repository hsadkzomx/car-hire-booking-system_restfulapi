package ie.nuig.cs.ct545;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.core.Response.Status;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "bookingservice" path)
 */
@jakarta.ws.rs.Path("/bookingservice")
@Singleton
public class BookingService {
	
	Bookings list;
	
	//String firstName, String lastName, String address
	Customer customer1 = new Customer("Tom", "Smith", "Galway");
	Customer customer2 = new Customer("Jane", "Doe", "Clare");
	
	//String registration, String manufacturer, String colour
	Vehicle vehicle1 = new Vehicle("191-G-12345", "Mercedes", "White");
	Vehicle vehicle2 = new Vehicle("201-G-54321", "Ferrari", "Yellow");
	
	public BookingService() {
		list = new Bookings();
		
		list.setList(new ArrayList<Booking>());
		
		//int id, Customer customer, Vehicle vehicle
		list.getList().add(new Booking(customer1, vehicle1,"2020/03/18", "2020/03/20"));
		list.getList().add(new Booking(customer2, vehicle2, "2020/03/19", "2020/03/27"));
	}
	
	
	/**
	 * When a GET request is received at the URL http://localhost:8080/ct545rest/webapi/bookingservice
	 * @return the list of details of all bookings in the system in JSON format
	 */
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Bookings getAllbookings() 
    {   
        return list;
    } 
	

    @Produces(MediaType.TEXT_HTML)
    @GET
    @Path("viewallweb")
    public Response viewAllWeb() 
    {   
    	String html = "";
    	
    	html += "<html>";
    	html += "<head>";
    	html += "<style>";
    	
    	html += "table, th, td { border: 1px solid black; border-collapse: collapse;}";
    	html += "th, td { padding: 5px;}";
    	html += "th { text-align: left;}";
    	
    	html += "</style>";
    	html += "</head>";
    	html += "<body>";
    	
    	html += "<h2>ACME Car Hire Booking System</h2>";
    	html += "<h3>View All Bookings</h3>";
    	
    	
    	html += "<table>";
    	
    	html += "<tr>";
    	
    	html += "<th>Booking id</th>";
    	html += "<th>Booking Start Date</th>";
    	html += "<th>Booking End Date</th>";
    	html += "<th>Customer First Name</th>";
    	html += "<th>Customer Last Name</th>";
    	html += "<th>Customer Address</th>";
    	html += "<th>Vehicle Registration</th>";
    	html += "<th>Vehicle Manufacturer</th>";
    	html += "<th>Vehicle Colours</th>";
    	
    	html += "</tr>";
    	
    	for (int i = 0; i < list.getList().size(); i++){  
    		html += "<tr>";
    		
    		html += "<td>" + list.getList().get(i).id + "</td>";
			html += "<td>" + list.getList().get(i).getStartDate() + "</td>";
			html += "<td>" + list.getList().get(i).getEndDate() + "</td>";
			html += "<td>" + list.getList().get(i).getCustomer().getFirstName() + "</td>";
			html += "<td>" + list.getList().get(i).getCustomer().getLastName() + "</td>";
			html += "<td>" + list.getList().get(i).getCustomer().getAddress() + "</td>";
			html += "<td>" + list.getList().get(i).getVehicle().getRegistration() + "</td>";
			html += "<td>" + list.getList().get(i).getVehicle().getManufacturer() + "</td>";
			html += "<td>" + list.getList().get(i).getVehicle().getColour() + "</td>";
			
    		html += "</tr>";
    	}
    	
    	html += "</table>";
    	
    	html += "<br>" + "<a href= \"../../index.jsp\">Back to main menu</a>";
    	html += "</body>";
    	html += "</html>";
    	
        return Response.ok(html).build();
   } 
    
    
	/**
	 * When a GET request is received at the URL http://localhost:8080/ct545rest/webapi/bookingservice/{id} 
	 * @param id
	 * @return details of the booking with the specified id in JSON format.
	 */
	
    @Produces(MediaType.TEXT_HTML)
    @GET
    @Path("/getbookingweb")
    public Response getBookingWeb(@QueryParam("id") int id) 
    {   
    	
    	String html = "";
    	
    	Booking found = null;
    	
    	
		System.out.printf("getBooking id= %d\n", id);
        for(Booking e : list.getList()) {
            if(e.id == id) {
            	found = e;
            	break;
            }   
        }    
        
        if(found == null) {
            return Response.status(Status.NOT_FOUND).build();

        }
        
        html += "<html>";
        html += "<head>";
    	html += "<style>";
    	
    	html += "table, th, td { border: 1px solid black; border-collapse: collapse;}";
    	html += "th, td { padding: 5px;}";
    	html += "th { text-align: left;}";
    	
    	html += "</style>";
    	html += "</head>";        
        
    	html += "<body>";
    	html += "<h2>View the single booking</h2>";
    	
    	html += "<table>";
    	
    	html += "<tr>";
    	
    	html += "<th>Booking id</th>";
    	html += "<th>Booking Start Date</th>";
    	html += "<th>Booking End Date</th>";
    	html += "<th>Customer First Name</th>";
    	html += "<th>Customer Last Name</th>";
    	html += "<th>Customer Address</th>";
    	html += "<th>Vehicle Registration</th>";
    	html += "<th>Vehicle Manufacturer</th>";
    	html += "<th>Vehicle Colours</th>";
    	
    	html += "</tr>";
    	
    	  
    		html += "<tr>";
    		
    		int i = id - 1;
    		
    		//System.out.println(i);
    		
    		html += "<td>" + list.getList().get(i).id + "</td>";
			html += "<td>" + list.getList().get(i).getStartDate() + "</td>";
			html += "<td>" + list.getList().get(i).getEndDate() + "</td>";
			html += "<td>" + list.getList().get(i).getCustomer().getFirstName() + "</td>";
			html += "<td>" + list.getList().get(i).getCustomer().getLastName() + "</td>";
			html += "<td>" + list.getList().get(i).getCustomer().getAddress() + "</td>";
			html += "<td>" + list.getList().get(i).getVehicle().getRegistration() + "</td>";
			html += "<td>" + list.getList().get(i).getVehicle().getManufacturer() + "</td>";
			html += "<td>" + list.getList().get(i).getVehicle().getColour() + "</td>";
			
    		html += "</tr>";
    	
    	
    	html += "</table>";
    	
    	html += "<br>" + "<a href= \"../../index.jsp\">Back to main menu</a>";
    	
    	html += "</body>";
    	html += "</html>";
    	
        
        return Response.ok(html).build();
    }   
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getBookingJson(@PathParam("id") int id) 
	{   
		System.out.printf("getBookingJson id= %d\n", id);
	    for(Booking e : list.getList()) {
	        if(e.id == id) {
	            return Response.ok(e).build();
	        }   
	    }    
	        return Response.status(Status.NOT_FOUND).build();
	    }   
		
	
	@POST
    @Path("createbookingweb")
    public Response addBookingWeb(@FormParam("firstName") String firstName, 
    		@FormParam("lastName") String lastName,
    		@FormParam("address") String address,
    		@FormParam("registration") String registration,
    		@FormParam("manufacturer") String manufacturer,
    		@FormParam("colour") String colour,
    		@FormParam("startDate") String startDate,
    		@FormParam("endDate") String endDate
    		) 
    {      
		System.out.println("addBookingweb entered ...");
		
		Customer customer = new Customer(firstName, lastName, address);
		Vehicle vehicle = new Vehicle(registration, manufacturer, colour);
		Booking booking = new Booking(customer, vehicle, startDate, endDate);
		booking.print();
		
		String html = "";
		html += "<br>" + "<a href= \"../../index.jsp\">Back to main menu</a>";
		
		Booking b = null;
		
		for(int i = 0; i< list.getList().size(); i++) {
			System.out.println("to see if the ctreated booking exist..");
			b = list.getList().get(i);
			
			if(b.equals(booking)) 
			{
				
				System.out.println("an item already exist, return status FORBIDDEN ...");
				
				b.print();
				
				return Response.status(Status.FORBIDDEN).build();

			}
		}		
		addBookingJson(booking);

		return Response.ok("added new booking" + html).status(201).build();

		
   }
	
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Booking addBookingJson(Booking e)  
    {   
		e.print();
		list.getList().add(e);
		return e;
    }
	
	@GET
	@Path("deletebookingweb")
	public Response deleteBookingWeb(@QueryParam("id") int id)
	{
		System.out.println("deletebookingweb entered ...");
		String html = "";
		html += "<html>";
    	
    	html += "<body>";
        html += "<br><br><a href= \"../../index.jsp\">Back to main menu</a>";
     	     	
     	html += "</body>";
     	html += "</html>";
		
    	Booking found = null;
    	
    	
		System.out.printf("deletetBooking id= %d\n", id);
        for(Booking e : list.getList()) {
            if(e.id == id) {
            	found = e;
            	list.getList().remove(found);
            	break;
            }   
        }    
        
        if(found == null) {
            return Response.status(Status.NOT_FOUND).build();
            
        }              
       
        return Response.ok("deleted successfully" + html).status(201).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")	
	public Response deleteBookingJson(@PathParam("id") int id)
	{   
		Booking found = null;
		for(Booking e : list.getList()) {
            if(e.id == id) {
            	found = e;
            	list.getList().remove(found);
            	break;
            }   
        }    
	    return Response.ok(found).build();		
	}
	
	@Produces(MediaType.TEXT_HTML)
    @GET
    @Path("preupdatebookingweb")
    public Response updateBookingWeb(@QueryParam("id") int id) 
    {   
    	
    	String html = "";
    	
    	Booking found = null;
    	
    	
		System.out.printf("getBooking id= %d\n", id);
        for(Booking e : list.getList()) {
            if(e.id == id) {
            	found = e;
            	break;
            }   
        }    
        
        if(found == null) {
            return Response.status(Status.NOT_FOUND).build();

        }
        
        html += "<html>";
    	
    	html += "<body>";
    	html += "<h2>ACME Car Hire Booking System</h2>";
    	html += "<h3>Update an existing booking</h3>";
    	
    	html += "<form action=\"postupdatebookingweb\" method=\"POST\">";
    	
    	html += String.format("<input type=\"hidden\" name=\"id\" value=\"%d\">", found.id);
        //html += "<br>";
        
    	
    	html += "Please update the booking details below: ";
        html += "<br><br>";
        html += "Customer First Name";
        html += String.format("<input type=\"text\" name=\"firstName\" value=\"%s\">", found.getCustomer().getFirstName());
        html += "<br>";
        html += "Customer Last Name";
        html += String.format("<input type=\"text\" name=\"lastName\" value=\"%s\">", found.getCustomer().getLastName()); 
        html += "<br>";
        html += "Customer Address";
        html += String.format("<input type=\"text\" name=\"address\" value=\"%s\">", found.getCustomer().getAddress());
        html += "<br>";
        html += "<br>";
        html += "Vehicle Registration";
        html += String.format("<input type=\"text\" name=\"registration\" value=\"%s\">", found.getVehicle().getRegistration()); 
        html += "<br>";
        html += "Vehicle Manufacturer";
        html += String.format("<input type=\"text\" name=\"manufacturer\" value=\"%s\">", found.getVehicle().getManufacturer()); 
        html += "<br>";
        html += "Vehicle Colour";
        html += String.format("<input type=\"text\" name=\"colour\" value=\"%s\">", found.getVehicle().getColour()); 
        html += "<br>";
        html += "<br>";
        html += "Booking Start Date";
        html += String.format("<input type=\"text\" name=\"startDate\" value=\"%s\">", found.getStartDate()); 
        html += "<br>";
        html += "Booking End Date";
        html += String.format("<input type=\"text\" name=\"endDate\" value=\"%s\">", found.getEndDate());
        html += "<br>";
        html += "<input type=\"submit\" value=\"Submit\">";
        html += "<br>";
        html += "<a href= \"../../index.jsp\">Back to main menu</a>";

        html += "</form>";
    	
    	
    	
    	html += "</body>";
    	html += "</html>";
    	
        
        return Response.ok(html).build();
    } 
	
	
	@POST
    @Path("postupdatebookingweb")
    public Response postUpdateBookingWeb(@FormParam("firstName") String firstName, 
    		@FormParam("lastName") String lastName,
    		@FormParam("id") int id,

    		@FormParam("address") String address,
    		@FormParam("registration") String registration,
    		@FormParam("manufacturer") String manufacturer,
    		@FormParam("colour") String colour,
    		@FormParam("startDate") String startDate,
    		@FormParam("endDate") String endDate
    		) 
    {      
		Customer customer = new Customer(firstName, lastName, address);
		
		Vehicle vehicle = new Vehicle(registration, manufacturer, colour);
		
		Booking b = new Booking(customer, vehicle, startDate, endDate);
		b.id = id;
		
		System.out.println("postupdate");
		b.print();
		
		
		for(int i = 0; i < list.getList().size(); i++) {
			
			Booking tmp = list.getList().get(i);
			if(b.id == tmp.id) {
				
				tmp.getCustomer().setFirstName(b.getCustomer().getFirstName());
				tmp.getCustomer().setLastName(b.getCustomer().getLastName());
				tmp.getCustomer().setAddress(b.getCustomer().getAddress());
				tmp.getVehicle().setRegistration(b.getVehicle().getRegistration());
				tmp.getVehicle().setManufacturer(b.getVehicle().getManufacturer());
				tmp.getVehicle().setColour(b.getVehicle().getColour());
				tmp.setStartDate(b.getStartDate());
				tmp.setEndDate(b.getEndDate());
				
				break;
			}
			
		}

		String html = "";
		html += "<br>" + "<br>" + "<a href= \"../../index.jsp\">Back to main menu</a>";
				
        return Response.ok("update ok"  + html).build();        
    }
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Booking updateBookingJson(Booking e, @PathParam("id") int id) 
	{   
		
		System.out.println("id = " + id);
		
		e.print();
		
		Booking b = null;
		
		for(int i = 0; i < list.getList().size(); i++) {
			b = list.getList().get(i);
			if(b.id == id) {
							
				b.getCustomer().setFirstName(e.getCustomer().getFirstName());
				b.getCustomer().setLastName(e.getCustomer().getLastName());
				b.getCustomer().setAddress(e.getCustomer().getAddress());
				b.getVehicle().setRegistration(e.getVehicle().getRegistration());
				b.getVehicle().setManufacturer(e.getVehicle().getManufacturer());
				b.getVehicle().setColour(e.getVehicle().getColour());
				b.setStartDate(e.getStartDate());
				b.setEndDate(e.getEndDate());
				
				break;
			}
		}
		return b;
		
	}   
		
}
