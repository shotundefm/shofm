/**
 * This DAO class is used to for Homeowner Information
 *
 * @author Cognizant
 * @contact Cognizant
 * @version 1.0
 */
package com.cts.insurance.homequote.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.cts.insurance.homequote.exception.HomequoteSystemException;
import com.cts.insurance.homequote.model.Homeowner;
import com.cts.insurance.homequote.model.User;
import com.cts.insurance.homequote.util.HomeInsuranceConstants;
import com.cts.insurance.homequote.util.SqlQueries;

public class HomeownerDAO {

	private final static Logger LOG = Logger.getLogger(HomeownerDAO.class);

	static Connection conn = null;

	
	/**
	 * @param homeowner
	 */
	public void saveHomeowner(final Homeowner homeowner) throws HomequoteSystemException {
		LOG.info("HomeownerDAO.saveHomeowner - starts");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		try{
			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
			conn = daoFactory.getConnection();
			
			stmt = conn.prepareStatement(SqlQueries.SAVE_HOMEOWNER);
			stmt.setInt(1, homeowner.getQuoteId());
			stmt.setString(2, homeowner.getFirstName());
			stmt.setString(3, homeowner.getLastName());
			stmt.setString(4, homeowner.getDob());
			stmt.setString(5, homeowner.getIsRetired());
			stmt.setString(6, homeowner.getSsn());
			stmt.setString(7, homeowner.getEmailAddress());
			try {
			stmt.executeUpdate();
			}catch(SQLException e) {
				System.out.println("Home owner saving exception " + e.getMessage());
			}
			System.out.println("homeowner saved");
			
			
		}
		catch(Exception e)
		{
			throw new HomequoteSystemException(e.getMessage());
		}

	}

	/**
	 * @param quoteId
	 */
	public Homeowner getHomeowner(final int quoteId) throws HomequoteSystemException {
		LOG.info("HomeownerDAO.getHomeowner - starts");
		Connection conn = null;
		Homeowner homeowner = null;
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		Homeowner owner = null;

		try {

			final AbstractDAOFactory daoFactory = AbstractDAOFactory.getDaoFactory(HomeInsuranceConstants.MYSQL);
			System.out.println("quote id = " + quoteId);
			conn = daoFactory.getConnection();
			stmt = conn.prepareStatement(SqlQueries.GET_HOMEOWNER);
			stmt.setInt(1, quoteId);
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				homeowner = new Homeowner();
				homeowner.setQuoteId(resultSet.getInt(1));
				homeowner.setFirstName(resultSet.getString(2));
				homeowner.setLastName(resultSet.getString(3));
				homeowner.setDob(resultSet.getString(4));
				homeowner.setIsRetired(resultSet.getString(5));
				homeowner.setSsn(resultSet.getString(6));
				homeowner.setEmailAddress(resultSet.getString(7));
				
				
				

				// ......
			}
			stmt.close();
		} catch (SQLException e) {
			throw new HomequoteSystemException(e.getMessage());
		} catch (Exception e) {
			throw new HomequoteSystemException(e.getMessage());
		} finally {
			try {
				resultSet.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				LOG.error("Exception while trying to close Connection : " + e.getMessage());
			}
		}
		LOG.info("LoginDAO.getUser - ends");

		return homeowner; // return Object
	}

}
