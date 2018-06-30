/**
 * AbstractDAOFactory
 * 
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.cts.insurance.homequote.util.HomeInsuranceConstants;

public abstract class AbstractDAOFactory {

	/**
	 * @param value
	 * @return
	 */
	public static AbstractDAOFactory getDaoFactory(final String value) {
		AbstractDAOFactory abstractDao = null;
		if (value != null && value.equals(HomeInsuranceConstants.MYSQL)) {
			abstractDao = new MySqlDAO();
		}
		return abstractDao;
	}

	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public abstract Connection getConnection() throws ClassNotFoundException,
			IOException, SQLException;
}
