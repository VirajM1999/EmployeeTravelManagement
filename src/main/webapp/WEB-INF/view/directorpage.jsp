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
					href="directorlogout">Logout</a></li>
			</ul>
		</nav>
	</header>

	<main class="main-content">
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
						<th colspan="2">Action</th>
						<!-- <th>Action</th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach var="requestrejectedbyagent"
						items="${RequestRejectedByTravelAgentKey}">
						<tr>
							<td>${requestrejectedbyagent.travelRequestId}</td>
							<td>${requestrejectedbyagent.name}</td>
							<td>${requestrejectedbyagent.reason}</td>
							<td>${requestrejectedbyagent.fromDate}</td>
							<td>${requestrejectedbyagent.toDate}</td>
							<td>${requestrejectedbyagent.destination}</td>
							<td>${requestrejectedbyagent.region}</td>
							<td>${requestrejectedbyagent.travelMode}</td>
							<td>${requestrejectedbyagent.status}</td>
							<td>${requestrejectedbyagent.employeeTravelDetails.employeeId}</td>

							<td>
								<ul class="main-nav__items">
									<li class="main-nav__item main-nav__item__cta"><a
										href="Accepted/${requestrejectedbyagent.travelRequestId}">Approve</a></li>
								</ul>
							</td>
							<td>
								<ul class="main-nav__items">
									<li class="main-nav__item main-nav__item__cta"><a
										href="Rejected/${requestrejectedbyagent.travelRequestId}">Reject</a></li>
								</ul>
							</td>

						</tr>
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