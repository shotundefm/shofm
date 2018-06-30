/**
 * This class is the Data Object for HomeownerInfo
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.model;

public class Homeowner {
	private int quoteId = 0;
	private String firstName = null;
	private String lastName = null;
	private String dob = null;
	private String isRetired = null;
	private String ssn = null;
	private String emailAddress = null;

	

//	public Homeowner(int quoteId, String firstName, String lastName, String dob, String isRetired, String ssn,
//			String emailAddress) {
//		this.quoteId = quoteId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.dob = dob;
//		this.isRetired = isRetired;
//		this.ssn = ssn;
//		this.emailAddress = emailAddress;
//	}
	
	
	/**
	 * @return the quoteId
	 */

	public int getQuoteId() {
		return quoteId;
	}

	/**
	 * @param quoteId
	 *            the quoteId to set
	 */
	public void setQuoteId(final int quoteId) {
		this.quoteId = quoteId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(final String dob) {
		this.dob = dob;
	}

	/**
	 * @return the isRetired
	 */
	public String getIsRetired() {
		return isRetired;
	}

	/**
	 * @param isRetired
	 *            the isRetired to set
	 */
	public void setIsRetired(final String isRetired) {
		this.isRetired = isRetired;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn
	 *            the ssn to set
	 */
	public void setSsn(final String ssn) {
		this.ssn = ssn;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(final String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
