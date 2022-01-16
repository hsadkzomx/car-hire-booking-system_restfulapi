<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="webapi/bookingservice/createbookingweb" method="POST">

		Please enter the booking details below: 
        <br>
        Customer First Name
        <input type="text" name="firstName"> 
        <br>
        Customer Last Name
        <input type="text" name="lastName"> 
        <br>
        Customer Address
        <input type="text" name="address"> 
        <br>
        <br>
        Vehicle Registration
        <input type="text" name="registration"> 
        <br>
        Vehicle Manufacturer
        <input type="text" name="manufacturer"> 
        <br>
        Vehicle Colour
        <input type="text" name="colour"> 
        <br>
        <br>
        Booking Start Date
        <input type="text" name="startDate"> 
        <br>
        Booking End Date
        <input type="text" name="endDate"> 
        <br>
        <input type="submit" value="Submit">
        <br>
        <a href="index.jsp">Back to main menu</a>

	</form>
	

</body>
</html>