<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> -->
	<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet">
<title>Add Property</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Add Property</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newProperty" class="form-horizontal">
			<fieldset>
				<legend>NEW PROPERTY DETAIL</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div" />

				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Description:</label>
					<div class="col-lg-10">
						<form:input id="description" path="description" type="text"
							class="form:input-large" />
						<form:errors path="description" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="bedroom">Bedroom:</label>
					<div class="col-lg-10">
						<form:input id="bedroom" path="bedroom" type="text"
							class="form:input-large" />
						<form:errors path="bedroom" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="restroom">Restroom:
					</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="restroom" path="restroom" type="text"
								class="form:input-large" />
							<form:errors path="restroom" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="garage">Garage:
					</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="garage" path="garage" type="text"
								class="form:input-large" />
							<form:errors path="garage" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="title">Guests: </label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="capacity" path="capacity" type="number"
								class="form:input-large" />
							<form:errors path="capacity" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="price">Per
						Night($): </label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="price" path="price" type="number"
								class="form:input-large" />
							<form:errors path="price" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<h3>Address:</h3>
				<div class="form-group">
					<label class="control-label col-lg-2" for="street">Street:</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="street" path="address.street" type="text"
								class="form:input-large" />
							<form:errors path="address.street" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="city">City:</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="city" path="address.city" type="text"
								class="form:input-large" />
							<form:errors path="address.city" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="state">State:</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="state" path="address.state" type="text"
								class="form:input-large" />
							<form:errors path="address.state" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="zip">ZIP:</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="zip" path="address.zip" type="text"
								class="form:input-large" />
							<form:errors path="address.zip" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="zip">Status:</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:select path="status" class="form:input-large">
								<form:option value="NONE" label="--- Select ---" />
								<form:options items="${statuses}" />
							</form:select>
							<form:errors path="status" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="zip">Type:</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:select path="type" class="form:input-large">
								<form:option value="NONE" label="--- Select ---" />
								<form:options items="${types}" />
							</form:select>
							<form:errors path="type" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="zip">Picture:</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="propertyImage" path="propertyImage" type="file"
								class="form:input-large" />
							<form:errors path="propertyImage" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add Property" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>
