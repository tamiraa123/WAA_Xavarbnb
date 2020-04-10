<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Booked</title>
<style type="text/css">@import url("<spring:url value="css/main.css"/>");</style>
<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet">
</head>
<body>
<div id="global">
<a href=" <spring:url value="/welcome" /> "> Home </a>

    <h4>The property has been booked.</h4>
    <p>
        <h5>Details:</h5>
        Renter: ${newBooking.renter.id}<br/>
        Property: ${newBooking.property.id}<br/>
        Booking Id: ${newBooking.id}<br/>
        Check In Date: ${newBooking.checkIn}<br/>
        Check Out Date: ${newBooking.checkOut}<br/>
        Number of Guests: ${newBooking.numberOfGuests}<br/>
    </p>
    
  <!-- <a href=" <spring:url value="/employees/list" /> "> List Employees </a>  --> 
    
</div>
</body>
</html>