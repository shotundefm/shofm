<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.cts.insurance.homequote.model.Policy"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/quote.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Policy Details</title>
<Script type="text/javascript">
function submitPage(policyKey, action)
{
	var confirmAction=confirm("Are you sure you would like to " + action + " policy with Policy Key: " + policyKey + "?");
	if (confirmAction==true)
	{
		var policyDetails = document.forms["policyDetails"];
		policyDetails["policySelected"].value  = policyKey;
		policyDetails["actionSelected"].value  = action;
		policyDetails.submit();
	}
}
</Script>
</head>
<body>
<hr/>
<h1 align="center"><img src="images/home2.jpg"/>Homeowner Insurance Quote</h1>
<hr/>
<h4 align="center">Welcome
	<%if(session.getAttribute("Role") != null && session.getAttribute("Role").equals("Admin"))
	{
		out.print("Admin");
	}
	else
	{
		out.print(session.getAttribute("userName"));
	}
	%>
	</h4>
	<h1 align="center">Policy Details</h1>
	<div align="right"><a href="logout.jsp">Logout</a></div>
	<form name="policyDetails" action="policy?action=change" method="post">
	<div align="center" style="width:800px; margin:0 auto;">
	<table bgcolor="yellow" border="1">
		<tr>
			<td>Policy Key</td>
			<td>Quote Id</td>
			<td>Policy Effective Date</td>
			<td>Policy End Date</td>
			<td>Policy Term</td>
			<td>Policy Status</td>
			<% if(session.getAttribute("Role") != null && session.getAttribute("Role").equals("Admin"))
			{
			%>
			<td>Renew Policy</td>
			<td>Cancel Policy</td>
			<%
			}
			%>	
		</tr>
		<%
					List<Policy> policyList = (List<Policy>) request.getAttribute("policyList");
						if (policyList.size() > 0) {
							for (Policy policy : policyList) {
		%>
		
		<tr>
			<td><%=policy.getPolicyKey()%></td>
			<td><%=policy.getQuoteId()%></td>
			<td><%=policy.getPolicyEffDate()%></td>
			<td><%=policy.getPolicyEndDate()%></td>
			<td><%=policy.getPolicyTerm()%></td>
			<td><%=policy.getPolicyStatus()%></td>
			<% if(session.getAttribute("Role") != null && session.getAttribute("Role").equals("Admin"))
			{
			%>
			<td><img src="images/arrow1.jpg" onclick="submitPage('<%=policy.getPolicyKey()%>', 'Renew')"/></td>
			<td><img src="images/arrow1.jpg" onclick="submitPage('<%=policy.getPolicyKey()%>', 'Cancel')"/></td>
			<%
			}
			%>	
		</tr>
		<%
							}
						}
		%>
	</table>
	<input type="hidden" name="actionSelected"/>
	<input type="hidden" name="policySelected"/>
	</div>
	</form>
	<div align="center">
	<h3>For More quotes:</h3>
	<form action="getStarted.jsp">
		<button class="primary" name="GetQuote" type="submit">Click here</button>
	</form>
	</div>
</body>
</html>