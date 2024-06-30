 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Travel Request Details</title>
</style>
<link rel="stylesheet" type="text/css" href="/css/viewTravelRequest.css">
<link rel="stylesheet" type="text/css" href="/css/employeeHomePage.css">
<link
    href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
    rel="stylesheet">
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
        </nav>
    </header>

    <div class="container">
        <h1>Booking Details</h1>
        <f:form action="backtohomepage">
            <div class="form-group">
                <label for="bookingId">Booking ID:</label>
                <input value="${viewTravelRequest.bookingId}" id="bookingId"
                    readonly="true" />
            </div>

            <div class="form-group">
                <label for="fromDate">From Date:</label>
                <input value="${viewTravelRequest.fromDate}" readonly="true" />
            </div>

            <div class="form-group">
                <label for="toDate">To Date:</label>
                <input value="${viewTravelRequest.toDate}" readonly="true" />
            </div>

            <div class="form-group">
                <label for="travelMode">Travel Mode:</label>
                <input value="${viewTravelRequest.travelMode}" readonly="true" />
            </div>

            <div class="form-group">
                <label for="destination">Destination:</label>
                <input value="${viewTravelRequest.destination}" readonly="true" />
            </div>

            <div class="form-group">
                <label for="region">Region:</label>
                <input value="${viewTravelRequest.region}" readonly="true" />
            </div>

            <div class="form-group">
                <label for="travelModeName">Travel Mode Name:</label>
                <input value="${viewTravelRequest.travelModeName}" readonly="true" />
            </div>

            <div class="form-group">
                <label for="accomodation">Accomodation:</label>
                <input value="${viewTravelRequest.accomodation}" readonly="true" />
            </div>

            <input type="submit" value="Back">
            
           
        </f:form>
        
        <form  action="downloadBookingTicket">
          
            <input type="submit" value="Download">
        </form>
    </div>

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