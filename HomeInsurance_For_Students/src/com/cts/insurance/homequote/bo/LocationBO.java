/**
 * This Business Object class is used to for Location Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cts.insurance.homequote.dao.LocationDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Location;

public class LocationBO {
	
	

	/**
	 * @param location
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public int saveHomeLocation(final Location location) throws HomequoteBusinessException{
		
		int quoteId = -3;

		final LocationDAO locationDAO = new LocationDAO();
		try {
			System.out.println("passing on to location dao");
			 quoteId = locationDAO.saveLocation(location);
			 try {
				quoteId = locationDAO.getQuoteId();
			} catch (ClassNotFoundException | IOException | SQLException e) {
				System.out.println("new_quote_id exception " + e);
			}
		} catch (HomequoteSystemException e) {
			throw new HomequoteBusinessException(e.getMessage());
			
		}
		
		return quoteId ; //return integer
	}
	
	/**
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Location getHomeLocation(int quoteId) throws HomequoteBusinessException{
		Location info = null;

		final LocationDAO locationDAO = new LocationDAO();
		try {
			 info = locationDAO.getLocation(quoteId);
		} catch (HomequoteSystemException e) {
			throw new HomequoteBusinessException(e.getMessage());
			
		}
		
		return info; //return Object
	}
	
	/**
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public List<Location> getQuoteIds(String userName) throws HomequoteBusinessException{
		
		List <Location> userLocations = null;

		final LocationDAO locationDAO = new LocationDAO();
		
		try {
			 userLocations = locationDAO.getQuoteIds(userName);
		} catch (HomequoteSystemException e) {
			System.out.println("User Locations Exception " + e);
			e.printStackTrace();
			
		}


		
		
		return userLocations; //return    lst of Object
	}
	
}
