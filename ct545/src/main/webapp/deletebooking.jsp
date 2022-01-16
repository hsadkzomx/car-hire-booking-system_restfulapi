<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>ACME Car Hire Booking System</h2>
    <h3>Delete a booking</h3>
    
    <form action="webapi/bookingservice/deletebookingweb" method="GET">

		Please enter the booking id to be deleted below:
		<br>
		Booking id
        <input type="text" name="id"> 
        <br>
        <input type="submit" value="Submit">
        <br>
        <a href="index.jsp">Back to main menu</a>

	</form>

</body>
</html>