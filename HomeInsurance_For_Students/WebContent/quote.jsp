<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<jsp:useBean id='quote' scope='request' class='com.cts.insurance.homequote.model.Quote' type="com.cts.insurance.homequote.model.Quote" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quote</title>
<script type="text/javascript">
window.history.forward();     
function noBack() 
{ 
	window.history.forward();
}
</script>
</head>
<body onload="noBack();" onunload="">
	<%@include file="header.jsp"%>
	<hr/>
	<div style="width:800px; margin:0 auto;">
	<div align="center">
	<h1>Coverage Details</h1>
	<div align="right"><a href="logout.jsp">Logout</a></div>
	<a href="homeInsuranceQuote.html">Click here to know more</a>
	</div>
	<table align="center" >
		<tr>
			<td>Quote Id</td>
			<td><jsp:getProperty name="quote" property="quoteId" /></td>
		</tr>
		<tr>
			<td>Monthly Premuim</td>
			<td>$<jsp:getProperty name="quote" property="premium" /></td>
		</tr>
		<tr>
			<td>Dwelling Coverage</td>
			<td>$<jsp:getProperty name="quote" property="dwellingCoverage" /></td>
		</tr>
		<tr>
			<td>Detached Structures</td>
			<td>$<jsp:getProperty name="quote" property="detachedStructure" /></td>
		</tr>
		<tr>
			<td>Personal Property</td>
			<td>$<jsp:getProperty name="quote" property="personalProperty" /></td>
		</tr>
		<tr>
			<td>Additional living expense</td>
			<td>$<jsp:getProperty name="quote" property="addnlLivgExpense" /></td>
		</tr>
		<tr>
			<td>Medical expense</td>
			<td>$<jsp:getProperty name="quote" property="medicalExpense" /></td>
		</tr>
		<tr>
			<td>Deductible</td>
			<td>$<jsp:getProperty name="quote" property="deductible" /></td>
		</tr>
	</table>
	<br/>
	<div align="center">
	<form action="quoteSummary?action=getQuotes" method="post">
		<img align="middle" src="images/arrowblue.jpg" />
		<button class="primary" name="RetrieveQuote" type="submit">Retrieve Quote</button>
	</form>
	</div>
	</div>
	<script type="text/javascript">
		document.getElementById("quote").src = "images/tick.jpg";
		document.getElementById("Quote").className = "header1";
	</script>
</body>
</html>