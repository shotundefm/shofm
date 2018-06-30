<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/quote.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search User</title>
</head>
<body>
<hr/>
<h1 align="center"><img src="images/home2.jpg"/>Homeowner Insurance Policy - Admin Screen</h1>
<hr/>
	<h4 align="center">Welcome <%=session.getAttribute("Role")%></h4>
	<h1 align="center">Search User</h1>
	<div align="right"><a href="logout.jsp">Logout</a></div>
	<br/><br/>
	<div align="center" style="color:red">
	<h2>
	<%if(request.getAttribute("message")!= null)
	{
		out.println(request.getAttribute("message"));
	}%></h2>
	</div>
	<br/>
	<br/>
	<form name="search" action="login?action=searchUser" method="post">
	<div align="center" style="width:800px; margin:0 auto;">
		<input type="text" name="selectedUser"/>
		<button name="Search" value="Search" type="submit">Search User</button>
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