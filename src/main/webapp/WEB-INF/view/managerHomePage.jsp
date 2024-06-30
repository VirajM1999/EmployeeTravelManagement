<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/managerHomePage.css" rel="stylesheet">
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
					href="manager/Notifications">Notifications</a></li>
				<li class="main-nav__item main-nav__item__cta"><a
					href="managerlogout">Logout</a></li>
			</ul>
		</nav>
	</header>

	<main class="main-content">
		<section class="table-section">
			<h2>Employee Pending Requests</h2>
			<table class="styled-table">
				<thead>
					<tr>
						<th>Employee ID</th>
						<th>Travel Request ID</th>
						<th>Name</th>
						<th>Reason</th>
						<th>From Date</th>
						<th>To Date</th>
						<th>Destination</th>
						<th>Region</th>
						<th>Travel Mode</th>
						<th>Status</th>
						<th colspan="2">Action</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="travelRequestDetails"
						items="${employeependingreuqest}">
						<tr>
							<td>${travelRequestDetails.travelRequestId }</td>
							<td>${travelRequestDetails.getEmployeeTravelDetails().getEmployeeId() }</td>
							<td>${travelRequestDetails.name }</td>
							<td>${travelRequestDetails.reason }</td>
							<td>${travelRequestDetails.fromDate }</td>
							<td>${travelRequestDetails.toDate }</td>
							<td>${travelRequestDetails.destination }</td>
							<td>${travelRequestDetails.region }</td>
							<td>${travelRequestDetails.travelMode }</td>
							<td>${travelRequestDetails.status }</td>


							<td>
								<ul class="main-nav__items">
									<li class="main-nav__item main-nav__item__cta"><a
										href="managerApproved/${travelRequestDetails.travelRequestId}">Approve</a></li>
								</ul>
							</td>
							<td>
								<ul class="main-nav__items">
									<li class="main-nav__item main-nav__item__cta"><a
										href="managerRejected/${travelRequestDetails.travelRequestId}">Reject</a></li>
								</ul>
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</section>

	<section class="table-section">
			<h2>Request History</h2>
			<table class="styled-table">
				<thead>
					<tr>
						<th>Employee ID</th>
						<th>Travel Request ID</th>
						<th>Name</th>
						<th>Reason</th>
						<th>From Date</th>
						<th>To Date</th>
						<th>Destination</th>
						<th>Region</th>
						<th>Travel Mode</th>
						<th>Status</th>
						<th>Booked Details</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="travelRequestDetails"
						items="${travelAgentApproveRequest}">
						<tr>
							<td>${travelRequestDetails.travelRequestId }</td>
							<td>${travelRequestDetails.getEmployeeTravelDetails().getEmployeeId() }</td>
							<td>${travelRequestDetails.name }</td>
							<td>${travelRequestDetails.reason }</td>
							<td>${travelRequestDetails.fromDate }</td>
							<td>${travelRequestDetails.toDate }</td>
							<td>${travelRequestDetails.destination }</td>
							<td>${travelRequestDetails.region }</td>
							<td>${travelRequestDetails.travelMode }</td>
							<td>${travelRequestDetails.status }</td>

							<td>
								<ul class="main-nav__items">
									<li class="main-nav__item main-nav__item__cta"><a
										href="viewTravelRequestDeails/${travelRequestDetails.travelRequestId}">View</a></li>
								</ul>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		<section class="table-section">
			<h2>Your(own) Pending Requests</h2>
			<table class="styled-table">
				<thead>
					<tr>
						<th>Employee ID</th>
						<th>Travel Request ID</th>
						<th>Name</th>
						<th>Reason</th>
						<th>From Date</th>
						<th>To Date</th>
						<th>Destination</th>
						<th>Region</th>
						<th>Travel Mode</th>
						<th>Status</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="travelRequestDetails"
						items="${pendingrequest}">
						<tr>
							<td>${travelRequestDetails.travelRequestId }</td>
							<td>${travelRequestDetails.getEmployeeTravelDetails().getEmployeeId() }</td>
							<td>${travelRequestDetails.name }</td>
							<td>${travelRequestDetails.reason }</td>
							<td>${travelRequestDetails.fromDate }</td>
							<td>${travelRequestDetails.toDate }</td>
							<td>${travelRequestDetails.destination }</td>
							<td>${travelRequestDetails.region }</td>
							<td>${travelRequestDetails.travelMode }</td>
							<td>${travelRequestDetails.status }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		
		<section class="table-section">
			<h2>All Approve Requests</h2>
			<table class="styled-table">
				<thead>
					<tr>
						<th>Employee ID</th>
						<th>Travel Request ID</th>
						<th>Name</th>
						<th>Reason</th>
						<th>From Date</th>
						<th>To Date</th>
						<th>Destination</th>
						<th>Region</th>
						<th>Travel Mode</th>
						<th>Status</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="travelRequestDetails"
						items="${allApproveRequest}">
						<tr>
							<td>${travelRequestDetails.travelRequestId }</td>
							<td>${travelRequestDetails.getEmployeeTravelDetails().getEmployeeId() }</td>
							<td>${travelRequestDetails.name }</td>
							<td>${travelRequestDetails.reason }</td>
							<td>${travelRequestDetails.fromDate }</td>
							<td>${travelRequestDetails.toDate }</td>
							<td>${travelRequestDetails.destination }</td>
							<td>${travelRequestDetails.region }</td>
							<td>${travelRequestDetails.travelMode }</td>
							<td>${travelRequestDetails.status }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		
		<section class="table-section">
			<h2>All Rejected Requests</h2>
			<table class="styled-table">
				<thead>
					<tr>
						<th>Employee ID</th>
						<th>Travel Request ID</th>
						<th>Name</th>
						<th>Reason</th>
						<th>From Date</th>
						<th>To Date</th>
						<th>Destination</th>
						<th>Region</th>
						<th>Travel Mode</th>
						<th>Status</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="travelRequestDetails"
						items="${allrejectedRequest}">
						<tr>
							<td>${travelRequestDetails.travelRequestId }</td>
							<td>${travelRequestDetails.getEmployeeTravelDetails().getEmployeeId() }</td>
							<td>${travelRequestDetails.name }</td>
							<td>${travelRequestDetails.reason }</td>
							<td>${travelRequestDetails.fromDate }</td>
							<td>${travelRequestDetails.toDate }</td>
							<td>${travelRequestDetails.destination }</td>
							<td>${travelRequestDetails.region }</td>
							<td>${travelRequestDetails.travelMode }</td>
							<td>${travelRequestDetails.status }</td>
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
</body>
</html>