<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.cts.insurance.homequote.model.Location"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/quote.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quote</title>
<Script type="text/javascript">
function submitPage(quoteId)
{
	var retrieveQuoteForm = document.forms["retrieveQuote"];
	retrieveQuoteForm["quoteIdSelected"].value  = quoteId;
	retrieveQuoteForm.submit();
}
</Script>
</head>
<body>
<hr/>
<h1 align="center"><img src="images/home2.jpg"/>Homeowner Insurance Quote</h1>
<hr/>
	<h1 align="center">Quote Details</h1>
	<div align="right"><a href="logout.jsp">Logout</a></div>
	<form name="retrieveQuote" action="quoteSummary?action=displayQuote" method="post">
	<div align="center" style="width:800px; margin:0 auto;">
	<table bgcolor="green" border="1">
		<tr>
			<td>QuoteId</td>
			<td>Residence Type</td>
			<td>Address Line 1</td>
			<!-- <td>Address Line 2</td> -->
			<td>City</td>
			<td>State</td>
			<td>Zip</td>
			<td>Residence Use</td>
			<td>Click on the column to know more</td>
			
		</tr>
		<%
					List<Location> locationList = (List<Location>) request.getAttribute("locationList");
						if (locationList.size() > 0) {
							for (Location loc : locationList) {
		%>
		
		<tr>
			<td><%=loc.getQuoteId()%></td>
			<td><%=loc.getResidenceType()%></td>
			<td><%=loc.getAddressLine1()%></td>
			<!-- <td><%-- =loc.getAddressLine2()--%></td>-->
			<td><%=loc.getCity()%></td>
			<td><%=loc.getState()%></td>
			<td><%=loc.getZip()%></td>
			<td><%=loc.getResidenceUse()%></td>
			<td><img src="images/arrow1.jpg" onclick="submitPage('<%=loc.getQuoteId()%>')"/></td>
		</tr>
		<%
							}
						}
		%>
	</table>
	<input type="hidden" name="quoteIdSelected"/>
	</div>
	</form>
	<script type="text/javascript">
		document.getElementById("quote").src = "images/tick.jpg";
		document.getElementById("Quote").className = "header1";
	</script>
</body>
</html>