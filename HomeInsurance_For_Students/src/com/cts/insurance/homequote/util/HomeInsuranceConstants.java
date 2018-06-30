/**
 * IHomeInsuranceConstants
 * Holds the constants for HomeInsuranceQuote Application
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.util;

public final class HomeInsuranceConstants
{
	
	//Location Page
	 public static final String RESIDENCE_TYPE = "residenceType";
	 public static final String ADDRESS_LINE_1 = "addressLine1";
	 public static final String ADDRESS_LINE_2 = "addressLine2";
	 public static final String CITY	= "city";
	 public static final String STATE = "state";
	 public static final String ZIP = "zip";
	 public static final String RESIDENCE_USE = "residenceUse";
	
	
	//HomeownerInfo Page
	 public static final String FIRST_NAME = "firstName";
	 public static final String LAST_NAME = "lastName";
	 public static final String DATE_OF_BIRTH = "dob";
	 public static final String IS_RETIRED = "isRetired";
	 public static final String SSN = "ssn";
	 public static final String EMAIL_ADDRESS = "emailAddress";
	
	//Property Page
	 public static final String MARKET_VALUE = "marketValue";
	 public static final String YEAR_BUILT = "yearBuilt";
	 public static final String SQUARE_FOOTAGEG = "squareFootage";
	 public static final String DWELLING_STYLE = "dwellingStyle";
	 public static final String ROOF_MATERIAL = "roofMaterial";
	 public static final String GARAGE_TYPE = "garageType";
	 public static final String NUM_FULL_BATHS = "numFullBaths";
	 public static final String NUM_HALF_BATHS = "numHalfBaths";
	 public static final String HAS_SWIMMING_POOL = "hasSwimmingPool";
	
	//DAO values
	 public static final String MYSQL = "MySQL";
	
	//Quote constants
	//Rate - cost of home insurance per exposure
	 public static final int RATE = 5;
	 public static final int EXPOSURE_UNITS = 1000;
	 public static final int CONS_COST_PER_SF = 120;
	 public static final int MEDICAL_EXPENSE = 5000;
	/**
	 * Success forward page
	 */
	 public static final String GET_STARTED = "/getStarted.jsp";
	 public static final String SEARCH_USER = "/searchUser.jsp";
	 public static final String HOMEOWNER_INFO = "/homeownerInfo.jsp";
	 public static final String PROPERTY = "/property.jsp";
	 public static final String QUOTE = "/quote.jsp";
	 public static final String QUOTE_SUMMARY = "/quoteSummary.jsp";
	 public static final String RETRIEVE_QUOTE = "/retrieveQuote.jsp";
	 public static final String CONFIRM = "/confirmation.jsp";
	 public static final String POLICY_DETAILS = "/policyDetails.jsp";
	 public static final String POLICY = "/policy.jsp";
	 public static final String LOGOUT = "/logout.jsp";
	/**
	 * Error page forward
	 */
	 public static final String ERROR ="/error.jsp";
	 public static final String MESSAGE = "message";
	
	/**
	 * Policy Status
	 */
	 public static final String STATUS_ACTIVE = "ACTIVE";
	 public static final String STATUS_CANCELLED = "CANCELLED";
	 public static final String STATUS_RENEWED = "RENEWED";
	/**
	 * 
	 */
	public static final String USER_NAME = "userName";
	 
	 // PRIVATE //

	  /**
	   The caller references the constants using <tt>IHomeInsuranceConstants.EMPTY_STRING</tt>, 
	   and so on. Thus, the caller should be prevented from constructing objects of 
	   this class, by declaring this private constructor. 
	  */
	  private HomeInsuranceConstants(){
	    //this prevents even the native class from 
	    //calling this constructor as well :
	    throw new AssertionError();
	  }
}
