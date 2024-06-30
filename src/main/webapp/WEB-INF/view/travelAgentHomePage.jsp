<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Travel Agent Home Page</title>
<link href="./../css/travelAgentHomePage.css" rel="stylesheet">
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
			<ul class="main-nav__items">
				<li class="main-nav__item main-nav__item__cta"><a
					href="travelAgentlogout">Logout</a></li>
			</ul>
		</nav>
	</header>

	<main class="main-content">
		<section class="table-section">

			<h2>Pending Requests</h2>

			<table class="styled-table">
				<thead>
					<tr>
						<th>Travel Request ID</th>
						<th>Employee ID</th>
						<th>Name</th>
						<th>Reason</th>
						<th>From Date</th>
						<th>To Date</th>
						<th>Destination</th>
						<th>Region</th>
						<th>Travel Mode</th>
						<th>Status</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="travelAgentRequest"
						items="${travelAgentPendingRequestKey}">
						<tr>
							<td>${travelAgentRequest.travelRequestId}</td>
							<td>${travelAgentRequest.getEmployeeTravelDetails().getEmployeeId()}</td>
							<td>${travelAgentRequest.name}</td>
							<td>${travelAgentRequest.reason}</td>
							<td>${travelAgentRequest.fromDate}</td>
							<td>${travelAgentRequest.toDate}</td>
							<td>${travelAgentRequest.destination}</td>
							<td>${travelAgentRequest.region}</td>
							<td>${travelAgentRequest.travelMode}</td>
							<td>${travelAgentRequest.status}</td>
							<td>
								<ul class="main-nav__items">
									<li class="main-nav__item main-nav__item__cta"><a
										href="travelagent/viewdetails/${travelAgentRequest.travelRequestId}">View
											Details</a></li>
								</ul>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>

		<section class="table-section">
			<h2>Director Approved Requests</h2>

			<table class="styled-table">
				<thead>
					<tr>
						<th>Travel Request ID</th>
						<th>Employee ID</th>
						<th>Name</th>
						<th>Reason</th>
						<th>From Date</th>
						<th>To Date</th>
						<th>Destination</th>
						<th>Region</th>
						<th>Travel Mode</th>
						<th>Status</th>
						<th>Actions</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="travelAgentRequest"
						items="${travelAgentDirectorRequestKey}">
						<tr>
							<td>${travelAgentRequest.travelRequestId}</td>
							<td>${travelAgentRequest.getEmployeeTravelDetails().getEmployeeId()}</td>
							<td>${travelAgentRequest.name}</td>
							<td>${travelAgentRequest.reason}</td>
							<td>${travelAgentRequest.fromDate}</td>
							<td>${travelAgentRequest.toDate}</td>
							<td>${travelAgentRequest.destination}</td>
							<td>${travelAgentRequest.region}</td>
							<td>${travelAgentRequest.travelMode}</td>
							<td>${travelAgentRequest.status}</td>

							<td>
								<ul class="main-nav__items">
									<li class="main-nav__item main-nav__item__cta"><a
										href="travelagent/bookticket/${travelAgentRequest.travelRequestId}">Book
											Ticket</a></li>
								</ul>
							</td>
					</c:forEach>
				</tbody>
			</table>
		</section>
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