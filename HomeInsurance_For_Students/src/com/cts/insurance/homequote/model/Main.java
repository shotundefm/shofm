//package com.cts.insurance.homequote.model;
//
//import com.cts.insurance.homequote.bo.QuoteBO;
//import com.cts.insurance.homequote.exception.HomequoteBusinessException;
//
//public class Main {
//
//	public static void main(String[] args) throws HomequoteBusinessException {
//		
//		Location location = new Location();
//		Homeowner homeowner = new Homeowner();
//		Property property = new Property();
//		
//		QuoteBO quote = new QuoteBO();
//	
//	//processPremiumWithLoc(final Location loc, final double availablePremium) {
//		double premium = availablePremium;
//		final String location = loc.getResidenceType();
//		//Add 0.5, .06, .07 percentage of premium
//		if (location == "Single-Family") {
//			premium = availablePremium *(0.05 /100);
//		}else if (location == "Condo" ||location == "Duplex" || location == "Apartment") {
//			premium = availablePremium * (0.06/100);
//		}else premium = availablePremium * (0.07/100);
//		
//		return premium; //return double
//	}
//
//}
