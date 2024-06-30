<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Raise A Ticket</title>
<link rel="stylesheet" type="text/css" href="/css/raiseTicket.css">
<link rel="stylesheet" type="text/css" href="/css/employeeHomePage.css">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
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
        <h1>Raise a Travel Request</h1>
        <f:form action="raiseATicket" modelAttribute="addNewRequest">
            <label for="employeeId">Employee ID:</label>
            <f:input path="employeeTravelDetails.employeeId" value="${travelDetails.employeeId}" id="employeeId" readonly="true"/>
            
             <label for="name">Name:</label>
            <f:input path="employeeTravelDetails.name" value="${travelDetails.name}" id="name" readonly="true"/>
            
             <label for="name">Email Id:</label>
            <f:input path="employeeTravelDetails.emailId" value="${travelDetails.emailId}" id="emailId" readonly="true"/>
            
            <label for="reason">Reason:</label>
            <f:input path="reason" id="reason" required="true"/>
            
            <label for="fromDate">From Date:</label>
            <f:input type="date" path="fromDate" pattern="\d{4}-\d{2}-\d{2}" id="fromDate"  required="true"/>
            
            <label for="toDate">To Date:</label>
            <f:input type="date" path="toDate" pattern="\d{4}-\d{2}-\d{2}" id="toDate"  required="true"/>
            
            <label for="destination">Destination:</label>
            <f:input path="destination" id="destination" required="true"/>
            
            <label for="region">Region:</label>
            <f:select path="region" required="true">
                <f:option value="" label="Select Region" />
                <f:option value="Mumbai" label="Mumbai" />
                <f:option value="Maharashtra" label="Maharashtra" />
                <f:option value="India" label="India" />
                <f:option value="International" label="International" />
            </f:select>
        
            
            <label for="travelMode">Travel Mode:</label>
            <f:select path="travelMode" id="travelMode" required="true">
                <f:option value="" label="Select Mode"/>
                <f:option value="Flight" label="Flight"/>
                <f:option value="Train" label="Train"/>
                <f:option value="Bus" label="Bus"/>
                <f:option value="Cab" label="Cab"/>
            </f:select>
            
            <input type="submit" value="Add Request"/>
            
          <%--   <c:if test="${bookingsuccessful}">
                <span>Ticket Raised Successfully</span>
            </c:if> --%>
        </f:form>
    </div>

    <footer class="main-footer">
        <nav>
            <ul class="main-footer__links">
                <li class="main-footer__link"><a href="#">Support</a></li>
                <li class="main-footer__link"><a href="#">Terms of Use</a></li>
            </ul>
        </nav>
    </footer>
    
    <script>
    document.addEventListener('DOMContentLoaded', function() {
        const today = new Date().toISOString().split('T')[0];
        document.getElementById('fromDate').setAttribute('min', today);
    });
    document.addEventListener('DOMContentLoaded', function() {
        const today = new Date().toISOString().split('T')[0];
        document.getElementById('toDate').setAttribute('min', today);
    });
</script>
</body>
</html>