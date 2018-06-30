/**
 * This Business Object class is used to for Quote Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import java.text.DecimalFormat;
import java.util.Calendar;

import com.cts.insurance.homequote.dao.QuoteDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Homeowner;
import com.cts.insurance.homequote.model.Location;
import com.cts.insurance.homequote.model.Property;
import com.cts.insurance.homequote.model.Quote;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;

public class QuoteBO {
	/**
	 * @param location
	 * @param homeowner
	 * @param property
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Quote calculateQuote(final Location location, final Homeowner homeowner, final Property property) throws HomequoteBusinessException{
		//Calculate Quote
		final Quote quote = new Quote();
	//	quote.setQuoteId(location.getQuoteId());
		System.out.println("quote retrieved in quotebo with quote id " + location.getQuoteId());
		
		
		//Calculate Premium
		//Premium = Rate x Total number of Exposure Units
		//Rate is $5 per year per $1000 of coverage
		
		double premium = HomeInsuranceConstants.RATE * property.getMarketValue() / HomeInsuranceConstants.EXPOSURE_UNITS;

		premium = processPremiumWithLoc(location, premium);
		final DecimalFormat decimalFormat = new DecimalFormat("#.##");
		quote.setPremium(Double.parseDouble(decimalFormat.format(premium/12)));
		
		//Calculate Dwelling coverage
		final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		final int numYearsOld = currentYear - property.getYearBuilt();
		final int homeValue = getHomeValue(property, numYearsOld);		
		final double dwellingCov = (property.getMarketValue() * 50/100) + homeValue;
		quote.setDwellingCoverage(dwellingCov);
		quote.setDetachedStructure(quote.getDwellingCoverage()/10);
		quote.setPersonalProperty(dwellingCov * 6/100);
		quote.setMedicalExpense(HomeInsuranceConstants.MEDICAL_EXPENSE);
		quote.setAddnlLivgExpense(dwellingCov * 20/100);
		quote.setDeductible(property.getMarketValue() * 1/100);
		//Detached Structures
		if(property.getGarageType().equals("Detached") || property.getGarageType().equals("Basement"))
		{
			premium = premium +  (premium * (0.01 /100));
		}
		return quote;
	}

	/**
	 * @param location
	 * @param premium
	 * @return
	 */
	private double processPremiumWithLoc(final Location loc, final double availablePremium) {
		double premium =  availablePremium;
		final String location = loc.getResidenceType();
		//Add 0.5, .06, .07 percentage of premium
		if (location == "Single-Family") {
			premium = availablePremium + availablePremium *(0.05 /100);
		}else if (location == "Condo" ||location == "Duplex" || location == "Apartment") {
			premium = availablePremium + availablePremium * (0.06/100);
		}else premium = availablePremium +availablePremium * (0.07/100);
		
		return premium; //return double
	}

	/**
	 * @param property
	 * @param numYearsOld
	 * @return
	 */
	private int getHomeValue(final Property property, final int numYearsOld) {
		int homeValue = property.getSquareFootage() * HomeInsuranceConstants.CONS_COST_PER_SF;
		//Fill code here
		if (numYearsOld <= 5  ) {
			homeValue = homeValue - homeValue*(10/100);
		}else if(numYearsOld > 5 && numYearsOld <= 10) {
			homeValue = homeValue - homeValue*(20/100);
		}else if(numYearsOld > 10 && numYearsOld <= 20) {
			homeValue = homeValue - homeValue*(30/100);
		}else
			homeValue = homeValue - homeValue *(50/100);
		return homeValue;//return integer
	}
	
	/**
	 * @param quoteId
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Quote getQuote(final int quoteId) throws HomequoteBusinessException {
		Quote quote = null;
		final QuoteDAO quoteDAO = new QuoteDAO();
		//Fill code here
		
		try {
			quote = quoteDAO.getQuote(quoteId);
		} catch (HomequoteSystemException e) {
			System.out.println("There is getQuote exception " + e);
			e.printStackTrace();
			
		}
		return quote;//return Object
	}
	
	/**
	 * @param property
	 */
	public void saveQuote(final Quote quote) throws HomequoteBusinessException {

		final QuoteDAO quoteDAO = new QuoteDAO();
		//Fill code here
		try {
			quoteDAO.saveQuote(quote);
		} catch (HomequoteSystemException e) {
			System.out.println("There is a saveQuote exception " + e);
			e.printStackTrace();
		}
	}
}
