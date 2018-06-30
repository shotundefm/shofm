/**
 * This Business Object class is used to for Homeowner Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.cts.insurance.homequote.dao.HomeownerDAO;
import com.cts.insurance.homequote.dao.LocationDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Homeowner;

public class HomeownerBO {
	

	/**
	 * @param quoteId
	 * @param lastName
	 * @param dob
	 * @param emailAddress
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Homeowner getHomeownerInfo(final int quoteId) throws HomequoteBusinessException{
		
		
		Homeowner homeowner= null;
		final HomeownerDAO homeownerDAO = new HomeownerDAO();
       //Fill code here (my code written bellow this line)
		
		try {
			 homeowner = homeownerDAO.getHomeowner(quoteId);
		} catch (HomequoteSystemException e) {
			throw new HomequoteBusinessException(e.getMessage());
		}
		
		
		return homeowner; //return Object
	}
	/**
	 * @param homeowner
	 * @throws HomequoteBusinessException
	 */
	public void saveHomeownerInfo(final Homeowner homeowner) throws HomequoteBusinessException{

		final HomeownerDAO homeownerDAO = new HomeownerDAO();
        //Fill code here
	
		try {
			System.out.println("passing on to homeowner dao");
			homeownerDAO.saveHomeowner(homeowner);
		} catch (HomequoteSystemException e) {
			throw new HomequoteBusinessException(e.getMessage());
			
		}
	}
	
	
	
}
