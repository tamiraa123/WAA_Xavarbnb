<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/ajax.js"/>"></script>

<title>Added Property</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Property</h1>
			</div>
		</div>
	</section>
	<section class="container" ng-app="cartApp">
		<div ng-controller="cartCtrl">

			<div class="row">
				<div class="col-md-5">
					<img
						src=""
						alt="image" style="width: 100%" />
				</div>

				<div class="col-md-5">
					<h3>${property.description}</h3>
					<p>
						<strong>Property ID : </strong><span class="label label-warning">${property.id}</span>
					</p>
					<p>
						<strong>Owner</strong> : ${property.owner.person.firstName}
						${property.owner.person.lastName}
					</p>
					<p>
						<strong>Bedroom</strong> : ${property.bedroom}
					</p>
					<p>
						<strong>Restroom</strong> : ${property.restroom}
					</p>
					<p>
						<strong>Garage </strong> : ${property.garage}
					</p>
					<p>
						<strong>Guests </strong> : ${property.capacity}
					</p>
					<p>
						<strong>$ ${property.price} USD/NIGHT</strong>
					</p>
					<p><strong>Amenities:</strong></p>
					<table id="tbl_amenities" border="1">
						<tr>
							<th><u>Name</u></th>
							<th><u>Description</u></th>
						</tr>
						<c:forEach items="${property.amenities}" var="amenity">
							<tr>
								<td>${amenity.name}</td>
								<td>${amenity.description}</td>
							</tr>
						</c:forEach>
					</table>
					<p ng-controller="cartCtrl">
						<a href="<spring:url value='/booking/addBooking'/>" class="btn btn-warning btn-large"
							onclick="#"> <span
							class="glyphicon-shopping-cart glyphicon"></span> Order
						</a>
						<a href="<spring:url value="/welcome" />" class="btn btn-default">
							<span class="glyphicon-hand-left glyphicon"></span> back
						</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	
</body>
</html>
