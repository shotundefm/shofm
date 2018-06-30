/**
 * This class is the Data Object for Location
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.model;

import javax.servlet.http.HttpSession;

import com.cts.insurance.homequote.bo.LocationBO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;

public class Location
{
	private int quoteId = 0;
	private String residenceType = null;
	private String addressLine1 = null;
	private String addressLine2 = null;
	private String city = null;
	private String state = null;
	private String zip = null;
	private String residenceUse = null;
	private String userName = null;
	
	
	LocationBO loc = new LocationBO ();
	//loc.quoteId;

	
	/**
	 * @return the quoteId
	 */
	public int getQuoteId() {
		
		return quoteId;
	}
	/**
	 * @param quoteId the quoteId to set
	 */
	public void setQuoteId(final int quoteId) {
		this.quoteId = quoteId;
	}
	/**
	 * @return the residenceType
	 */
	public String getResidenceType() {
		return residenceType;
	}
	/**
	 * @param residenceType the residenceType to set
	 */
	public void setResidenceType(final String residenceType) {
		this.residenceType = residenceType;
	}
	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(final String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}
	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(final String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(final String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(final String state) {
		this.state = state;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(final String zip) {
		this.zip = zip;
	}
	/**
	 * @return the residenceUse
	 */
	public String getResidenceUse() {
		return residenceUse;
	}
	/**
	 * @param residenceUse the residenceUse to set
	 */
	public void setResidenceUse(final String residenceUse) {
		this.residenceUse = residenceUse;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}
	
}
