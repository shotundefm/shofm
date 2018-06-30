/**
 * This class is the Data Object for Quote
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.model;

public class Quote {
	private int quoteId = 0;
	private double premium = 0;
	private double dwellingCoverage = 0;
	private double detachedStructure = 0;
	private double personalProperty = 0;
	private double addnlLivgExpense = 0;
	private double medicalExpense = 0;
	private double deductible = 0;
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
	 * @return the premium
	 */
	public double getPremium() {
		return premium;
	}
	/**
	 * @param premium the premium to set
	 */
	public void setPremium(final double premium) {
		this.premium = premium;
	}
	/**
	 * @return the dwellingCoverage
	 */
	public double getDwellingCoverage() {
		return dwellingCoverage;
	}
	/**
	 * @param dwellingCoverage the dwellingCoverage to set
	 */
	public void setDwellingCoverage(final double dwellingCoverage) {
		this.dwellingCoverage = dwellingCoverage;
	}
	/**
	 * @return the detachedStructure
	 */
	public double getDetachedStructure() {
		return detachedStructure;
	}
	/**
	 * @param detachedStructure the detachedStructure to set
	 */
	public void setDetachedStructure(final double detachedStructure) {
		this.detachedStructure = detachedStructure;
	}
	/**
	 * @return the personalProperty
	 */
	public double getPersonalProperty() {
		return personalProperty;
	}
	/**
	 * @param personalProperty the personalProperty to set
	 */
	public void setPersonalProperty(final double personalProperty) {
		this.personalProperty = personalProperty;
	}
	/**
	 * @return the addnlLivgExpense
	 */
	public double getAddnlLivgExpense() {
		return addnlLivgExpense;
	}
	/**
	 * @param addnlLivgExpense the addnlLivgExpense to set
	 */
	public void setAddnlLivgExpense(final double addnlLivgExpense) {
		this.addnlLivgExpense = addnlLivgExpense;
	}
	/**
	 * @return the medicalExpense
	 */
	public double getMedicalExpense() {
		return medicalExpense;
	}
	/**
	 * @param medicalExpense the medicalExpense to set
	 */
	public void setMedicalExpense(final double medicalExpense) {
		this.medicalExpense = medicalExpense;
	}
	/**
	 * @return the deductible
	 */
	public double getDeductible() {
		return deductible;
	}
	/**
	 * @param deductible the deductible to set
	 */
	public void setDeductible(final double deductible) {
		this.deductible = deductible;
	}	
}
