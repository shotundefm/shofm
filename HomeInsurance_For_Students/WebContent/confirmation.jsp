<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<jsp:useBean id='policy' scope='request' class='com.cts.insurance.homequote.model.Policy' type="com.cts.insurance.homequote.model.Policy" />
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

	<%@include file="policyHeader.jsp"%>
	<hr/>
	<div style="width:800px; margin:0 auto;">
	<h1>Policy Confirmation</h1>
	<div align="right"><a href="logout.jsp">Logout</a></div>
	<h3>Our customer service representative will contact you shortly for premium collection arrangements.</h3>
	<table align="center" >
		<tr>
			<td>Quote Id</td>
			<td><jsp:getProperty name="policy" property="quoteId" /></td>
		</tr>
		<tr>
			<td>Policy Key</td>
			<td><jsp:getProperty name="policy" property="policyKey" /></td>
		</tr>
		<tr>
			<td>Policy Effective Date</td>
			<td><jsp:getProperty name="policy" property="policyEffDate" /></td>
		</tr>
		<tr>
			<td>Policy End Date</td>
			<td><jsp:getProperty name="policy" property="policyEffDate" /></td>
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
	<script type="text/javascript">
		document.getElementById("confirmImg").src = "images/tick.jpg";
		document.getElementById("confirm").className = "header1";
	</script>
</body>
</html>