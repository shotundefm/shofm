<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/quote.css">
<title>Homeowners Insurance Quote</title>
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
}
</script>

</head>
<body>
	<hr/>
	<h1 align="center"><img src="images/home2.jpg"/>Homeowner Insurance Quote</h1>
	<hr/>
	<br />
	<p>Home insurance, also commonly called hazard insurance or
		homeowner's insurance, is a type of property insurance that covers a
		private residence, such as a condominium or renters' insurance or home
		or multiple unit buildings.</p>
	<p>
		It is an insurance policy that combines various personal insurance
		protections, which can include losses occurring to one's home, its
		contents, loss of use (additional living expenses), or loss of other
		personal possessions of the homeowner, as well as liability insurance
		for accidents that may happen at the home or at the hands of the
		homeowner within the policy territory. If a home does not meet the
		underwriting guidelines of a standard homeowners policy the residence
		could qualify for a limited coverage dwelling policy. <br />
	</p>
	<table>
		<tr>
			<td>
				<div align="left">
					<span class="Fld_Vl">Get the best home loan quotes here!!!</span>
				</div>
			</td>
			<td>
				<div align="left" class="login">
					<h1>Login now to get an online quote</h1>
					<br />
				
						Never logged in before? <a href="newUser.jsp">Register here</a>

						
					<form name="user" action="login?action=ExistingUser" method="post">
							
							
					<table>
						<tr>
							<th colspan="2">For Existing users:</th>
						</tr>
						<tr>
							<td>Username :</td><td> <input name="userName" /></td>
						</tr>
						<tr>
							<td>Password :</td><td> <input type="password" name="password" /></td>
						</tr>
						<tr>
							<td colspan=2 align="center"><input type="submit" value="Login" onclick="return validate(user);" /></td>
						</tr>
					</table>
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>