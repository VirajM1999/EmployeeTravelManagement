<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Slab</title>
<link href="./../css/checkslab.css" rel="stylesheet">
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
				<li class="main-nav__item main-nav__item__cta"><a href="#">Logout</a>
				</li>
			</ul> -->
		</nav>
	</header>

	<main class="main-content">
		<div class="container">
			<form action="checkslabdetails" method="post">
				<h2>Slab Details</h2>
				<table>
					<tr>
						<td>Travel Request ID:</td>
						<td><input type="text" name="travelRequestId"
							value="${travelRequestDetailsKey.travelRequestId}"
							readonly="readonly"></td>
					</tr>
					<tr>
						<td>Travel Mode:</td>
						<td><input type="text"
							value="${travelRequestDetailsKey.travelMode}" readonly="readonly"></td>
					</tr>
					<tr>
						<td>Destination:</td>
						<td><input type="text"
							value="${travelRequestDetailsKey.destination}"
							readonly="readonly"></td>
					</tr>
					<tr>
						<td>Region:</td>
						<td><input type="text"
							value="${travelRequestDetailsKey.region}" readonly="readonly"></td>
					</tr>
					<tr>
						<td>Amount:</td>
						<td><input type="text" name="amount" required="required"></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit" value="Check Slab">
						</td>
					</tr>

					<tr>
						<td colspan="2"><c:if test="${slabMatch}">
								<p class="success">Slab Matched. Proceed with filling
									Booking Details</p>
							</c:if> <c:if test="${slabNotMatch}">
								<p class="fail">Slab Not Matching. Please contact the
									Director</p>
							</c:if></td>
					</tr>

					<tr>
						<td colspan="2" class="slabActionRow"><c:if
								test="${slabMatch}">
								<button
									onclick="document.location='bookticket/${travelRequestDetailsKey.travelRequestId}'"
									class="slabAction">Book Ticket</button>
							</c:if> <c:if test="${slabNotMatch}">
								<button
									onclick="document.location='contactdirector/${travelRequestDetailsKey.travelRequestId}'"
									class="slabAction">Contact Director</button>
							</c:if></td>
					</tr>
				</table>
			</form>
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
