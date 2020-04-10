<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> -->
<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Valued Employees</h1>
				<p>Add a new one<p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form action="addBooking" method="post" modelAttribute="newBooking" class="form-horizontal"  >
			<fieldset>
				<legend>Add new booking</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
			 	<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="renterId"> User id</label>
					<div class="col-lg-10">
						<form:input id="renterId" path="renter.id" type="text" class="form:input-large"/>
						<form:errors path="renter.id" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="propertyId">Property id</label>
					<div class="col-lg-10">
						<form:input id="propertyId" path="property.id" type="text" class="form:input-large"/>
						<form:errors path="property.id" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="checkIn">Check In Date</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="checkIn" path="checkIn" type="text" class="form:input-large"/>
							<form:errors path="checkIn" cssClass="text-danger"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="checkOut">Check Out Date</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="checkOut" path="checkOut" type="text" class="form:input-large"/>
							<form:errors path="checkOut" cssClass="text-danger"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="numberOfGuests">Number of Guests</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="numberOfGuests" path="numberOfGuests" type="text" class="form:input-large"/>
							<form:errors path="numberOfGuests" cssClass="text-danger"/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
