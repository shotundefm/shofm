/**
 * This Business Object class is used to for Property Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;

import com.cts.insurance.homequote.dao.PropertyDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Property;

public class PropertyBO {

	/**
	 * @param quoteId
	 * @return
	 * @throws HomequoteBusinessException
	 */
	public Property getProperty(final int quoteId) throws HomequoteBusinessException{
		Property property = null;

		final PropertyDAO propertyDAO = new PropertyDAO();
		try {
			property = propertyDAO.getProperty(quoteId);
		} catch (HomequoteSystemException e) {
			System.out.println("Get property exception " + e);
			e.printStackTrace();
		}
		
		return property; //return Object;
	}
	/**
	 * @param property
	 * @throws HomequoteBusinessException
	 */
	public void saveProperty(final Property property) throws HomequoteBusinessException{

		final PropertyDAO PropertyDAO = new PropertyDAO();
		try
		{	
			PropertyDAO.saveProperty(property);
		}
		catch(HomequoteSystemException e)
		{
		System.out.println("Save property exception" + e);
		e.printStackTrace();
		
		}
		
	}
	
}
