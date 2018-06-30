<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/quote.css">
<title>Homeowners Insurance Quote - New User Registration</title>
<SCRIPT LANGUAGE="JavaScript" TYPE="text/javascript">

function validate(user) {
	if(user.userName.value=="")
	{
		alert("Please enter the User name");
		user.userName.focus();
		return false;
	}

	if(user.password.value=="")
	{
		alert("Please enter your Password");
		user.password.focus();

		return false;
	}
	if (user.confirmPass.value=="")
	{
		alert("Please confirm password");
		user.confirmPass.focus();
		return false;
	}	
	if (user.password.value!=user.confirmPass.value)
	{
		alert("Please enter same value for password and re-enter password");
		return false;
	}
}
</script>

</head>
<body>
<hr/>
<h1 align="center"><img src="images/home2.jpg"/>Homeowner Insurance Quote</h1>
<hr/>
<br />
<div align="center" style="width:800px; margin:0 auto;">
<form name="registration" action="login?action=newUser" method="post">
<jsp:useBean id='user' scope='session' class='com.cts.insurance.homequote.model.User' type="com.cts.insurance.homequote.model.User" />
	<table>
		<tr>
			<th colspan="2">For New users:</th>
		</tr>
		<tr></tr>
		<tr>
			<td>Username :</td>
			<td width="70%"><input value='<jsp:getProperty name="user" property="userName"/>' name="userName" value=""/></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td width="70%"><input type="password" name="password" value='<jsp:getProperty name="user" property="password"/>' name="password" value=""/></td>
		</tr>
		<tr>
			<td>Re-enter password</td>
			<td width="70%"><input type="password" name="confirmPass" value='<jsp:getProperty name="user" property="password"/>' name="password" value=""/></td>
		</tr>
		<tr></tr>
		<tr>
			<td colspan=2 align="center"><input type="submit" value="Login"
				onclick="return validate(user);" />
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>