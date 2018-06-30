/**
 * This class is the Data Object for Quote
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.model;


public class Policy
{
	private String policyKey = null;
	private int quoteId = 0;
	private String policyEffDate = null;
	private String policyEndDate = null;
	private int policyTerm = 0;
	private String policyStatus = null;
	
	/**
	 * @return the policyKey
	 */
	public String getPolicyKey() {
		return policyKey;
	}
	/**
	 * @param policyKey the policyKey to set
	 */
	public void setPolicyKey(final String policyKey) {
		this.policyKey = policyKey;
	}
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
	 * @return the policyEffDate
	 */
	public String getPolicyEffDate() {
		return policyEffDate;
	}
	/**
	 * @param policyEffDate the policyEffDate to set
	 */
	public void setPolicyEffDate(final String policyEffDate) {
		this.policyEffDate = policyEffDate;
	}
	/**
	 * @return the policyEndDate
	 */
	public String getPolicyEndDate() {
		return policyEndDate;
	}
	/**
	 * @param policyEndDate the policyEndDate to set
	 */
	public void setPolicyEndDate(final String policyEndDate) {
		this.policyEndDate = policyEndDate;
	}
	/**
	 * @return the policyTerm
	 */
	public int getPolicyTerm() {
		return policyTerm;
	}
	/**
	 * @param policyTerm the policyTerm to set
	 */
	public void setPolicyTerm(final int policyTerm) {
		this.policyTerm = policyTerm;
	}
	/**
	 * @return the policyStatus
	 */
	public String getPolicyStatus() {
		return policyStatus;
	}
	/**
	 * @param policyStatus the policyStatus to set
	 */
	public void setPolicyStatus(final String policyStatus) {
		this.policyStatus = policyStatus;
	}
	
}
