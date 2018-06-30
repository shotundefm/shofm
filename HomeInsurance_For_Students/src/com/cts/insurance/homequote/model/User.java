/**
 * This class defines the user object
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.model;

import java.io.Serializable;



public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The user name
	 */
	 private String userName = "";

	/**
	 * The login password
	 */
	 private String password = "";
	 
	 private String userRole = "";
	 
	

	/**
	 * Gets the userName
	 *
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the userName
	 *
	 * @param userName
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password
	 *
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password
	 *
	 * @param password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(final String userRole) {
		this.userRole = userRole;
	}
	
}