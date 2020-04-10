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
						src="data:image/png;base64, ${property.propertyImage}"
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
						<a href="#" class="btn btn-warning btn-large"
							onclick="make_visible('formInput');return false;"> <span
							class="glyphicon-shopping-cart glyphicon"></span> Add Amenity
						</a> <a href="<spring:url value="/welcome" />" class="btn btn-default">
							<span class="glyphicon-hand-left glyphicon"></span> back
						</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	
	<div id="result" style="display:none" >   	
    	    <p id="success" > 
    
    		</p> 
    		<p id="errors" > 
    
    		</p>
    	</div>
	
	<div id="formInput" style="display: none">

		<h3 align="center">Amenity</h3>

		<!-- No action method handled by AJAX-->
		<form id="amenityForm" method="post">

			<input type="hidden" name="propertyId" value="${property.id}">

			<p>
				<label for="name"> Name : </label> <input type="text" name="name"
					id="name" value="" />
			</p>

			<p>
				<label for="description"> Description: </label> <input
					id="description" name="description" type="text" />
			</p>

			<input type="button" value="Add Amenity"
				onclick="amenitySubmit();return false;">

		</form>
		<h4 align="center">
			<a href="#"
				onclick="make_hidden('formInput'); make_hidden('result');resetForm('amenityForm');">
				<b>EXIT</b>
			</a>
		</h4>

	</div>
</body>
</html>
