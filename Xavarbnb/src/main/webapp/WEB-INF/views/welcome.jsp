<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html  xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>OpenHouse by TEMPLATED</title>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Abel' rel='stylesheet' type='text/css' />
<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet">
</head>
<body>
<div id="header">
	<div id="logo">
		<h1><a href="<spring:url value='/welcome' />">XavarBnB</a></h1>
	</div>
	<div id="menu">
			
		<ul>
		<security:authorize access="isAuthenticated()">
  					<li>Welcome  <security:authentication property="principal.username" /></li>
  					
  					<security:authorize access="isAuthenticated()">
	  					<li><a href="<spring:url value='/property/add' />" accesskey="4" title="">Create Hosting</a></li>
						<li><a href="<spring:url value='/signout' />" accesskey="4" title="">Sign Out</a></li>
					</security:authorize>
		</security:authorize>
		<security:authorize access="isAnonymous()">
			<li><a href="<spring:url value='/signin' />" accesskey="4" title="">Sign In</a></li>
			<li><a href="<spring:url value='/signup' />" accesskey="5" title="">Register</a></li>
		</security:authorize>
		</ul>
	</div>
</div>
<div id="banner-wrapper">
	<div id="banner"></div>
</div>

<div id="searchgroup" align="center">
	<form action="<spring:url value='/property/byFilter' />" method="get">
		
				<table style="width:60%;" >
				<tr><td>  <input id="city" name="city" type="text" placeholder="City Name" required/></td>
					
					<td> <input id="minPrice" name="minPrice" type="text" placeholder="Min Price"/></td>
					<td> <input id="maxPrice" name="maxPrice" type="text" placeholder="Max Price"/></td>
					<td> <input id="capacity" name="capacity" type="text" placeholder="Number of Guests"/></td>
					<td><input type="submit" id="btnFilter" value ="Search"/></td> 
				</tr>
				
				</table>
		</form>
</div>

<div id="footer-wrapper">
	<div id="footer-content">

		<c:forEach items="${properties}" var="property" varStatus="status">
		<div class="column">
				<h2><span>${property.type}</span> ${property.status}</h2>
				<%-- <p><img src="<c:url value="/images/pics01.jpg" />"  width="520" height="200" alt="" /></p> --%>
				<p>${property.description}</p>
				<p>Price: ${property.price}</p>
				<a href="<spring:url value='/property/property/${property.id}' />" class="button-style" title="">Detail</a>
		</div>	
		</c:forEach>
		
	
			
	 	<%-- <div id="fbox1">
			<h2><span>Aenean elementum</span> facilisis</h2>
			<p><img src="<c:url value="/images/pics01.jpg" />"  width="320" height="150" alt="" /></p>
			<p>Aliquam erat volutpat. Pellentesque tristique ante ut risus. Quisque dictum. Integer nisl risus, sagittis convallis, rutrum id, elementum congue, nibh. Suspendisse dictum porta lectus placerat odio.</p>
			<p class="button-style"><a href="#">Book</a></p>
		 <div id="fbox2">
			<h2><span>Praesent mattis </span> condimentum </h2>
			<p><img src="<spring:url value='/images/pics01.jpg' />"  width="320" height="150" alt="" /></p>
			<p>Aliquam erat volutpat. Pellentesque tristique ante ut risus. Quisque dictum. Integer nisl risus, sagittis convallis, rutrum id, elementum congue, nibh. Suspendisse dictum porta lectus placerat odio.</p>
			<p class="button-style"><a href="#">Book</a></p>
		</div>
		<div id="fbox3">
			<h2><span>Integer gravida</span> volutpat </h2>
			<p><img src="<spring:url value='/resource/images/pics01.jpg' />"  width="320" height="150" alt="" /></p>
			<p>Aliquam erat volutpat. Pellentesque tristique ante ut risus. Quisque dictum. Integer nisl risus, sagittis convallis, rutrum id, elementum congue, nibh. Suspendisse dictum porta lectus placerat odio.</p>
			<p class="button-style"><a href="#">Book</a></p>
		</div>  
			<div id="fbox4">
			<h2><span>Integer gravida</span> volutpat </h2>
			<p><img src="<spring:url value='/resource/images/pics01.jpg' />"  width="320" height="150" alt="" /></p>
			<p>Aliquam erat volutpat. Pellentesque tristique ante ut risus. Quisque dictum. Integer nisl risus, sagittis convallis, rutrum id, elementum congue, nibh. Suspendisse dictum porta lectus placerat odio.</p>
			<p class="button-style"><a href="#">Book</a></p>
		</div>  --%>
	</div>
</div>
<div id="footer">
	<p>&copy; Maharishi International University</p>
</div>
</body>


 <%-- <section>
		<div class="jumbotron">
			<div class="container">
				<h1> ${greeting} </h1>
				<p> ${tagline} </p>
				<p> <security:authorize access="isAuthenticated()">
  					Welcome  <security:authentication property="principal.username" />
				</security:authorize>

			</div>	 
 
				  <div class="container">
 				  <security:authorize access="isAnonymous()">
    					<a href="<spring:url value='/signin' />" class="btn btn-default pull-right"> Sign In</a>
				</security:authorize>
						<a href="<spring:url value='users/signup' />" class="btn btn-default pull-right"> Sign Up</a>
		
			
	 			<div class="pull-left"> <h3>${SpecialBlurb}</h3> </div>
		</div>	
	</section>
					<p> ${testOrder} </p>
				<p> ${homeTestOrder} </p>  --%>


</html>
