<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Travel and Reimbursement System</title>
<link href="css/employeeHomePage.css" rel="stylesheet">
</head>
<body>
	<header class="main-header">
		<nav class="main-nav">
			<div class="left">
				<img src="images/logo.jpg" alt="Your Logo" class="logo">
				<ul>
					<li>Employee Travel and Reimbursement System</li>
				</ul>
			</div>
			<ul class="main-nav__items">
				<li class="main-nav__item main-nav__item__cta"><a
					href="newemployeeTravelRequest">Raise Ticket</a></li>
				<li class="main-nav__item main-nav__item__cta"><a
					href="employeelogout">Logout</a></li>
			</ul>

		</nav>
	</header>

	<main class="main-content">
	
	<section class="table-section">
			<h2>Travel Booking History</h2>
			<table class="styled-table">
				<thead>
					<tr>
						<th>Travel Request Id</th>
						<th>Employee Name</th>
						<th>Reason</th>
						<th>From</th>
						<th>To</th>
						<th>Destination</th>
						<th>Region</th>
						<th>Travel Mode</th>
						<th>Status</th>
						<th>Employee Id</th>
						<th>Booked Details</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="traveldetailshistory" items="${showAllDetails}">
						<tr>
							<td>${traveldetailshistory.travelRequestId}</td>
							<td>${traveldetailshistory.name}</td>
							<td>${traveldetailshistory.reason}</td>
							<td>${traveldetailshistory.fromDate}</td>
							<td>${traveldetailshistory.toDate}</td>
							<td>${traveldetailshistory.destination}</td>
							<td>${traveldetailshistory.region}</td>
							<td>${traveldetailshistory.travelMode}</td>
							<td>${traveldetailshistory.status}</td>
							<td>${traveldetailshistory.employeeTravelDetails.employeeId}</td>
							<td>
								<ul class="main-nav__items">
									<li class="main-nav__item main-nav__item__cta"><a
										href="viewTravelRequestDeails/${traveldetailshistory.travelRequestId}">View</a></li>
								</ul>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	
		<section class="table-section">
			<h2>Pending Travel Requests</h2>
			<table class="styled-table">
				<thead>
					<tr>
						<th>Travel Request Id</th>
						<th>Employee Name</th>
						<th>Reason</th>
						<th>From</th>
						<th>To</th>
						<th>Destination</th>
						<th>Region</th>
						<th>Travel Mode</th>
						<th>Status</th>
						<th>Employee Id</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="traveldetailspendingstatus"
						items="${pendingstatus}">
						<tr>
							<td>${traveldetailspendingstatus.travelRequestId}</td>
							<td>${traveldetailspendingstatus.name}</td>
							<td>${traveldetailspendingstatus.reason}</td>
							<td>${traveldetailspendingstatus.fromDate}</td>
							<td>${traveldetailspendingstatus.toDate}</td>
							<td>${traveldetailspendingstatus.destination}</td>
							<td>${traveldetailspendingstatus.region}</td>
							<td>${traveldetailspendingstatus.travelMode}</td>
							<td>${traveldetailspendingstatus.status}</td>
							<td>${traveldetailspendingstatus.employeeTravelDetails.employeeId}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>

		<section class="table-section">
			<h2>Approve Travel Requests</h2>
			<table class="styled-table">
				<thead>
					<tr>
						<th>Travel Request Id</th>
						<th>Employee Name</th>
						<th>Reason</th>
						<th>From</th>
						<th>To</th>
						<th>Destination</th>
						<th>Region</th>
						<th>Travel Mode</th>
						<th>Status</th>
						<th>Employee Id</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="traveldetailsApprovestatus"
						items="${ApproveDetails}">
						<tr>
							<td>${traveldetailsApprovestatus.travelRequestId}</td>
							<td>${traveldetailsApprovestatus.name}</td>
							<td>${traveldetailsApprovestatus.reason}</td>
							<td>${traveldetailsApprovestatus.fromDate}</td>
							<td>${traveldetailsApprovestatus.toDate}</td>
							<td>${traveldetailsApprovestatus.destination}</td>
							<td>${traveldetailsApprovestatus.region}</td>
							<td>${traveldetailsApprovestatus.travelMode}</td>
							<td>${traveldetailsApprovestatus.status}</td>
							<td>${traveldetailsApprovestatus.employeeTravelDetails.employeeId}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>

		

		<section class="table-section">
			<h2>Rejected Travel Requests</h2>
			<table class="styled-table">
				<thead>
					<tr>
						<th>Travel Request Id</th>
						<th>Employee Name</th>
						<th>Reason</th>
						<th>From</th>
						<th>To</th>
						<th>Destination</th>
						<th>Region</th>
						<th>Travel Mode</th>
						<th>Status</th>
						<th>Employee Id</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="traveldetailsRejectedstatus"
						items="${RejectedDetails}">
						<tr>
							<td>${traveldetailsRejectedstatus.travelRequestId}</td>
							<td>${traveldetailsRejectedstatus.name}</td>
							<td>${traveldetailsRejectedstatus.reason}</td>
							<td>${traveldetailsRejectedstatus.fromDate}</td>
							<td>${traveldetailsRejectedstatus.toDate}</td>
							<td>${traveldetailsRejectedstatus.destination}</td>
							<td>${traveldetailsRejectedstatus.region}</td>
							<td>${traveldetailsRejectedstatus.travelMode}</td>
							<td>${traveldetailsRejectedstatus.status}</td>
							<td>${traveldetailsRejectedstatus.employeeTravelDetails.employeeId}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>




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