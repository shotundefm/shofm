<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%session.invalidate(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/quote.css">
<title>Homeowners Insurance Quote</title>
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
	<br />
	<div align="center">
		<span class="Fld_Vl">Thanks for Visiting Us !!!</span>
	</div>
	<div align="center">
		<span class="Fld_Vl">You have been logged out</span>
	</div>

	<div align="center">
		<h1>Want to login again? Click below</h1>
		<br />
		<form name="loginAgain" action="welcome.jsp" method="post">
			<button name="welcome" value="welcome" type="submit">Login</button>
		</form>
	</div>
			
</body>
</html>