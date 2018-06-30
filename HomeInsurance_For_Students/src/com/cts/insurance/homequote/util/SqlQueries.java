/**
 * ISqlQueries
 * Holds the SQL queries for HomeInsuranceQuote Application
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.util;

public final class SqlQueries {

	public static final String SELECT_USER = "SELECT * FROM Login where USER_NAME = ?";
	public static final String SAVE_USER = "INSERT INTO Login (USER_NAME, USER_PWD, USER_ROLE) VALUES(?, ?, ?)";

	public static final String SAVE_LOCATION = "INSERT INTO Locations (RESIDENCE_TYPE, " +
			"ADDRESS_LINE_1, ADDRESS_LINE_2, CITY, LOCATION_STATE, ZIP, RESIDENCE_USE, USER_NAME) " +
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String GET_QUOTE_ID = "SELECT QUOTE_ID from Locations where RESIDENCE_TYPE = ? and " +
			"ADDRESS_LINE_1 = ? and ADDRESS_LINE_2 = ? and CITY = ? and LOCATION_STATE = ? and ZIP = ? and RESIDENCE_USE = ? and USER_NAME = ?";
	
	public static final String SAVE_HOMEOWNER = "INSERT INTO HomeownerInfo (QUOTE_ID, FIRST_NAME, LAST_NAME, " +
			"DOB, IS_RETIRED, SSN, EMAIL_ADDRESS) VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	public static final String SAVE_PROPERTY = "INSERT INTO Property (QUOTE_ID, MARKET_VALUE, YEAR_BUILT, " +
			"SQUARE_FOOTAGE, DWELLING_STYLE, ROOF_MATERIAL, GARAGE_TYPE, NUM_FULL_BATHS, " +
			"NUM_HALF_BATHS, HAS_SWIMMING_POOL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String SAVE_QUOTE = "INSERT INTO Quote (QUOTE_ID, PREMIUM, DWELLING_COVERAGE, DETACHED_STRUCTURE, " +
			"PERSONAL_PROPERTY, ADDNL_LIVING_EXPENSE, MEDICAL_EXPENSE, DEDUCTIBLE) VALUES " +
			"(?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String GET_LOCATION = "select * from Locations where QUOTE_ID = ?";
	public static final String GET_HOMEOWNER = "select * from HomeownerInfo where QUOTE_ID = ?";
	public static final String GET_PROPERTY = "select * from Property where QUOTE_ID = ?";
	public static final String GET_QUOTE = "select * from Quote where QUOTE_ID = ?";
	
	public static final String GET_LOCS_FOR_USER = "select * from Locations where USER_NAME = ?";
	public static final String GET_ALL_DETAILS = "select * from Locations l, HomeownerInfo h, Property p, Quote q " +
			"where l.QUOTE_ID = ? and h.QUOTE_ID = l.QUOTE_ID and p.QUOTE_ID = l.QUOTE_ID and q.QUOTE_ID = l.QUOTE_ID";
	
	public static final String SAVE_POLICY = "INSERT INTO Policys (POLICY_KEY, QUOTE_ID, POLICY_EFFECTIVE_DATE, " +
			"POLICY_END_DATE, POLICY_TERM, POLICY_STATUS) VALUES (?, ?, ?, ?, ?, ?)";
	
	public static final String GET_POLICIES = "SELECT * from Policys p, Locations l where p.QUOTE_ID= l.QUOTE_ID and l.USER_NAME = ?";
	public static final String GET_POLICY = "SELECT * from Policys where POLICY_KEY = ?";
	public static final String RENEW_POLICY = "UPDATE Policys SET POLICY_TERM = POLICY_TERM + 1, POLICY_STATUS = 'RENEWED' where POLICY_KEY = ?";
	public static final String CANCEL_POLICY = "UPDATE Policys SET POLICY_STATUS = 'CANCELLED', POLICY_END_DATE=? where POLICY_KEY = ?";
	// PRIVATE //

	  /**
	   The caller references the constants using <tt>ISqlQueries.EMPTY_STRING</tt>, 
	   and so on. Thus, the caller should be prevented from constructing objects of 
	   this class, by declaring this private constructor. 
	  */
	  public SqlQueries(){
	    //this prevents even the native class from 
	    //calling this constructor as well :
	    throw new AssertionError();
	  }
}
