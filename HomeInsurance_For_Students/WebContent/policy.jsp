<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id='policy' scope='request' class='com.cts.insurance.homequote.model.Policy' type="com.cts.insurance.homequote.model.Policy" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/quote.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Policy Details</title>
<script type="text/javascript">
window.history.forward();     
function noBack() 
{ 
	window.history.forward();
}
</script>
</head>
<body onload="noBack();" onunload="">
<hr/>
<h1 align="center"><img src="images/home2.jpg"/>Homeowner Insurance Quote</h1>
<hr/>
	<h4 align="center">Welcome
	<%if(session.getAttribute("Role") != null && session.getAttribute("Role").equals("Admin"))
	{
		out.print(session.getAttribute("userName"));
	}
	else
	{
		out.print("Admin");
	}
	%>
	</h4>
	<h1 align="center">Policy Details</h1>
	<div align="right"><a href="logout.jsp">Logout</a></div>
	<form name="policyDetails" action="policy?action=change" method="post">
	<div align="center" style="width:800px; margin:0 auto;">
	<br/>
	<h4><%=request.getAttribute("successMsg")%></h4>
	<br/>
	<table bgcolor="grey" border="1">
		<tr>
			<td>Policy Key</td>
			<td><jsp:getProperty name="policy" property="policyKey" /></td>
		</tr>
		<tr>
			<td>Quote Id</td>
			<td><jsp:getProperty name="policy" property="quoteId" /></td>
		</tr>
		<tr>
			<td>Policy Effective Date</td>
			<td><jsp:getProperty name="policy" property="policyEffDate" /></td>
		</tr>
		<tr>
			<td>Policy End Date</td>
			<td><jsp:getProperty name="policy" property="policyEndDate" /></td>
		</tr>
		<tr>
			<td>Policy Term</td>
			<td><jsp:getProperty name="policy" property="policyTerm" /></td>
		</tr>
		<tr>
			<td>Policy Status</td>
			<td><jsp:getProperty name="policy" property="policyStatus" /></td>
		</tr>
	</table>
	</div>
	</form>
	<div align="center">
	<h3>For More quotes:</h3>
	<form action="getStarted.jsp">
		<button class="primary" name="GetQuote" type="submit">Click here</button>
	</form>
	</div>
	<div align="center">
	<h3>For Searching user:</h3>
	<form action="logout.jsp">
		<button class="primary" name="SearchUser" type="submit">Click here</button>
	</form>
	</div>
</body>
</html>