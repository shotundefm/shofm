<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get a Quote</title>
<link rel="stylesheet" href="css/quote.css">
<script type="text/javascript">
window.history.forward();     
function noBack() 
{ 
	window.history.forward();
}
</script>
</head>
<body onload="noBack();" onunload="">
	<h1 align="center"><img src="images/home2.jpg"/>Homeowner Insurance Quote</h1>
	
	<div align="right"><a href="logout.jsp">Logout</a></div>
	
	<div align="center" class ="getquote" style="width:800px; margin:0 auto;">
		<br />
		<h1>Get an online quote</h1>
		<br />
		<table>
			<tr>
				<td><img src="images/home.jpg" alt="Home Insurance" />
				</td>
			</tr>
			<tr>
				<td>
				<form action="location.jsp">
				<img align="middle" src="images/arrowblue.jpg" />
				<button class="primary" name="GetQuote" type="submit">Get a Quote</button>
				</form>
				</td>
			</tr>
			<tr>
				<td>
				<form action="quoteSummary?action=getQuotes" method="post">
				<img align="middle" src="images/arrowblue.jpg" />
				<button class="primary" name="RetrieveQuote" type="submit">Retrieve Quote</button>
				</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>