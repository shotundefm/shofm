<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERROR</title>
</head>
<body>
<hr/>
	<h1 align="center"><img src="images/home2.jpg"/>Homeowner Insurance</h1>
	<hr/>
	<br />
		<div id="content" align="center">
			<table>
				<tr>
					<td><img src="images/Error.bmp" />
					</td>
					<td >Sorry the Application has encountered the
						following error : <br><%=request.getAttribute("message")%>.&nbsp;<br>
						Please check with the Administrator.</td>
				</tr>
			</table>
		</div>
		<table align="center">
			<tr>
				<td height="1" bgcolor="#CCCCCC" width="976"></td>
			</tr>
			
		</table>
</body>
</html>