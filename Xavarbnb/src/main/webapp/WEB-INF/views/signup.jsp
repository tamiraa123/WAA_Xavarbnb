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

	<section class="container">
		<form:form  modelAttribute="user" class="form-horizontal">
			<fieldset id="reg">
				<legend>Register</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="firstname"> First Name</label>
					<div class="col-lg-10">
						<form:input id="firstname" path="person.firstName" type="text" class="form:input-large"/>
						<form:errors path="person.firstName" cssClass="text-danger"/>
					</div>
				</div>
				 <div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="lastname"> Last Name</label>
					<div class="col-lg-10">
						<form:input id="lastname" path="person.lastName" type="text" class="form:input-large"/>
						<form:errors path="person.lastName" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="dob">Date Of birth</label>
					<div class="col-lg-10">
						<form:input id="dob" path="person.dob" type="text" class="form:input-large"/>
						<form:errors path="person.dob" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="email">email</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="email" path="email" type="text" class="form:input-large"/>
							<form:errors path="email" cssClass="text-danger"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="userName">User Name</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="username" path="userCredentials.username" type="text" class="form:input-large"/>
							<form:errors path="userCredentials.username" cssClass="text-danger"/>
						</div>
					</div>
				</div>

	
				<div class="form-group">
					<label class="control-label col-lg-2" for="password">Password</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:password id="password" path="userCredentials.password"  class="form:input-large"/>
							<form:errors path="userCredentials.password" cssClass="text-danger"/>
						</div>
					</div>
				</div>

	
				<div class="form-group">
					<label class="control-label col-lg-2" for="verifyPassword">Verify Password</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:password  path="userCredentials.verifyPassword"  class="form:input-large"/>
							<form:errors path="userCredentials.verifyPassword" cssClass="text-danger"/>
						</div>
					</div>
				</div>

					
			
			<p>
	   		<label class="control-label col-lg-2" for="personImage">Profile Image</label>
			<form:input path="person.personImage" id="personImage"  type="file" />
			
	   		</p>
 			<form:hidden path="userCredentials.enabled" value="TRUE"  />

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
