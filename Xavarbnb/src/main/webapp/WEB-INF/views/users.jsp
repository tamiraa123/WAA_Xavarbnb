<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

 
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/ajax.js"/>"></script>
<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Members</title>

</head>
<body>
<fieldset id="reg">
<legend>User List</legend>
<form:form  id="userform">
<table style="width:100%">
	 <tr>
	    <th>First Name</th>
	    <th>Last Name</th>
	    <th>Date of Birth</th>
	    <th>Email</th>
	    <th>Username</th>
	    <th>Authority</th>
	  </tr>
			<c:forEach items="${users}" var="user">
			<tr>			
			 	<td>${user.person.firstName}</td>
				<td>${user.person.lastName}</td>
				<td>${user.person.dob}</td>
				<td>${user.email}</td>
							<%-- <td>${user.person.authority.username}</td> --%>
							<%-- <td>${user.authority.authority}</td>	 --%>		
				<td><input type="button" id="id" value="View" onclick="makeAjaxCall(${user.id});"></td>
		
 			</tr>
 			</c:forEach>
 </table>
	
	
    	<div id="result" style="display:none" >   	
    	    <p id="success" > 
    
    		</p> 
    		<p id="errors" > 
    
    		</p>
    	</div>
 
   	<div id="formInput" style="display:none;background-color:#CEBCB9" > 
 </form:form>
</fieldset>
</body>
</html>
