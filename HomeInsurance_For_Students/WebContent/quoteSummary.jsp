<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<jsp:useBean id='location' scope='request' class='com.cts.insurance.homequote.model.Location' type="com.cts.insurance.homequote.model.Location" />
	<jsp:useBean id='homeowner' scope='request' class='com.cts.insurance.homequote.model.Homeowner' type="com.cts.insurance.homequote.model.Homeowner" />
	<jsp:useBean id='property' scope='request' class='com.cts.insurance.homequote.model.Property' type="com.cts.insurance.homequote.model.Property" />
	<jsp:useBean id='quote' scope='session' class='com.cts.insurance.homequote.model.Quote' type="com.cts.insurance.homequote.model.Quote" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/quote.css">
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
<hr/>
<h1 align="center"><img src="images/home2.jpg"/>Homeowner Insurance Quote</h1>
<hr/>
	<div style="width:800px; margin:0 auto;">
	<h1 align="center">Quote Summary</h1>
	<div align="right"><a href="logout.jsp">Logout</a></div>
	<div  align="center">
	<a href="homeInsuranceQuote.html">Click here to know more</a></div>
	<table align="center" >
		<tr>
			<td><h2>Monthly Premuim</h2></td>
			<td><h2>$<jsp:getProperty name="quote" property="premium" /></h2></td>
		</tr>
		<tr>
			<td>
			<form name="buy1" action="buyQuote.jsp" method="post">
				<input type="hidden" name="quoteIdSelected" value ='<jsp:getProperty name="location" property="quoteId" />'/>
				<button name="Buy1" value="Buy" type="submit">Buy Quote</button>
			</form>
			</td>			
		</tr>
		<tr>
			<td colspan=2><h2>Location Details</h2></td>
		</tr>
		<tr>
			<td>Quote Id</td>
			<td><jsp:getProperty name="location" property="quoteId" /></td>
		</tr>
		<tr>
			<td>Residence Type</td>
			<td><jsp:getProperty name="location" property="residenceType" /></td>
		</tr>
		<tr>
			<td>Address Line 1</td>
			<td><jsp:getProperty name="location" property="addressLine1" /></td>
		</tr>
		<tr>
			<td>Address Line 2</td>
			<td><jsp:getProperty name="location" property="addressLine2" /></td>
		</tr>
		<tr>
			<td>City</td>
			<td><jsp:getProperty name="location" property="city" /></td>
		</tr>
		<tr>
			<td>State</td>
			<td><jsp:getProperty name="location" property="state" /></td>
		</tr>
		<tr>
			<td>Zip</td>
			<td><jsp:getProperty name="location" property="zip" /></td>
		</tr>
		<tr>
			<td>Residence Use</td>
			<td><jsp:getProperty name="location" property="residenceUse" /></td>
		</tr>
		<tr>
			<td>userName</td>
			<td><jsp:getProperty name="location" property="userName" /></td>
		</tr>
		<tr>
			<td colspan=2><hr/><h2>Homeowner Details</h2></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><jsp:getProperty name="homeowner" property="firstName" /></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><jsp:getProperty name="homeowner" property="lastName" /></td>
		</tr>
		<tr>
			<td>Date of Birth</td>
			<td><jsp:getProperty name="homeowner" property="dob" /></td>
		</tr>
		<tr>
			<td>Is Retired ? - </td>
			<td><jsp:getProperty name="homeowner" property="isRetired" /></td>
		</tr>
		<tr>
			<td>Social Security Number</td>
			<td><jsp:getProperty name="homeowner" property="ssn" /></td>
		</tr>
		<tr>
			<td>Email Address</td>
			<td><jsp:getProperty name="homeowner" property="emailAddress" /></td>
		</tr>
		<tr>
			<td colspan=2><hr/><h2>Property Details</h2></td>
		</tr>
		<tr>
			<td>Market Value</td>
			<td><jsp:getProperty name="property" property="marketValue" /></td>
		</tr>
		<tr>
			<td>Year Built</td>
			<td><jsp:getProperty name="property" property="yearBuilt" /></td>
		</tr>
		<tr>
			<td>Square Footage</td>
			<td><jsp:getProperty name="property" property="squareFootage" /></td>
		</tr>
		<tr>
			<td>Dwelling Style</td>
			<td><jsp:getProperty name="property" property="dwellingStyle" /></td>
		</tr>
		<tr>
			<td>Roof Material</td>
			<td><jsp:getProperty name="property" property="roofMaterial" /></td>
		</tr>
		<tr>
			<td>Garage Type</td>
			<td><jsp:getProperty name="property" property="garageType" /></td>
		</tr>
		<tr>
			<td>Number of Full Baths</td>
			<td><jsp:getProperty name="property" property="numFullBaths" /></td>
		</tr>
		<tr>
			<td>Number of Half Baths</td>
			<td><jsp:getProperty name="property" property="numHalfBaths" /></td>
		</tr>
		<tr>
			<td>Has Swimming Pool? - </td>
			<td><jsp:getProperty name="property" property="hasSwimmingPool" /></td>
		</tr>
		<tr>
			<td colspan=2><hr/><h2>Coverage Details</h2></td>
		</tr>
		<tr>
			<td>Monthly Premuim</td>
			<td>$<jsp:getProperty name="quote" property="premium" /></td>
		</tr>
		<tr>
			<td>Dwelling Coverage</td>
			<td>$<jsp:getProperty name="quote" property="dwellingCoverage" /></td>
		</tr>
		<tr>
			<td>Detached Structures</td>
			<td>$<jsp:getProperty name="quote" property="detachedStructure" /></td>
		</tr>
		<tr>
			<td>Personal Property</td>
			<td>$<jsp:getProperty name="quote" property="personalProperty" /></td>
		</tr>
		<tr>
			<td>Additional living expense</td>
			<td>$<jsp:getProperty name="quote" property="addnlLivgExpense" /></td>
		</tr>
		<tr>
			<td>Medical expense</td>
			<td>$<jsp:getProperty name="quote" property="deductible" /></td>
		</tr>
		<tr>
			<td>Deductible</td>
			<td>$<jsp:getProperty name="quote" property="deductible" /></td>
		</tr>
		<tr>
			<td>
			<form name="buy2" action="buyQuote.jsp" method="post">
				<input type="hidden" name="quoteIdSelected" value ='<jsp:getProperty name="location" property="quoteId" />'/>
				<button name="Buy2" value="Buy" type="submit">Buy Quote</button>
			</form>
			</td>			
		</tr>
	</table>
	</div>
</body>
</html>