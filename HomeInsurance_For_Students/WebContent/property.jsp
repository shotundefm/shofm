<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Property Information</title>
<Script language="JavaScript" type="text/javascript">

function validateForm(property) {
	if(property.marketValue.value=="")
	{
		alert("Please enter the market value of your home");
		property.marketValue.focus();
		return false;
	}
	if(property.yearBuilt.value=="")
	{
		alert("Please enter the year built of your home");
		property.yearBuilt.focus();
		return false;
	}
	if(property.squareFootage.value=="")
	{
		alert("Please enter the Square Footage");
		property.squareFootage.focus();
		return false;
	}
	if(property.numFullBaths.value=="")
	{
		alert("Please enter the Number of Full Baths");
		property.numFullBaths.focus();
		return false;
	}
	if(property.numHalfBaths.value=="")
	{
		alert("Please enter the Number of Half Baths");
		property.numHalfBaths.focus();
		return false;
	}
	if(property.hasSwimmingPool[0].checked==false && property.hasSwimmingPool[1].checked==false )
	{
		alert("Please select an option to let us know if you have a swimming pool");
		return false;
	}
}
/*
window.history.forward();     
function noBack() 
{ 
	window.history.forward();
}*/
</script>
</head>
<body><!--  onload="noBack();" onunload=""> -->
	<%@include file="header.jsp"%>
	<hr/>
	<h1>Property Details</h1>
	<div align="right"><a href="logout.jsp">Logout</a></div>
	<form name="property" action="property" method="post">
	<div align="center" style="width:800px; margin:0 auto;">
	<table>
		<tr>
			<td>What is the market value of your home?</td>
			<td><input name="marketValue" type="text" />
			</td>
		</tr>
		<tr>
			<td>What year was your home originally built?</td>
			<td><input name="yearBuilt" type="text" />
			</td>
		</tr>
		<tr>
			<td>Square footage</td>
			<td><input name="squareFootage" type="text" />
			</td>
		</tr>
		<tr>
			<td>Dwelling style</td>
			<td><select name="dwellingStyle">
					<option value="1">1 story</option>
					<option value="1.5">1.5 story</option>
					<option value="2">2 story</option>
					<option value="2.5">2.5 story</option>
					<option value="3">3 story</option>
			</select></td>
		</tr>
		<tr>
			<td>Roof Material</td>
			<td><select name="roofMaterial">
					<option value="Concrete">Concrete</option>
					<option value="Clay">Clay</option>
					<option value="Rubber">Rubber</option>
					<option value="Steel">Steel</option>
					<option value="Tin">Tin</option>
					<option value="Wood">Wood</option>
			</select></td>
		</tr>
		<tr>
			<td>Type of Garage</td>
			<td><select name="garageType">
					<option value="Attached">Attached</option>
					<option value="Detached">Detached</option>
					<option value="Basement">Basement</option>
					<option value="Builtin">Built-in</option>
					<option value="None">None</option>
			</select></td>
		</tr>
		<tr>
			<td>Number of full baths</td>
			<td><input name="numFullBaths" type="text" />
			</td>
		</tr>
		<tr>
			<td>Number half baths</td>
			<td><input name="numHalfBaths" type="text" />
			</td>
		</tr>
		<tr>
			<td>Does your home have a swimming pool?</td>
			<td>
			<input type="radio" name="hasSwimmingPool" value="true" />Yes<BR>
			<input type="radio" name="hasSwimmingPool" value="false" />No<BR>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="Submit" value="Continue" onClick="return validateForm(property);"/>
			</td>
		</tr>
	</table>
	</div>
	</form>
	<hr/>
	<script type="text/javascript">
		document.getElementById("prop").src="images/tick.jpg";
		document.getElementById("Property").className = "header1";
	</script>
</body>
</html>