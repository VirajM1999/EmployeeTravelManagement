<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Home Page</title>
<link href="./../css/managerhomepage.css" rel="stylesheet">
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
					href="backtomanagerhome">Back</a></li>
				
			</ul>
</nav>
</header>

<main class="main-content">
    <section class="table-section">
    <h2>Requests Rejected by Travel Agent</h2>
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
    <c:forEach var="travelRequestDetails" items="${notification}">
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