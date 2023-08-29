<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
<h2>Flight Details</h2>
FlightNumber: ${flight.flightNumber}<br>
Operating Airlines:${flight.operatingAirlines}<br>
DepartureCity : ${flight.departureCity}<br>
ArrivalCity : ${flight.arrivalCity}<br>
Departure Date : ${flight.estimatedDepartureTime}<br>
	<br>
<h2>Enter Passenger Details</h2>
<form action="confirmRegistration" method="post">
FirstName<input type="text" name="firstName"/><br>
LastName<input type="text" name="lastName"/><br>
EmailId<input type="text" name="email"/><br>
phone<input type="text" name="phone"><br>
<input type="hidden" name="flightId" value="${flight.id}"/>
<br>
CardNumber:<input type="text" name="cardNumber"/><br>
CardHolderName:<input type="text" name="cardholdername"/><br>
Cvv-Code:<input type="text" name="cvv"/><br>
Expiry-Date:<input type="text" name="expiryDate"/><br>
<input type="submit"  value="Procced"/><br>

</form>

</body>
</html>