/**
 * This Action class is used to to capture the Location Information
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.bo;


import com.cts.insurance.homequote.dao.LoginDAO;
import com.cts.insurance.homequote.exception.HomequoteBusinessException;
import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.User;

public class LoginBO {

	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	public User getUser(final String userName) throws HomequoteBusinessException{

		final LoginDAO loginDAO = new LoginDAO();
		User user = null;
		try {
			user = loginDAO.getUser(userName);
		} catch (HomequoteSystemException e) {
			System.out.println("User can't login " + e);
			e.printStackTrace();
			
		}
		
		
		return user;
	}
	
	/**
	 * registerUser
	 * @param user
	 * @throws HomequoteBusinessException
	 */
	public void registerUser(final User user) throws HomequoteBusinessException{

		final LoginDAO loginDAO = new LoginDAO();
		try {
			loginDAO.saveUser(user);
		} catch (HomequoteSystemException e) {
			System.out.println("User not saved to database " + e);
			e.printStackTrace();
			
		}
	}
}
