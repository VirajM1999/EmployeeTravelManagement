<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Page</title>
<link href="./../css/bookingpage.css" rel="stylesheet">
</head>
<body>

	<header class="main-header">
		<nav class="main-nav">
			<div class="left">
				<img src="./../images/logo.jpg" alt="Your Logo" class="logo">
				<ul>
					<li>Employee Travel and Reimbursement System</li>
				</ul>
			</div>
			<!-- <ul class="main-nav__items">
				<li class="main-nav__item main-nav__item__cta">
					<a href="#">Logout</a>
				</li> -->
			</ul>
		</nav>
	</header>
	
	<main class="main-content">
		<div class="container">
			<f:form action="addBookingDetails" modelAttribute="bookingDetailsKey">
				<h2>Booking Details</h2>
				<table>
					<tr>
						<td>Travel Request ID:</td>
						<td><f:input path="travelRequestDetails.travelRequestId" readonly="true" /></td>
					</tr>
					<tr>
						<td>Employee Name:</td>
						<td>
							<input type="text" value="${bookingDetailsKey.travelRequestDetails.name}" readonly="readonly">
						</td>
					</tr>
					<%-- <tr>
						<td>Email Id:</td>
						<td>
							<input type="text" value="${bookingDetailsKey.travelRequestDetails.emailId}" readonly="readonly">
						</td>
					</tr> --%>
					<tr>
						<td>From date:</td>
						<td>
							<f:input path="fromDate" value="${bookingDetailsKey.travelRequestDetails.fromDate}" pattern="\d{4}-\d{2}-\d{2}" readonly="true" />
						</td>
					</tr>
					<tr>
						<td>To Date:</td>
						<td>
							<f:input path="toDate" value="${bookingDetailsKey.travelRequestDetails.toDate}" pattern="\d{4}-\d{2}-\d{2}" readonly="true" />
						</td>
					</tr>
					<tr>
						<td>Travel Mode:</td>
						<td>
							<f:input path="travelMode" value="${bookingDetailsKey.travelRequestDetails.travelMode}" readonly="true" />
						</td>
					</tr>
					<tr>
						<td>Destination:</td>
						<td>
							<f:input path="destination" value="${bookingDetailsKey.travelRequestDetails.destination}" readonly="true" />
						</td>
					</tr>
					<tr>
						<td>Region:</td>
						<td>
							<f:input path="region" value="${bookingDetailsKey.travelRequestDetails.region}" readonly="true" />
						</td>
					</tr>
					<tr>
						<td>Travel Mode Name:</td>
						<td><f:input path="travelModeName" /></td>
					</tr>
					<tr>
						<td>Accomodation:</td>
						<td>
							<f:textarea path="accomodation" />
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Add Booking Details"></td>
					</tr>
						
				</table>
			</f:form>
		</div>
	</main>
	
	<footer class="main-footer">
	    <nav>
	      <ul class="main-footer__links">
	        <li class="main-footer__link"><a href="#">Support</a></li>
	        <li class="main-footer__link"><a href="#">Terms of Use</a></li>
	      </ul>
	    </nav>
	</footer>

</body>
</html>