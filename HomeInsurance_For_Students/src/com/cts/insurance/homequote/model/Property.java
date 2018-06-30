/**
 * This class is the Data Object for Property
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.model;

public class Property {
	private int quoteId = 0;
	private int marketValue = 0;
	private int yearBuilt = 0;
	private int squareFootage = 0;
	private int dwellingStyle = 0;
	private String roofMaterial = null;
	private String garageType = null;
	private int numFullBaths = 0;
	private int numHalfBaths = 0;
	private boolean hasSwimmingPool = false;
	
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
	 * @return the marketValue
	 */
	public int getMarketValue() {
		return marketValue;
	}
	/**
	 * @param marketValue the marketValue to set
	 */
	public void setMarketValue(final int marketValue) {
		this.marketValue = marketValue;
	}
	/**
	 * @return the yearBuilt
	 */
	public int getYearBuilt() {
		return yearBuilt;
	}
	/**
	 * @param yearBuilt the yearBuilt to set
	 */
	public void setYearBuilt(final int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	/**
	 * @return the squareFootage
	 */
	public int getSquareFootage() {
		return squareFootage;
	}
	/**
	 * @param squareFootage the squareFootage to set
	 */
	public void setSquareFootage(final int squareFootage) {
		this.squareFootage = squareFootage;
	}
	/**
	 * @return the dwellingStyle
	 */
	public int getDwellingStyle() {
		return dwellingStyle;
	}
	/**
	 * @param dwellingStyle the dwellingStyle to set
	 */
	public void setDwellingStyle(final int dwellingStyle) {
		this.dwellingStyle = dwellingStyle;
	}
	/**
	 * @return the roofMaterial
	 */
	public String getRoofMaterial() {
		return roofMaterial;
	}
	/**
	 * @param roofMaterial the roofMaterial to set
	 */
	public void setRoofMaterial(final String roofMaterial) {
		this.roofMaterial = roofMaterial;
	}
	/**
	 * @return the garageType
	 */
	public String getGarageType() {
		return garageType;
	}
	/**
	 * @param garageType the garageType to set
	 */
	public void setGarageType(final String garageType) {
		this.garageType = garageType;
	}
	/**
	 * @return the numFullBaths
	 */
	public int getNumFullBaths() {
		return numFullBaths;
	}
	/**
	 * @param numFullBaths the numFullBaths to set
	 */
	public void setNumFullBaths(final int numFullBaths) {
		this.numFullBaths = numFullBaths;
	}
	/**
	 * @return the numHalfBaths
	 */
	public int getNumHalfBaths() {
		return numHalfBaths;
	}
	/**
	 * @param numHalfBaths the numHalfBaths to set
	 */
	public void setNumHalfBaths(final int numHalfBaths) {
		this.numHalfBaths = numHalfBaths;
	}
	/**
	 * @return the hasSwimmingPool
	 */
	public boolean isHasSwimmingPool() {
		return hasSwimmingPool;
	}
	/**
	 * @param hasSwimmingPool the hasSwimmingPool to set
	 */
	public void setHasSwimmingPool(final boolean hasSwimmingPool) {
		this.hasSwimmingPool = hasSwimmingPool;
	}
}
