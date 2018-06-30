<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homeowner Information</title>
<Script language="JavaScript" type="text/javascript">

function validateForm(homeowner) {
	if(homeowner.firstName.value=="")
	{
		alert("Please enter the First name");
		homeowner.firstName.focus();
		return false;
	}
	if(homeowner.lastName.value=="")
	{
		alert("Please enter the Last name");
		homeowner.lastName.focus();
		return false;
	}
	if(homeowner.dob.value=="")
	{
		alert("Please select the Date of Birth");
		homeowner.dob.focus();
		return false;
	}
	if(homeowner.isRetired[0].checked==false && homeowner.isRetired[1].checked==false )
	{
		alert("Please select an option for the field 'Are you Retired'");
		return false;
	}
	if(homeowner.ssn.value=="")
	{
		alert("Please enter the Social Security Number");
		homeowner.ssn.focus();
		return false;
	}
	if(homeowner.emailAddress.value=="")
	{
		alert("Please enter the Email Address");
		homeowner.emailAddress.focus();
		return false;
	}
	return true;
}
window.history.forward();     
function noBack() 
{ 
	window.history.forward();
}
</Script>
</head>
<body onload="noBack();" onunload="">
	<%@include file="header.jsp"%>
	<hr/>
	<h1>Homeowner Information</h1>
	<form name="homeowner" action="homeownerInfo" method="post">
	<div align="center" style="width:800px; margin:0 auto;">
	<table>
		<tr>
			<td>First Name</td>
			<td><input name="firstName" type="text" />
			</td><td></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input name="lastName" type="text" />
			</td><td></td>
		</tr>
		<tr>
			<td>Date of Birth</td>
			<td><input type="text" name="dob"/></td><td>(yyyy-mm-dd)
			</td>
		</tr>
		<tr>
			<td width="55%">Are you retired?</td>
			<td>
			<input type="radio" name="isRetired" value="Yes" />Yes
			<input type="radio" name="isRetired" value="No" />No
			</td><td></td>
		</tr>
		<tr>
			<td>Social Security Number</td>
			<td><input name="ssn" type="text" />
			</td><td></td>
		</tr>
		<tr>
			<td>Email Address</td>
			<td><input name="emailAddress" type="text" />
			</td><td></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" name="Submit" value="Continue" onClick="return validateForm(homeowner);"/>
			</td>
		</tr>
	</table>
	</div>
	</form>
	<hr/>
	<script type="text/javascript">
		document.getElementById("homeInfo").src="images/tick.jpg";
		document.getElementById("HomeownerInfo").className = "header1";
		//document.forms["homeowner"]["dob"].disabled = true;
	</script>
</body>
</html>